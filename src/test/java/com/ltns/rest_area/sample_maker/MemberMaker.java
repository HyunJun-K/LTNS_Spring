package com.ltns.rest_area.sample_maker;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import com.ltns.rest_area.sample_maker.domain.AbstractDAO;

class MemberMaker extends AbstractDAO  {

	
	//DB연결 
	public MemberMaker() throws SQLException {
		try {
			AbstractDAO();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("디비연결 실패");
		}finally {
			close();
		}

	}
	
	
	 String mkId() {
		 String result ="";
		 int M
		 
		 
		 
		 
		 return result;
		 
	 }
	
	 //비번 제조기
	 String mkPW() {
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
			System.out.println(result);
			
			return result;
	}
	 
	//닉네임 제조기 
	String mkNick() {
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
		System.out.println(result);
		return result;
	}
	 
	 
	

	
	
	
	public static void main(String[] args) throws SQLException {
		PostMaker pk = new PostMaker();
	
		
	}

}
