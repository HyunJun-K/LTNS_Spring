package com.ltns.rest_area.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
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

@Service
public class ApiService {
	
	//주유소 가격과 고속도로 통행량의 상관성
	final static String endpoint1="http://data.ex.co.kr/exopenapi/gsstPriHiwayTcct";
	//휴게소 푸드메뉴현황 조회 서비스
	final static String endpoint2="	http://data.ex.co.kr/exopenapi/restinfo/restBestfoodList";
	final static String serviceKey="Mo2bC%2FF3BlGO7N3%2FYQICUWhpvGb5nfVMfmWj4%2BLjTLNs2JzRcnFL5Nv29aqOCpvXpcvGzX57NmPKe8uXcoCz0A%3D%3D";
	final static String type="json";
	
	List<DTO> rAdtos=new ArrayList<DTO>();
	List<DTO> gSdtos=new ArrayList<DTO>();
	List<DTO> fMdtos=new ArrayList<DTO>();
	
	@Autowired
	private SqlSession sqlSession;
	
	DAO dao;
	
	//디비 api 데이터 최신화 트랜잭션화 -실패시...도루묵~
	@Transactional
	public int refreshApiData() throws Exception {
		int result=0;
		
		getDTOFromJson();
		
		result=deleteAllBeforeApiDataInDB();
		
		DTO[] dtos=new RestAreaDTO[rAdtos.size()];
		rAdtos.toArray(dtos);
		result=insertRestAreaByDTOs(dtos);
		
		dtos=new GasStationDTO[gSdtos.size()];
		gSdtos.toArray(dtos);
		result=insertRestAreaByDTOs(dtos);
		
		dtos=new FoodMenuDTO[fMdtos.size()];
		fMdtos.toArray(dtos);
		result=insertRestAreaByDTOs(dtos);
		
		return result;
	}
	
	//api 가져오기
	public int getDTOFromJson() throws Exception {
		int result=0;
		
		String url=endpoint1+"?"+"serviceKey="+serviceKey+"&type="+type;
		JSONParser jsonParser=new JSONParser();
		JSONObject jsonObj1=(JSONObject)jsonParser.parse(readURL(url));
		
		url=endpoint2+"?"+"serviceKey="+serviceKey+"&type="+type;
		jsonParser=new JSONParser();
		JSONObject jsonObj2=(JSONObject)jsonParser.parse(readURL(url));
		
		
		//todo
		//JSONObject array1=(JSONObject)jsonObj1.get("");
		for(int i=0;i<array1.size()<0;i++) {
			JSONObject row = (JSONObject)array1.get(i);
            String sdate = (String)row.get("sdate");//집계일자
            
            int ra_code = Integer.parseInt((String)row.get("unitCode"));//휴게소코드 => 수정 필요
            String ra_name=(String)row.get("unitName"); //휴게소명 => 수정필요?
            String ra_routeNo = (String)row.get("routeNo");//노선 번호
            String ra_routeName = (String)row.get("routeName");//노선명
            String ra_updownType = (String)row.get("updownType");//방향
            String ra_destination = (String)row.get("destination");//행선 구분
            String ra_locName = (String)row.get("locName");//거점으로부터 위치
            rAdtos.add(new RestAreaDTO().builder().ra_code(ra_code).ra_name(ra_name).ra_routeNo(ra_routeNo).ra_routeName(ra_routeName).ra_destination(ra_destination).ra_locName(ra_locName).build());
            
            String gs_company = (String)row.get("oilCompany");//정유사
            String gs_diesel = (String)row.get("dieselPrice");
            String gs_gasoline = (String)row.get("gasolinePrice");
            String gs_lpg = (String)row.get("lpgPrice");
            gSdtos.add(new GasStationDTO().builder().gs_uid(i).ra_code(ra_code).gs_company(gs_company).gs_diesel(gs_diesel).gs_gasoline(gs_gasoline).gs_lpg(gs_lpg).build());
            
		}
		
		
		//todo
		//JSONObject array2=(JSONObject)jsonObj2.get("");
		for(int i=0;i<array2.size()<0;i++) {
			JSONObject row = (JSONObject)array2.get(i);
            String sdate = (String)row.get("sdate");//집계일자
            
            String fm_code = (String)row.get("seq");
            int ra_code = Integer.parseInt((String)row.get("stdRestCd"));//휴게소코드 => 수정 필요
            String fm_name = (String)row.get("foodNm");
            String fm_price = (String)row.get("foodCost");
            String fm_material = (String)row.get("foodMaterial");
            String fm_etc = (String)row.get("etc");
            
            fMdtos.add(new FoodMenuDTO().builder().fm_id(i).fm_code(fm_code).ra_code(ra_code).fm_name(fm_name).fm_price(fm_price).fm_material(fm_material).fm_etc(fm_etc).build());
            
		}
		
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
			return buffer.toString();
		}finally {
			if(reader!=null)
				reader.close();
		}
	}
	
	
	//api 테이블들 비우기
	public int deleteAllBeforeApiDataInDB() throws Exception {
		int result=0;
		dao=sqlSession.getMapper(RestAreaDAO.class);
		if((result=dao.deleteAll())==0) {
			System.out.println("실패");
			throw new Exception();
		}
		dao=sqlSession.getMapper(GasStationDAO.class);
		if((result=dao.deleteAll())==0) {
			System.out.println("실패");
			throw new Exception();
		}
		dao=sqlSession.getMapper(FoodMenuDAO.class);
		if((result=dao.deleteAll())==0) {
			System.out.println("실패");
			throw new Exception();
		}
		return result;
	}
	
	public int insertRestAreaByDTOs(DTO[] dtos) throws Exception {
		int result=0;
		dao=sqlSession.getMapper(RestAreaDAO.class);
		insertByDTOs(dtos);
		return result;
	};
	
	public int insertGasStationByDTOs(DTO[] dtos) throws Exception {
		int result=0;
		dao=sqlSession.getMapper(GasStationDAO.class);
		insertByDTOs(dtos);
		return result;
	};
	
	public int insertFoodMenuByDTOs(DTO[] dtos) throws Exception {
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
