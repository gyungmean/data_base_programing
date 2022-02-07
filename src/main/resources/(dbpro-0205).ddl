
CREATE SEQUENCE course_id_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE music_id_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE comment_no_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE reply_id_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE region_id_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE theme_id_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE user_id_Seq
	INCREMENT BY 1
	START WITH 1;

DROP TABLE Course_Like CASCADE CONSTRAINTS PURGE;

DROP TABLE Reply CASCADE CONSTRAINTS PURGE;

DROP TABLE Comments CASCADE CONSTRAINTS PURGE;

DROP TABLE User_Region CASCADE CONSTRAINTS PURGE;

DROP TABLE Theme_Course CASCADE CONSTRAINTS PURGE;

DROP TABLE Course CASCADE CONSTRAINTS PURGE;

DROP TABLE Region CASCADE CONSTRAINTS PURGE;

DROP TABLE User_Theme CASCADE CONSTRAINTS PURGE;

DROP TABLE Theme CASCADE CONSTRAINTS PURGE;

DROP TABLE Music CASCADE CONSTRAINTS PURGE;

DROP TABLE User_info CASCADE CONSTRAINTS PURGE;

CREATE TABLE Comments
(
	comment_no           NUMBER NOT NULL ,
	title                VARCHAR2(1000) NOT NULL ,
	user_id              INTEGER NOT NULL ,
	comment_content      VARCHAR2(4000) NOT NULL ,
	course_id            INTEGER NOT NULL ,
	reg_date             DATE NOT NULL 
);

CREATE UNIQUE INDEX XPKComments ON Comments
(comment_no   ASC);

ALTER TABLE Comments
	ADD CONSTRAINT  XPKComments PRIMARY KEY (comment_no);

CREATE TABLE Course
(
	course_id            INTEGER NOT NULL ,
	course_name          VARCHAR2(100) NOT NULL ,
	departure            VARCHAR2(100) NULL ,
	stopover             VARCHAR2(100) NULL ,
	destination          VARCHAR2(100) NULL ,
	time                 VARCHAR2(100) NOT NULL ,
	parking              SMALLINT NULL ,
	region_id            INTEGER NOT NULL ,
	user_id              INTEGER NULL 
);

CREATE UNIQUE INDEX XPKCourse ON Course
(course_id   ASC);

ALTER TABLE Course
	ADD CONSTRAINT  XPKCourse PRIMARY KEY (course_id);

CREATE TABLE Region
(
	region_id            INTEGER NOT NULL ,
	region_name          VARCHAR2(100) NOT NULL 
);

CREATE UNIQUE INDEX XPKRegion ON Region
(region_id   ASC);

ALTER TABLE Region
	ADD CONSTRAINT  XPKRegion PRIMARY KEY (region_id);

CREATE TABLE Theme
(
	theme_id             INTEGER NOT NULL ,
	theme_name           VARCHAR2(100) NOT NULL 
);

CREATE UNIQUE INDEX XPKTheme ON Theme
(theme_id   ASC);

ALTER TABLE Theme
	ADD CONSTRAINT  XPKTheme PRIMARY KEY (theme_id);

CREATE TABLE Theme_Course
(
	theme_id             INTEGER NOT NULL ,
	course_id            INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKTheme_Course ON Theme_Course
(theme_id   ASC,course_id   ASC);

ALTER TABLE Theme_Course
	ADD CONSTRAINT  XPKTheme_Course PRIMARY KEY (theme_id,course_id);

CREATE TABLE User_info
(
	user_id              INTEGER NOT NULL ,
	password             VARCHAR2(30) NOT NULL ,
	nickname             VARCHAR2(80) NOT NULL ,
	email                VARCHAR2(30) NOT NULL 
);

CREATE UNIQUE INDEX XPKUser ON User_info
(user_id   ASC);

ALTER TABLE User_info
	ADD CONSTRAINT  XPKUser PRIMARY KEY (user_id);

CREATE TABLE Course_Like
(
	user_id              INTEGER NOT NULL ,
	course_id            INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKCourse_like ON Course_Like
(user_id   ASC,course_id   ASC);

ALTER TABLE Course_Like
	ADD CONSTRAINT  XPKCourse_like PRIMARY KEY (user_id,course_id);

CREATE TABLE Reply
(
	reply_id             INTEGER NOT NULL ,
	reg_date             DATE NOT NULL ,
	user_id              INTEGER NOT NULL ,
	comment_no           NUMBER NOT NULL ,
	reply_content        VARCHAR2(4000) NOT NULL 
);

CREATE UNIQUE INDEX XPKReply ON Reply
(reply_id   ASC);

ALTER TABLE Reply
	ADD CONSTRAINT  XPKReply PRIMARY KEY (reply_id);

CREATE TABLE User_Region
(
	user_id              INTEGER NOT NULL ,
	region_id            INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKUser_Region ON User_Region
(user_id   ASC,region_id   ASC);

ALTER TABLE User_Region
	ADD CONSTRAINT  XPKUser_Region PRIMARY KEY (user_id,region_id);

CREATE TABLE User_Theme
(
	user_id              INTEGER NOT NULL ,
	theme_id             INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKUser_Theme ON User_Theme
(user_id   ASC,theme_id   ASC);

ALTER TABLE User_Theme
	ADD CONSTRAINT  XPKUser_Theme PRIMARY KEY (user_id,theme_id);

CREATE TABLE Music
(
	music_tag            VARCHAR2(1000) NOT NULL ,
	music_title          VARCHAR2(1000) NOT NULL ,
	music_url            VARCHAR2(4000) NOT NULL ,
	music_id             INTEGER NOT NULL ,
	user_id              INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKMusic ON Music
(music_id   ASC);

ALTER TABLE Music
	ADD CONSTRAINT  XPKMusic PRIMARY KEY (music_id);

ALTER TABLE Comments
	ADD (CONSTRAINT R_19 FOREIGN KEY (course_id) REFERENCES Course (course_id) ON DELETE SET NULL);

ALTER TABLE Comments
	ADD (CONSTRAINT R_8 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Course
	ADD (CONSTRAINT R_13 FOREIGN KEY (region_id) REFERENCES Region (region_id));

ALTER TABLE Course
	ADD (CONSTRAINT R_18 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Theme_Course
	ADD (CONSTRAINT R_30 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id));

ALTER TABLE Theme_Course
	ADD (CONSTRAINT R_31 FOREIGN KEY (course_id) REFERENCES Course (course_id));

ALTER TABLE Course_Like
	ADD (CONSTRAINT R_7 FOREIGN KEY (course_id) REFERENCES Course (course_id));

ALTER TABLE Course_Like
	ADD (CONSTRAINT R_6 FOREIGN KEY (user_id) REFERENCES User_info (user_id));

ALTER TABLE Reply
	ADD (CONSTRAINT R_10 FOREIGN KEY (comment_no) REFERENCES Comments (comment_no) ON DELETE SET NULL);

ALTER TABLE Reply
	ADD (CONSTRAINT R_9 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE User_Region
	ADD (CONSTRAINT R_25 FOREIGN KEY (region_id) REFERENCES Region (region_id));

ALTER TABLE User_Region
	ADD (CONSTRAINT R_24 FOREIGN KEY (user_id) REFERENCES User_info (user_id));

ALTER TABLE User_Theme
	ADD (CONSTRAINT R_22 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id));

ALTER TABLE User_Theme
	ADD (CONSTRAINT R_21 FOREIGN KEY (user_id) REFERENCES User_info (user_id));

ALTER TABLE Music
	ADD (CONSTRAINT R_32 FOREIGN KEY (user_id) REFERENCES User_info (user_id));
