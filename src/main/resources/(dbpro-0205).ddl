
CREATE SEQUENCE course_commentId_Seq;

CREATE SEQUENCE courseId_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE musicId_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE post_commentId_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE postId_Seq
	INCREMENT BY 1
	START WITH 5000;

CREATE SEQUENCE region_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE theme_Seq
	INCREMENT BY 1
	START WITH 1;

CREATE SEQUENCE userId_Seq
	INCREMENT BY 1
	START WITH 1000;

DROP TABLE Course_comment CASCADE CONSTRAINTS PURGE;

DROP TABLE Course_Like CASCADE CONSTRAINTS PURGE;

DROP TABLE Post_comment CASCADE CONSTRAINTS PURGE;

DROP TABLE Spot_post CASCADE CONSTRAINTS PURGE;

DROP TABLE User_Region CASCADE CONSTRAINTS PURGE;

DROP TABLE Music_Theme CASCADE CONSTRAINTS PURGE;

DROP TABLE Music CASCADE CONSTRAINTS PURGE;

DROP TABLE Theme_Course CASCADE CONSTRAINTS PURGE;

DROP TABLE Course CASCADE CONSTRAINTS PURGE;

DROP TABLE Region CASCADE CONSTRAINTS PURGE;

DROP TABLE User_Theme CASCADE CONSTRAINTS PURGE;

DROP TABLE Theme CASCADE CONSTRAINTS PURGE;

DROP TABLE User_info CASCADE CONSTRAINTS PURGE;

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

CREATE TABLE Music
(
	music_id             INTEGER NOT NULL ,
	url                  VARCHAR2(100) NOT NULL ,
	title                VARCHAR2(20) NOT NULL ,
	tag                  VARCHAR2(400) NULL ,
	user_id              INTEGER NOT NULL ,
	theme_id             INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKMusic ON Music
(music_id   ASC);

ALTER TABLE Music
	ADD CONSTRAINT  XPKMusic PRIMARY KEY (music_id);

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

CREATE TABLE Music_Theme
(
	music_id             INTEGER NOT NULL ,
	theme_id             INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKMusic_Theme ON Music_Theme
(music_id   ASC,theme_id   ASC);

ALTER TABLE Music_Theme
	ADD CONSTRAINT  XPKMusic_Theme PRIMARY KEY (music_id,theme_id);

CREATE TABLE Spot_post
(
	spot_id              INTEGER NOT NULL ,
	title                VARCHAR2(70) NULL ,
	contents             VARCHAR2(4000) NOT NULL ,
	user_id              INTEGER NOT NULL ,
	spot_date            DATE NOT NULL ,
	course_id            INTEGER NULL 
);

CREATE UNIQUE INDEX XPKSpot_post ON Spot_post
(spot_id   ASC);

ALTER TABLE Spot_post
	ADD CONSTRAINT  XPKSpot_post PRIMARY KEY (spot_id);

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

CREATE TABLE Course_comment
(
	comment_id           INTEGER NOT NULL ,
	contents             VARCHAR2(4000) NOT NULL ,
	user_id              INTEGER NOT NULL ,
	course_id            INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKCourse_comment ON Course_comment
(comment_id   ASC);

ALTER TABLE Course_comment
	ADD CONSTRAINT  XPKCourse_comment PRIMARY KEY (comment_id);

CREATE TABLE Course_Like
(
	user_id              INTEGER NOT NULL ,
	course_id            INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKCourse_like ON Course_Like
(user_id   ASC,course_id   ASC);

ALTER TABLE Course_Like
	ADD CONSTRAINT  XPKCourse_like PRIMARY KEY (user_id,course_id);

CREATE TABLE Post_comment
(
	pComment_id          INTEGER NOT NULL ,
	contents             VARCHAR2(4000) NOT NULL ,
	post_date            DATE NOT NULL ,
	user_id              INTEGER NOT NULL ,
	spot_id              INTEGER NOT NULL 
);

CREATE UNIQUE INDEX XPKPost_comment ON Post_comment
(pComment_id   ASC);

ALTER TABLE Post_comment
	ADD CONSTRAINT  XPKPost_comment PRIMARY KEY (pComment_id);

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

ALTER TABLE Course
	ADD (CONSTRAINT R_13 FOREIGN KEY (region_id) REFERENCES Region (region_id));

ALTER TABLE Course
	ADD (CONSTRAINT R_18 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Music
	ADD (CONSTRAINT R_15 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id) ON DELETE SET NULL);

ALTER TABLE Music
	ADD (CONSTRAINT R_11 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Music_Theme
	ADD (CONSTRAINT R_27 FOREIGN KEY (music_id) REFERENCES Music (music_id));

ALTER TABLE Music_Theme
	ADD (CONSTRAINT R_28 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id));

ALTER TABLE Spot_post
	ADD (CONSTRAINT R_19 FOREIGN KEY (course_id) REFERENCES Course (course_id) ON DELETE SET NULL);

ALTER TABLE Spot_post
	ADD (CONSTRAINT R_8 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Theme_Course
	ADD (CONSTRAINT R_30 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id));

ALTER TABLE Theme_Course
	ADD (CONSTRAINT R_31 FOREIGN KEY (course_id) REFERENCES Course (course_id));

ALTER TABLE Course_comment
	ADD (CONSTRAINT R_5 FOREIGN KEY (course_id) REFERENCES Course (course_id) ON DELETE SET NULL);

ALTER TABLE Course_comment
	ADD (CONSTRAINT R_4 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE Course_Like
	ADD (CONSTRAINT R_7 FOREIGN KEY (course_id) REFERENCES Course (course_id));

ALTER TABLE Course_Like
	ADD (CONSTRAINT R_6 FOREIGN KEY (user_id) REFERENCES User_info (user_id));

ALTER TABLE Post_comment
	ADD (CONSTRAINT R_10 FOREIGN KEY (spot_id) REFERENCES Spot_post (spot_id) ON DELETE SET NULL);

ALTER TABLE Post_comment
	ADD (CONSTRAINT R_9 FOREIGN KEY (user_id) REFERENCES User_info (user_id) ON DELETE SET NULL);

ALTER TABLE User_Region
	ADD (CONSTRAINT R_25 FOREIGN KEY (region_id) REFERENCES Region (region_id));

ALTER TABLE User_Region
	ADD (CONSTRAINT R_24 FOREIGN KEY (user_id) REFERENCES User_info (user_id));

ALTER TABLE User_Theme
	ADD (CONSTRAINT R_22 FOREIGN KEY (theme_id) REFERENCES Theme (theme_id));

ALTER TABLE User_Theme
	ADD (CONSTRAINT R_21 FOREIGN KEY (user_id) REFERENCES User_info (user_id));
