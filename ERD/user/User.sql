
/* Drop Triggers */

DROP TRIGGER TRI_usermember_uid;
DROP TRIGGER TRI_usermember_um_uid;



/* Drop Tables */

DROP TABLE auth CASCADE CONSTRAINTS;
DROP TABLE usermember CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_usermember_uid;
DROP SEQUENCE SEQ_usermember_um_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_usermember_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_usermember_um_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE auth
(
	-- ROLE_GUEST
	-- ROLE_MEMBER
	-- ROLE_ADMIN
	au_authority varchar2(50) DEFAULT 'ROLE_MEMBER' NOT NULL,
	um_uid number NOT NULL,
	PRIMARY KEY (au_authority, um_uid)
);


CREATE TABLE usermember
(
	um_uid number NOT NULL,
	um_username varchar2(50) NOT NULL UNIQUE,
	um_password varchar2(200) NOT NULL,
	um_nickname varchar2(50) NOT NULL UNIQUE,
	um_regDate timestamp DEFAULT SYSDATE NOT NULL,
	um_enabled char(1) DEFAULT '1' NOT NULL,
	PRIMARY KEY (um_uid)
);



/* Create Foreign Keys */

ALTER TABLE auth
	ADD FOREIGN KEY (um_uid)
	REFERENCES usermember (um_uid)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_usermember_uid BEFORE INSERT ON usermember
FOR EACH ROW
BEGIN
	SELECT SEQ_usermember_uid.nextval
	INTO :new.uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_usermember_um_uid BEFORE INSERT ON usermember
FOR EACH ROW
BEGIN
	SELECT SEQ_usermember_um_uid.nextval
	INTO :new.um_uid
	FROM dual;
END;

/




/* Comments */

COMMENT ON COLUMN auth.au_authority IS 'ROLE_GUEST
ROLE_MEMBER
ROLE_ADMIN';



