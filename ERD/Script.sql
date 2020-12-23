UPDATE SCHEDULE SET 
			subject= 'hello2' , startdate='2020-12-10', enddate= '2020-12-10', memo= 'test'
WHERE subject = 'hello';

SELECT * FROM SCHEDULE s ;


SELECT 
UM_UID , UM_USERNAME, UM_NICKNAME, UM_REGDATE, UM_ENABLED
FROM usermember;

SELECT * FROM USERMEMBER u ;


UPDATE SCHEDULE SET 
				subject= 'tt', startDate= '2020-12-16', endDate= '2020-12-16'
			WHERE subject= 'test';


SELECT count(*) FROM USERMEMBER u;


INSERT INTO userMember
(um_uid, um_username, um_password ,um_nickname, UM_ENABLED) VALUES
(9, 'iiidk', '$2a$10$5Yy/c52u4Ped7j11mMxKEeuHAIRHjiZyg5NyltWqpW5MGIh6zk/Ky', '미니미니',1);


SELECT * FROM USERMEMBER u ;

SELECT * FROM USERMEMBER  WHERE UM_USERNAME = 'park' or UM_NICKNAME = 'null'; 


	SELECT 
			UM_UID , UM_USERNAME, UM_NICKNAME, UM_REGDATE, UM_ENABLED
		FROM 
			(SELECT ROWNUM AS RNUM, T.* FROM
				(SELECT * FROM USERMEMBER ORDER BY UM_UID DESC) T)
	
SELECT * FROM usermember;
				
SELECT * FROM USERMEMBER  WHERE UM_USERNAME = 'hello';
SELECT* FROM USERMEMBER  WHERE UM_NICKNAME = 'hello';


SELECT * FROM USERMEMBER u2 ;
SELECT 
	UM_NICKNAME, UM_ENABLED

SELECT * FROM post;
		
SELECT * FROM GASSTATION g ;

INSERT INTO POST 
(post_id, post_title, POST_CONTENTS, UM_UID, UM_USERNAME, POST_REGDATE, RA_CODE, POST_REPORTED)
VALUES
(44,'유머','하하히히히', 2, 'ceo',sysdate, 'A00004','11')

SELECT* FROM post; 


	SELECT 
		 post_id , post_title, POST_CONTENTS, UM_UID, UM_USERNAME, POST_REGDATE, RA_CODE, POST_REPORTED
		FROM 
			(SELECT ROWNUM AS RNUM, T.* FROM
				(SELECT * FROM POST ORDER BY post_id DESC) T)
		WHERE
			RNUM >= #{from} AND RNUM < (#{from} + #{pagenationPage});
			
		SELECT * FROM post;
	
	
	

	SELECT 
		POST_REPORTED, POST_TITLE 
		FROM ( SELECT ROWNUM AS RNUM, T.* from 
				 (SELECT * FROM post ORDER BY POST_REPORTED desc)	T		)
		WHERE rnum >= 3 AND rnum <= 7;	
		
SELECT POST_REPORTED FROM post
WHERE ROWNUM <=5 ORDER BY POST_REPORTED;

SELECT
	  POST_REPORTED 
	FROM post
WHERE ROWNUM <= 100 ORDER BY POST_REPORTED;



SELECT * FROM post;

SELECT POST_TITLE , POST_REPORTED FROM post 
WHERE ROWNUM <=5
ORDER BY post_id;


SELECT * FROM post 
WHERE POST_TITLE = '쿠잔' OR UM_USERNAME ='null';

SELECT * FROM POST WHERE UM_USERNAME = 'hello';
SELECT * FROM post WHERE POST_TITLE  = '쿠잔';
	
	SELECT POST_REPORTED, post_title
	FROM POST
	WHERE ROWNUM <=5
	ORDER BY POST_REPORTED DESC;

SELECT ROWNUM , POST_REPORTED FROM POST WHERE ROWNUM<=2;

SELECT * FROM POST;

SELECT ROWNUM, POST_ID ,POST_REPORTED  FROM 
(SELECT * FROM POST ORDER BY POST_ID DESC)
WHERE ROWNUM <=5;


SELECT ROWNUM,RA_CODE,POST_TITLE FROM 
(SELECT * FROM POST ORDER BY POST_ID DESC)
WHERE ROWNUM <=5;

SELECT * FROM post;

SELECT ROWNUM, post_title, POST_REPORTED  FROM 
		(SELECT * FROM POST ORDER BY POST_REPORTED DESC)
		WHERE ROWNUM <=5

SELECT * FROM post;


SELECT RA_CODE ,COUNT(RA_CODE) FROM POST;

SELECT RA_CODE, COUNT(*) AS ACCOUNT 
FROM POST
GROUP BY RA_CODE;


SELECT UM_USERNAME , COUNT(*) AS ACCOUNT 
FROM POST
GROUP BY UM_USERNAME;

SELECT * FROM post;



SELECT to_char(trunc(sysdate, 'IW'),'mm-dd') FROM dual;


SELECT to_char(post_regdate, 'yyyy-mm-dd') AS RESULTDATE, count(*) FROM POST 
WHERE RESULTDATE BETWEEN  to_char(post_regdate, 'yyyy-mm-dd') AND to_char(sysdate, 'yyyy-mm-dd') 
GROUP BY RESULTDATE ;
SELECT  to_char(post_regdate, 'yyyy-mm-dd') , count(*)
FROM post
WHERE post_regdate BETWEEN to_char(post_regdate, 'IW') AND to_char(sysdate,'IW')

SELECT post_regdate AS YEARs, count(*) 
FROM post GROUP BY YEARs;

WHERE TO_CHAR(POST_REGDATE, 'MM-DD') BETWEEN to_char(trunc(sysdate, 'IW'),'mm-dd')
GROUP BY result;


SELECT TO_CHAR(TRUNC(SYSDATE,'IW'),'MM-DD') FROM daul;
SELECT POST_REGDATE FROM post;

SELECT TO_CHAR(POST_REGDATE ,'MM-DD') days ,count(*) DAYSCOUNT  FROM POST
WHERE POST_REGDATE BETWEEN to_char(trunc(POST_REGDATE, 'iw')) and to_char(trunc(sysdate, 'iw'))
GROUP BY TO_CHAR(POST_REGDATE ,'MM-DD')
ORDER BY days;


SELECT * FROM USERMEMBER u ;

SELECT TO_CHAR(UM_REGDATE ,'MM-DD') days ,count(*) DAYSCOUNT  FROM USERMEMBER
WHERE UM_REGDATE  BETWEEN to_char(trunc(UM_REGDATE , 'iw')) and to_char(trunc(sysdate, 'iw'))
GROUP BY TO_CHAR(UM_REGDATE  ,'MM-DD')
ORDER BY days;

SELECT * FROM post;
SELECT * FROM COMMENTS c2 ;

SELECT * FROM USERMEMBER u2 ;

INSERT INTO COMMENTS (COMMENT_ID, COMMENT_CONTENTS, UM_UID, UM_USERNAME, UM_REGDATE , POST_ID, COMMENT_REPORTED)
values(15,'닌닐리리','1','heejin','20-12-11',27,0); 

SELECT * FROM COMMENTS c ;

SELECT UM_USERNAME, count(*) AS cnt FROM COMMENTS 
	GROUP BY UM_USERNAME  ORDER BY cnt DESC;


SELECT UM_USERNAME, count(*) AS cnt FROM POST 
	GROUP BY UM_USERNAME  ORDER BY cnt DESC;


SELECT * FROM SCHEDULE s ;

SELECT * FROM GASSTATION g ;
SELECT * FROM RESTAREA r ;
SELECT * FROM FOODMENU f ;


SELECT count(*) AS POST_REPORTED  FROM POST;
SELECT * FROM USERMEMBER u2 ;

SELECT count(*) AS POST_REPORTED FROM post
WHERE TO_CHAR(POST_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');


SELECT * FROM COMMENTS c ;


SELECT count(*) AS today_coment  FROM COMMENTS
WHERE TO_CHAR(UM_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');


SELECT count(*) AS total_coment FROM COMMENTS;


SELECT post_id, POST_TITLE, UM_USERNAME, RA_CODE  FROM post
WHERE TO_CHAR(POST_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');


SELECT ROWNUM, POST_ID, POST_TITLE , POST_REPORTED  FROM 
		(SELECT * FROM POST ORDER BY POST_ID , POST_REPORTED DESC )
		WHERE ROWNUM <=5
		
SELECT post_id, POST_TITLE, UM_USERNAME, RA_CODE, post_reported  FROM post
	WHERE TO_CHAR(POST_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD') AND POST_REPORTED  >=10
	
	

	


SELECT * FROM FOODMENU;

SELECT * FROM FM_LIKE;
INSERT INTO FM_LIKE (UM_UID, FM_ID)
values('2','11');

DELETE  FROM FM_LIKE ;



SELECT count(*), RA_CODE  FROM RA_LIKE rl ;

INSERT INTO RA_LIKE (UM_UID, RA_CODE)
values('6','A00034');


	SELECT gk.GS_CODE , g.GS_NAME , g.GS_DIESEL, g.GS_GASOLINE ,g.GS_LPG  , count(*) AS BEST_fm
	FROM GS_LIKE gk , GASSTATION g 
	WHERE gk.GS_CODE  = g.GS_CODE 
	GROUP BY gk.GS_CODE , g.GS_NAME , g.GS_DIESEL, g.GS_GASOLINE ,g.GS_LPG 
	ORDER BY BEST_fm desc


	
SELECT * FROM COMMENTS ;
SELECT * FROM RA_LIKE rl ;


SELECT count(*) AS ACCOUNT  FROM COMMENTS
	WHERE TO_CHAR(UM_REGDATE  ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');



INSERT INTO COMMENTS (COMMENT_ID, COMMENT_CONTENTS, UM_UID, UM_USERNAME, UM_REGDATE , POST_ID, COMMENT_REPORTED)
values(18,'닌닐리리','1','heejin',sysdate,27,0); 


SELECT * FROM FM_LIKE fl 

SELECT (SELECT count(*) FROM COMMENTS c WHERE c.UM_UID = r.UM_UID) AS ACCOUNT, c.UM_UID FROM RA_LIKE, COMMENTS c 
 	WHERE TO_CHAR(c.UM_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');
 
 
SELECT count(*) FROM FM_LIKE fl ;




SELECT count(*) AS totaldata FROM FM_LIKE r  , COMMENTS c 
 	WHERE TO_CHAR(c.UM_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD');	
 	
 	
 	

	
	
SELECT * FROM USERMEMBER u ;


SELECT
( SELECT count(*) FROM FM_LIKE )AS list,
( SELECT count(*) FROM GS_LIKE )AS list,
( SELECT count(*) FROM RA_LIKE )AS list
FROM dual ;

SELECT count(*) FROM GS_LIKE ;
SELECT count(*) FROM RA_LIKE ;

INSERT INTO GS_LIKE (UM_UID, GS_CODE)
values('1','B00001');


SELECT * FROM GASSTATION g;
SELECT * FROM RESTAREA r ;






SELECT * FROM FOODMENU f ;
SELECT * FROM RestArea;

SELECT RA_CODE, COUNT(*) AS ACCOUNT 
		FROM POST
		GROUP BY RA_CODE


		
		
SELECT * FROM USERMEMBER ;

SELECT count(*) AS today_acount FROM USERMEMBER
	WHERE TO_CHAR(UM_REGDATE ,'YYYYMMDD') = TO_CHAR(SYSDATE ,'YYYYMMDD') AND 
	
	
	SELECT TO_CHAR(UM_REGDATE ,'MM-DD') days ,count(*) dayscount  FROM USERMEMBER
		WHERE UM_REGDATE BETWEEN to_char(trunc(UM_REGDATE, 'iw')) and to_char(trunc(sysdate, 'iw'))
		GROUP BY TO_CHAR(UM_REGDATE ,'MM-DD')
		order by days
		
SELECT * FROM USERMEMBER;
	
SELECT * FROM post

INSERT INTO USERMEMBER (UM_UID , UM_USERNAME, UM_PASSWORD, UM_NICKNAME, UM_REGDATE, UM_ENABLED)
VALUES (13,'admin','admin','admins', sysdate, 1);

	
SELECT TO_CHAR(POST_REGDATE ,'MM-DD') days ,count(*) dayscount  FROM POST
		WHERE POST_REGDATE BETWEEN to_char(trunc(POST_REGDATE, 'iw')) and to_char(trunc(sysdate, 'iw'))
		GROUP BY TO_CHAR(POST_REGDATE ,'MM-DD')
		order by days


	SELECT * FROM post;


INSERT INTO POST 
(post_id, post_title, POST_CONTENTS, UM_UID, UM_USERNAME, POST_REGDATE, RA_CODE, POST_REPORTED)
VALUES
(46,'유머','하하히히히', 2, 'ceo','20-12-07', 'A00004','11')



SELECT SYSDATE AS 오늘 , 
SYSDATE - 7 AS "7일전" , 
TRUNC(SYSDATE, 'iW') AS  FROM  dual


		SELECT TO_CHAR(TRUNC(POST_REGDATE,'iw'),'YY-MM-DD')  AS days , nvl(count(POST_REGDATE),0) as dayscount  FROM POST
		WHERE POST_REGDATE BETWEEN TRUNC(SYSDATE,'iw') -7 and TRUNC(SYSDATE, 'iW') 
		GROUP BY POST_REGDATE
		order by POST_REGDATE ;
		
		SELECT POST_REGDATE FROM POST;

		SELECT to_char(trunc(sysdate, 'iw')-7) AS start FROM dual;
		SELECT to_char(trunc(sysdate, 'iw')) AS end FROM dual;
	
		SELECT TO_CHAR(POST_REGDATE ,'MM-DD') AS days  , count(*) cnt  FROM post
		WHERE  POST_REGDATE BETWEEN to_date((TRUNC(sysdate,'MM')))  AND   to_date(LAST_DAY(sysdate)) 
		GROUP BY TO_CHAR(POST_REGDATE ,'MM-DD') 
		ORDER BY TO_CHAR(POST_REGDATE ,'MM-DD');
	
	
	SELECT TO_CHAR(POST_REGDATE ,'MM-DD') as membersdays, count(*) month_total  FROM post
		WHERE  POST_REGDATE BETWEEN to_date((TRUNC(sysdate,'MM')))  AND   to_date(LAST_DAY(sysdate)) 
		GROUP BY TO_CHAR(POST_REGDATE ,'MM-DD') 
		ORDER BY TO_CHAR(POST_REGDATE ,'MM-DD')	
	
		
		SELECT TO_CHAR(UM_REGDATE ,'MM-DD') as membersdays, count(*) month_total  FROM USERMEMBER  
		WHERE  UM_REGDATE BETWEEN to_date((TRUNC(sysdate,'MM')))  AND   to_date(LAST_DAY(sysdate)) 
		GROUP BY TO_CHAR(UM_REGDATE ,'MM-DD') 
		ORDER BY TO_CHAR(UM_REGDATE ,'MM-DD')	
		
		
		INSERT INTO auth(um_uid) VALUES(2);
INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'hyunjuns', '123',  '에핑');

		
		SELECT * FROM USERMEMBER u 
		
		INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'acount', '789',  '운영자');
		SELECT SEQ_usermember_um_uid.NEXTVAL FROM USERMEMBER ;
	
SELECT * FROM USERVIEW u;
UPDATE USERVIEW SET AUTHORITY = 'ROLE_MEMBER' WHERE USERNAME = 'hello';
	
INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'park', '$2a$10$5Yy/c52u4Ped7j11mMxKEeuHAIRHjiZyg5NyltWqpW5MGIh6zk/Ky', '박성언');

SELECT * FROM USERVIEW u; 

INSERT INTO userMember(um_uid, um_username, um_password ,um_nickname) VALUES(SEQ_usermember_um_uid.NEXTVAL, 'ssd', '$2a$10$.ty2lbI.rSz7bjpmWXRop.S5SZZPGzNQuKmPFDgHscDhjijAPlhai',  '운영자3');


SELECT * FROM USERMEMBER u ;


INSERT INTO auth VALUES('ROLE_ADMIN', 30);

SELECT to_char(UM_REGDATE,'yy-mm-dd') as user_regdate, UM_UID, um_USERNAME ,UM_NICKNAME  FROM USERMEMBER  WHERE UM_USERNAME = 'nbnloper@gmail.com' or UM_NICKNAME = 'null';

SELECT notice_id, notice_subject, to_char(notice_regdate ,'yyyy-mm-dd') notice_regdate, notice_writer, notice_content FROM ADMINNotice;


INSERT INTO ADMINNotice 
(notice_id, notice_subject, notice_regdate, notice_writer,notice_content) 
values(notice_id_seq.nextval, '공지사항', sysdate, '김현준', '요즘 신고건수가 많습니다')



SELECT notice_id, notice_subject, to_char(notice_regdate ,'mm-dd') notice_regdate, notice_writer, notice_content
FROM ADMINNOTICE WHERE notice_id = 17

 ALTER TABLE ADMINNotice RENAME COLUMN notice_title TO notice_writer;

		SELECT * FROM ADMINNOTICE WHERE notice_id = 18


	SELECT 
			*
		FROM 
			(SELECT ROWNUM AS RNUM, T.* FROM
				(SELECT * FROM ADMINNotice ORDER BY notice_id DESC) T)
		WHERE
			RNUM >= 1 AND RNUM < (1 + 10)

			
		
			INSERT INTO ADMINNotice (notice_id, notice_subject, notice_regdate, NOTICE_WRITER ,notice_content)
			values(notice_id_seq.nextval, 'ss', sysdate, 'sd', '202020')
	
			
			
INSERT INTO ADMINNotice (notice_id, notice_subject, notice_regdate, NOTICE_WRITER ,notice_content)
values(notice_id_seq.nextval, #{title}, sysdate, #{id}, #{content})

SELECT * FROM ADMINNOTICE a ;

ALTER TABLE ADMINNOTICE MODIFY notice_subject varchar2(100);

UPDATE ADMINNOTICE SET notice_subject ='ㅎㅎ'  WHERE  notice_id= 1;

SELECT * FROM ADMINNOTICE a  WHERE NOTICE_ID =12


SELECT * FROM ADMINNOTICE a ;

DELETE FROM ADMINNOTICE WHERE NOTICE_ID = 1;

DELETE FROM ADMINNOTICE a2 


SELECT * FROM USERMEMBER WHERE UM_UID = #{UM_UID};

SELECT * FROM USERVIEW u ;

UPDATE USERVIEW SET AUTHORITY = #{AUTHORITY} WHERE USERNAME = #{username}
