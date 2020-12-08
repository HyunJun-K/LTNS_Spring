package com.ltns.rest_area.service;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltns.rest_area.domain.DAO;
import com.ltns.rest_area.domain.DTO;
import com.ltns.rest_area.domain.restarea.FoodMenuDAO;
import com.ltns.rest_area.domain.restarea.FoodMenuDTO;
import com.ltns.rest_area.domain.restarea.GasStationDAO;
import com.ltns.rest_area.domain.restarea.GasStationDTO;
import com.ltns.rest_area.domain.restarea.RestAreaDAO;
import com.ltns.rest_area.domain.restarea.RestAreaDTO;

import oracle.sql.TIMESTAMP;

@Service
public class ApiService {
	
	//고속도로 휴게소 기준정보 현황(위치)
	final static String endpoint0="http://data.ex.co.kr/openapi/locationinfo/locationinfoRest";
	//휴게소 이름 정리해놓은 해쉬맵을 만들어두기... 주유소 정보에 넣어야 한다...  ('휴게소'뺀 이름:휴게소코드)
	
	//주유소 가격, 업체 현황
	final static String endpoint1="http://data.ex.co.kr/openapi/business/curStateStation";
	//=> unitName에서 주유소를 잘라, 휴게소 코드를 가져와야 한다...
	//휴게소 정리가 끝나고, 휴게소 이름 정리해놓은 해쉬맵을 활용하기!  ('휴게소'뺀 이름:휴게소코드)
	
	//휴게소 푸드메뉴현황 조회 서비스
	final static String endpoint2="http://data.ex.co.kr/openapi/restinfo/restBestfoodList";
	final static String serviceKey="2082754925";
	final static String type="json";
	
	List<DTO> rAdtos=new ArrayList<DTO>();
	List<DTO> gSdtos=new ArrayList<DTO>();
	List<DTO> fMdtos=new ArrayList<DTO>();
	
	@Autowired
	private SqlSession sqlSession;
	
	DAO dao;	
	
	/*전체 작업*/
	public int refreshApiData() throws Exception {
		//sqlSession 확인
		System.out.println("sqlSession : "+sqlSession);

		int result=0;
		
		//api 가져오기
		getDTOFromJson();
		
		//기존 정보 날리기
		result=deleteAllBeforeApiDataInDB();
		
		//새 정보 넣기
		DTO[] dtos;
		
		dtos=new RestAreaDTO[rAdtos.size()];
		rAdtos.toArray(dtos);
		result=insertRestAreaByDTOs(dtos);
		
//		dtos=new GasStationDTO[gSdtos.size()];
//		gSdtos.toArray(dtos);
//		result=insertGasStationByDTOs(dtos);
//		
//		dtos=new FoodMenuDTO[fMdtos.size()];
//		fMdtos.toArray(dtos);
//		result=insertFoodMenuByDTOs(dtos);
		
		return result;
	}
	
	
	/*api 가져오기*/
	public int getDTOFromJson() throws Exception {
		int result=0;
		
		/*휴게소 정보 (휴게소 코드 : ra_code, 휴게소 이름 : ra_name, 노선코드 : ra_routeNo, 노선명 : ra_routeName, 방향 : ra_destination, x좌표 : ra_xValue, y좌표 : ra_yValue)*/
		//해쉬맵을 작성할것...
		HashMap<String, String> ranameMap=new HashMap<String, String>(); //('휴게소'뺀 이름:휴게소코드)
		String url=endpoint0+"?"+"key="+serviceKey+"&type="+type+"&numOfRows=99";
		JSONParser jsonParser=new JSONParser();
		JSONObject jsonObj0=(JSONObject)jsonParser.parse(readURL(url));
		//여러 페이지를 다 가져와야 한다!
		//페이지 확인
		int fullcnt=((int)jsonObj0.get("count"))/99;
		
		//전부 꺼내기
		//디비에 집어넣기
		for(int i=1;i<=fullcnt;i++) {
			jsonParser=new JSONParser();
			jsonObj0=(JSONObject)jsonParser.parse(readURL(url+"&pageNo="+i));
			JSONArray array=(JSONArray)jsonObj0.get("list");
			
			//최대갯수로 페이지마다 죠지기
			for(int j=0;j<array.size();j++) {
				JSONObject row=(JSONObject)array.get(j);
				String ra_code=(String)row.get("serviceAreaCode");
				String ra_name=(String)row.get("unitName");
				String ra_destination=ra_name.replaceAll("[^(]*[(]", "");
				ra_destination=ra_destination.replaceAll("[)].*", "");
				ra_name=ra_name.replaceAll("[(][^)]*[)]", "");

				String ra_routeNo=(String)row.get("routeNo");
				String ra_routeName=(String)row.get("routeName");
				String ra_xValue=(String)row.get("xValue");
				String ra_yValue=(String)row.get("yValue");
				
				ranameMap.put(ra_name.replaceAll("휴게소", ""), ra_code);
				
				rAdtos.add(new RestAreaDTO().builder().ra_code(ra_code).ra_name(ra_name).ra_routeNo(ra_routeNo).ra_routeName(ra_routeName).ra_destination(ra_destination).ra_xValue(ra_xValue).ra_yValue(ra_yValue).build());
			}
			
		}
		
		
		url=endpoint1+"?"+"key="+serviceKey+"&type="+type;
		jsonParser=new JSONParser();
		JSONObject jsonObj1=(JSONObject)jsonParser.parse(readURL(url));
		JSONArray array1=(JSONArray)jsonObj1.get("list");
		
		
		url=endpoint2+"?"+"key="+serviceKey+"&type="+type;
		jsonParser=new JSONParser();
		JSONObject jsonObj2=(JSONObject)jsonParser.parse(readURL(url));
		JSONArray array2=(JSONArray)jsonObj2.get("list");

		
//            String ra_routeNo = (String)row.get("routeNo");//노선 번호
//            String gs_company = (String)row.get("oilCompany");//정유사
//            String gs_diesel = (String)row.get("dieselPrice");
//            String gs_gasoline = (String)row.get("gasolinePrice");
//            String gs_lpg = (String)row.get("lpgPrice");
//            gSdtos.add(new GasStationDTO().builder().gs_uid(i).ra_code(ra_code).gs_company(gs_company).gs_diesel(gs_diesel).gs_gasoline(gs_gasoline).gs_lpg(gs_lpg).build());
		
		//todo
		//JSONObject array2=(JSONObject)jsonObj2.get("");
//		for(int i=0;i<array2.size();i++) {
//			JSONObject row = (JSONObject)array2.get(i);
//            String sdate = (String)row.get("sdate");//집계일자
//            
//            String fm_code = (String)row.get("seq");
//            int ra_code = Integer.parseInt(((String)row.get("stdRestCd")).replaceAll("[^0-9]", ""));//휴게소코드 => 수정 필요
//            String fm_name = (String)row.get("foodNm");
//            String fm_price = (String)row.get("foodCost");
//            String fm_material = (String)row.get("foodMaterial");
//            String fm_etc = (String)row.get("etc");
//            
//            fMdtos.add(new FoodMenuDTO().builder().fm_id(i).fm_code(fm_code).ra_code(ra_code).fm_name(fm_name).fm_price(fm_price).fm_material(fm_material).fm_etc(fm_etc).build());
//            
//		}
		System.out.println("dtos 생성 완료!");
		return result;
	}
	
	//url GET request
	public String readURL(String _url) throws IOException {
		BufferedInputStream reader=null;
		
		try {
			URL url=new URL(_url);
			
			reader=new BufferedInputStream(url.openStream());
			
			StringBuffer buffer=new StringBuffer();
			int i=0;
			byte[] b=new byte[1024];
			while((i=reader.read(b))!=-1) {
				buffer.append(new String(b,0,i));
			}
			String str=buffer.toString();
			return str;
		}finally {
			if(reader!=null)
				reader.close();
		}
	}
	
	
//	public void printOutFile(String str) {
//		
//		Date d = new Date();
//		SimpleDateFormat sm = new SimpleDateFormat("yyyyMMddHHmmss");
//		String fName = sm.format(d) + ".json"; 
//		
//		File file=new File(pathname+"/"+fName);
//		try {
//			System.out.println(file.getAbsolutePath()+"에 저장합니다...");
//			file.createNewFile();
//			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
//			writer.write(str);
//			writer.close();
//		} catch (IOException e) {
//			System.out.println("fio 실패! : \n"+str+"\n");
//			e.printStackTrace();
//		}
//	}
	
	//api 테이블들 비우기
	public int deleteAllBeforeApiDataInDB() throws Exception {
		int result=0;
		System.out.println("delete sqlSession : "+sqlSession);

		dao=sqlSession.getMapper(RestAreaDAO.class);
 
		dao=sqlSession.getMapper(GasStationDAO.class);
 
		dao=sqlSession.getMapper(FoodMenuDAO.class);
 
		return result;
	}
	
	@Transactional
	public int insertRestAreaByDTOs(DTO[] dtos) throws Exception {
		int result=0;
		System.out.println("insert sqlSession : "+sqlSession);

		System.out.println("1");
		dao=sqlSession.getMapper(RestAreaDAO.class);
		insertByDTOs(dtos);
		return result;
	};

	@Transactional
	public int insertGasStationByDTOs(DTO[] dtos) throws Exception {
		System.out.println("2");
		int result=0;
		dao=sqlSession.getMapper(GasStationDAO.class);
		insertByDTOs(dtos);
		return result;
	};
	
	@Transactional
	public int insertFoodMenuByDTOs(DTO[] dtos) throws Exception {
		System.out.println("3");
		int result=0;
		dao=sqlSession.getMapper(FoodMenuDAO.class);
		insertByDTOs(dtos);
		return result;
	};
	
	//공통 코드
	public int insertByDTOs(DTO[] dtos) throws Exception {
		int result=0;
		for(DTO dto : dtos ) {
			result=dao.insertByDTO(dto);
			if(result==0) {
				System.out.println("실패");
				throw new Exception();
			}
		}
		return result;
	}

}
