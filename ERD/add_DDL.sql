
/* Drop Tables */

 
DROP SEQUENCE s_sid_seq;
DROP SEQUENCE notice_id_seq;
DROP TABLE schedule CASCADE CONSTRAINTS;
DROP TABLE ADMINNotice;



/* Create Tables */

--현준 추가 

CREATE SEQUENCE s_sid_seq
CREATE SEQUENCE notice_id_seq;
START WITH 1
INCREMENT BY 1;


CREATE SEQUENCE notice_id_seq
START WITH 1;


CREATE SEQUENCE s_sid_seq
START WITH 1;


CREATE TABLE schedule
(
	s_sid number NOT NULL,
	subject varchar2(20) NOT NULL,
	startdate varchar2(20) NOT NULL,
	enddate varchar2(20) NOT NULL,
	memo varchar2(100),
	PRIMARY KEY (s_sid)
);




CREATE TABLE ADMINNotice
(
    notice_id         INT             NOT NULL, 
    notice_subject    VARCHAR2(20)    NULL, 
    notice_regdate    date    		  NULL, 
    notice_title      VARCHAR2(20)    NULL, 
 	notice_content    VARCHAR2(200)   NULL, 

    CONSTRAINT ADMINNOTICE_PK PRIMARY KEY (notice_id)
)



select * from schedule;
SELECT * FROM ADMINNotice;


insert into(s_sid, subject, startdate, enddate)
values(s_sid_seq.nextval, 'todo', '2020-12-9', '2020-12-9');

SELECT notice_id_seq.nextval FROM DUAL ;
SELECT s_sid_seq.nextval FROM DUAL ;

INSERT INTO ADMINNotice (notice_id, notice_subject, notice_regdate, notice_title,notice_content) values(notice_id_seq.nextval, '공지사항', sysdate, 'title', '요즘 신고건수가 많습니다')






