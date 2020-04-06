DROP TABLE T_GENRE ; 
CREATE TABLE T_GENRE(
	GENRE_ID VARCHAR(30) PRIMARY KEY , 
	GENRE_NAME VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP 
);
ALTER TABLE T_GENRE CONVERT TO CHARACTER SET UTF8;

DROP TABLE T_PROGRAM ;
CREATE TABLE T_PROGRAM (
	PROGRAM_ID VARCHAR(30) PRIMARY KEY , 
	TITLE VARCHAR(100) , 
	SYNOPSIS VARCHAR(200) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP 
) ;
ALTER TABLE T_PROGRAM CONVERT TO CHARACTER SET UTF8;

DROP TABLE T_PROGRAM_GENRE ; 
CREATE TABLE T_PROGRAM_GENRE (
	GENRE_ID VARCHAR(30) ,
	PROGRAM_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP,
	PRIMARY KEY ( GENRE_ID , PROGRAM_ID )
) ;
ALTER TABLE T_PROGRAM_GENRE CONVERT TO CHARACTER SET UTF8;

DROP TABLE T_PROGRAM_PRODUCT ; 
CREATE TABLE T_PROGRAM_PRODUCT ( 
	PROGRAM_ID VARCHAR(30) ,
	PRODUCT_ID VARCHAR(30) , 
	TITLE VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_PROGRAM_PRODUCT CONVERT TO CHARACTER SET UTF8; 