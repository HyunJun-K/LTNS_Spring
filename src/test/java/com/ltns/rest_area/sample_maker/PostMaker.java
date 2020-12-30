package com.ltns.rest_area.sample_maker;

import static org.hamcrest.CoreMatchers.containsString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.ltns.rest_area.domain.memberInfo.memberInfoDTO;
import com.ltns.rest_area.sample_maker.domain.AbstractDAO;
import com.ltns.rest_area.sample_maker.domain.RefreshTableDAO;
import com.ltns.rest_area.service.admin.DashBoardService;


public class PostMaker extends AbstractDAO  {

	
	
	
	//title
	String mkTitle() {
		String result = "";
		String [] arr = {"휴게소","주유소","음식"};
		int size = arr.length;
		int random  = (int)(Math.random()*size);
		
		result = arr[random];
		System.out.println(result);
		return result;
	}
	
	//report 
	int mkReport() {
		int random = (int)(Math.random()*100);
		System.out.println(random);
		return random;
	}
	
	//내용
	String mkContent() {
			String result="";
			int whilelimit=(int)(Math.random()*8)+4;
			for(int i=0;i<whilelimit;i++) {
				char[] asciiiii= {'a','0'};
				//1: 아스키코드 이용 a~z
				//2: 0~9
				char randomchar=asciiiii[(int)(Math.random()*2)];
				if(randomchar>61)
					randomchar+=(int)(Math.random()*26);
				else
					randomchar+=(int)(Math.random()*10);
				result+=randomchar;
			}
			System.out.println(result + "cotent");
			
			return result;
	}
	
	
	public static void main(String[] args) throws SQLException {
		PostMaker p = new PostMaker();
		
		RefreshTableDAO dao = new RefreshTableDAO();

		String data = dao.memberInfo();
		System.out.println(data);
		int randomsize = 10;
		for (int i = 0; i < randomsize; i++) {
			//p.mkTitle(); //타이틀
			//p.mkContent(); // 내용 
			//p.mkReport();  // 신고횟수 
		}
		
	}
	
}
