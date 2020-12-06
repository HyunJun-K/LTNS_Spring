
/* Drop Tables */

DROP TABLE auth CASCADE CONSTRAINTS;
DROP TABLE usermember CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE auth
(
	username varchar2(50) NOT NULL,
	-- ROLE_GUEST
	-- ROLE_MEMBER
	-- ROLE_ADMIN
	authority varchar2(50) DEFAULT 'ROLE_MEMBER' NOT NULL,
	PRIMARY KEY (username, authority)
);


CREATE TABLE usermember
(
	username varchar2(50) NOT NULL,
	password varchar2(200) NOT NULL,
	realPassword varchar2(50) NOT NULL,
	nickname varchar2(50) NOT NULL,
	regDate timestamp DEFAULT SYSDATE NOT NULL,
	enabled char(1) DEFAULT '1' NOT NULL,
	PRIMARY KEY (username)
);



/* Create Foreign Keys */

ALTER TABLE auth
	ADD FOREIGN KEY (username)
	REFERENCES usermember (username)
;



/* Comments */

COMMENT ON COLUMN auth.authority IS 'ROLE_GUEST
ROLE_MEMBER
ROLE_ADMIN';

/* TestData */
INSERT INTO userMember(username, password ,realpassword,nickname) VALUES('admin', '$2a$10$.ty2lbI.rSz7bjpmWXRop.S5SZZPGzNQuKmPFDgHscDhjijAPlhai', '0000', '운영자');
INSERT INTO auth VALUES('admin', 'ROLE_ADMIN');
INSERT INTO auth VALUES('admin', 'ROLE_MEMBER');
INSERT INTO userMember(username, password ,realpassword,nickname) VALUES('hogn', '$2a$10$QneCaQwCDQIWEnnYT64/pOk.88K91rDL81LlZ4NxAzdJtRXiNMOoq', '0000', '홍성혁');
INSERT INTO auth VALUES('hogn', 'ROLE_MEMBER');
INSERT INTO userMember(username, password ,realpassword,nickname) VALUES('hyun', '$2a$10$6s1NtNSY3BEULN7krTuw3OfECZYR0WdICc/HYzRLVdK4ZiDR337nG', '0000', '김현준');
INSERT INTO auth VALUES('hyun', 'ROLE_MEMBER');
INSERT INTO userMember(username, password,realpassword,nickname) VALUES('hwi', '$2a$10$suS4tGXX5zhdBGln/5QfXutWjpe6VwNRN2mee9FZ52Z7KWdf35jwi', '0000', '김휘진');
INSERT INTO auth VALUES('hwi', 'ROLE_MEMBER');
INSERT INTO userMember(username, password ,realpassword,nickname) VALUES('park', '$2a$10$5Yy/c52u4Ped7j11mMxKEeuHAIRHjiZyg5NyltWqpW5MGIh6zk/Ky', '0000', '박성언');
INSERT INTO auth VALUES('park', 'ROLE_MEMBER');
commit;
SELECT * FROM usermember;
SELECT * FROM auth;