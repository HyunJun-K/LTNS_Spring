package com.ltns.rest_area.sample_maker.domain;

import java.sql.SQLException;

public class RefreshTableDAO2_firstmember extends AbstractDAO {

	final static String INSERT_MEMBER="INSERT INTO UserMember(um_uid, um_username, um_password ,um_nickname)"+ 
									"VALUES(?, ?, ? , ?)";
	final static String INSERT_AUTH="INSERT INTO Auth VALUES('ROLE_ADMIN', 1)";

	public RefreshTableDAO2_firstmember(){
		super();
	}
	
	public void mkInsertMember(int um_uid, String um_username, String um_password, String um_nickname) throws SQLException {
		pstmt=conn.prepareStatement(INSERT_MEMBER);
		pstmt.setInt(0, um_uid);
		pstmt.setString(1, um_username);
		pstmt.setString(2, um_password);
		pstmt.setString(3, um_nickname);		
	}
	
	public void mkInsertAuth(String auth,int um_uid) throws SQLException {
		pstmt=conn.prepareStatement(INSERT_AUTH);
		pstmt.setString(0, auth);
		pstmt.setInt(1, um_uid);
		
	}
}

/*예안*/
//INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'admin', '$2a$10$.ty2lbI.rSz7bjpmWXRop.S5SZZPGzNQuKmPFDgHscDhjijAPlhai',  '운영자');
//INSERT INTO auth(um_uid) VALUES(1);
//INSERT INTO auth VALUES('ROLE_ADMIN', 1);
//INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'hong', '$2a$10$QneCaQwCDQIWEnnYT64/pOk.88K91rDL81LlZ4NxAzdJtRXiNMOoq',  '홍성혁');
//INSERT INTO auth(um_uid) VALUES(2);
//INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'hyun', '$2a$10$6s1NtNSY3BEULN7krTuw3OfECZYR0WdICc/HYzRLVdK4ZiDR337nG',  '김현준');
//INSERT INTO auth(um_uid) VALUES(3);
//INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'hwi', '$2a$10$suS4tGXX5zhdBGln/5QfXutWjpe6VwNRN2mee9FZ52Z7KWdf35jwi',  '김휘진');
//INSERT INTO auth(um_uid) VALUES(4);
//INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'park', '$2a$10$5Yy/c52u4Ped7j11mMxKEeuHAIRHjiZyg5NyltWqpW5MGIh6zk/Ky', '박성언');
//INSERT INTO auth(um_uid) VALUES(5);
