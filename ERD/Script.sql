UPDATE SCHEDULE SET 
			subject= 'hello2' , startdate='2020-12-10', enddate= '2020-12-10', memo= 'test'
WHERE subject = 'hello';

SELECT * FROM SCHEDULE s ;


SELECT 
UM_UID , UM_USERNAME, UM_NICKNAME, UM_REGDATE, UM_ENABLED
FROM usermember;

INSERT INTO USERMEMBER (UM_UID , UM_USERNAME, UM_PASSWORD, UM_NICKNAME, UM_REGDATE, UM_ENABLED)
VALUES (1,'hello','hello','hello', sysdate, 1);

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
(42,'유머','하하히히히', 2, 'ceo',sysdate, 'A00004','1')

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
		
