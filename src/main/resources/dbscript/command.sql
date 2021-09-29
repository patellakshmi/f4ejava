drop database f4e;
create database f4e;
use f4e;

CREATE TABLE potential_user
(
    user_id varchar(32) NOT NULL PRIMARY KEY,
    user_name varchar(64)  NULL UNIQUE,
    email varchar (64)   NULL UNIQUE,
    mobile varchar (32) NULL UNIQUE,
    type varchar(32),
    password varchar(512),
    enable tinyint(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL

);


CREATE TABLE prominent_user
(
    user_id varchar(32) NOT NULL PRIMARY KEY,
    user_name varchar(64)  NULL UNIQUE,
    email varchar (64)   NULL UNIQUE,
    mobile varchar (32) NULL UNIQUE,
    type varchar(32),
    password varchar(512),
    enable tinyint(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL

);

CREATE TABLE slider_image
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64)  NULL,
    description varchar(128)  NULL,
    image_url varchar(512) NULL,
    position INT NULL,
    enable tinyint(1) default 0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE objective
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(64)  NULL,
    objective varchar(2048)  NULL,
    enable tinyint(1) default 0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);



CREATE TABLE course
(
    id varchar(32) NOT NULL PRIMARY KEY,
    name varchar(64)  NULL,
    head varchar(64)  NULL,
    head_email varchar(64)  NULL,
    head_phone varchar(64)  NULL,
    fee DECIMAL (10,2) NULL,
    currency varchar(32),
    off DECIMAL (10,2),
    off_keyword varchar(16) NULL,
    off_mode varchar(16) NULL,
    stream_std varchar(32) NULL,
    duration INT NULL ,
    duration_unit varchar(14) NULL,
    mode varchar(32) NULL,
    image_url varchar(512) NULL,
    description varchar(32) NULL,
    benefit varchar(218) NULL,
    enable tinyint(1) DEFAULT 0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL

);


CREATE TABLE course_platform
(
    id INT AUTO_INCREMENT NOT NULL,
    name varchar(64)  NULL,
    image_url varchar(512) NULL,
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE platform_detail
(
    id INT AUTO_INCREMENT NOT NULL,
    name varchar(64)  NULL,
    image_url varchar(512) NULL,
    course_url varchar(512) NULL,
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    course_id varchar(32),
    PRIMARY KEY(id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    UNIQUE KEY(course_id, name )
);


CREATE TABLE teacher
(
    id varchar(32) NOT NULL,
    name varchar(64)  NULL,
    subject varchar(512) NULL,
    address varchar(512) NULL,
    phone varchar(32) DEFAULT NULL,
    email varchar(32) DEFAULT NULL,
    degree varchar(32) DEFAULT NULL,
    status varchar(32) DEFAULT NULL,
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);



CREATE TABLE batch
(
    id varchar(32) NOT NULL,
    course_id varchar(32),
    name varchar(64) NULL,
    mode varchar(64) NULL,
    address varchar(128) NULL,
    latitude float DEFAULT NULL,
    longitude float DEFAULT NULL,
    duration int DEFAULT NULL,
    duration_unit varchar(16) DEFAULT NULL,
    started_at date default NULL,
    status varchar(32) DEFAULT NULL,
    enable tinyint(1) default  1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE subject
(
    id varchar(32) NOT NULL,
    name varchar(64)  NULL,
    description varchar(512) NULL,
    stream_std varchar(64) DEFAULT NULL,
    year int DEFAULT NULL,
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    course_id varchar(32),
    FOREIGN KEY (course_id) REFERENCES course(id),
    PRIMARY KEY(id)
);

CREATE TABLE subject_part
(
    id varchar(32) NOT NULL,
    name varchar(64)  NULL,
    description varchar(512) NULL,
    sub_id varchar(32),
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (sub_id) REFERENCES subject(id)
);


CREATE TABLE combo_timeslot
(
    id int NOT NULL AUTO_INCREMENT,
    batch_id varchar(32),
    enable tinyint(1) default  1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (batch_id) REFERENCES batch(id)
);


CREATE TABLE timeslot
(
    id int NOT NULL AUTO_INCREMENT,
    start_at TIME,
    end_at TIME,
    subject_part_id varchar(32) default NULL,
    combo_timeslot_id int default NULL,
    enable tinyint(1) default 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (combo_timeslot_id) REFERENCES combo_timeslot(id),
    FOREIGN KEY (subject_part_id) REFERENCES subject_part(id)
);


CREATE TABLE timetable
(
    id int NOT NULL AUTO_INCREMENT,
    week_num int NOT NULL,
    batch_id varchar(64) NULL,
    month int NULL,
    day_of_month int NULL,
    sunday int,
    monday int,
    tuesday int,
    wednesday int,
    thursday int,
    friday int,
    saturday int,
    enable tinyint(1) default  1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (batch_id) REFERENCES batch(id),
    UNIQUE KEY (batch_id, week_num),
    FOREIGN KEY (sunday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (monday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (tuesday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (wednesday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (thursday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (friday) REFERENCES combo_timeslot(id),
    FOREIGN KEY (saturday) REFERENCES combo_timeslot(id)
);

CREATE TABLE teacher_batch_subject_part
(
    teacher_id varchar(32) NOT NULL,
    batch_id varchar(64) NOT NULL,
    subject_part_id varchar(64) NOT NULL,
    enable tinyint(1) default  0 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (teacher_id, subject_part_id,batch_id)
);


CREATE TABLE teacher_allocation
(
    id int NOT NULL AUTO_INCREMENT,
    week_num int NOT NULL,
    batch_id varchar(64),
    subject_part_id varchar(64),
    month int NULL,
    day_of_month int NULL,
    sunday varchar(32),
    monday varchar(32),
    tuesday varchar(32),
    wednesday varchar(32),
    thursday varchar(32),
    friday varchar(32),
    saturday varchar(32),
    enable tinyint(1) default  1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (batch_id) REFERENCES batch(id),
    FOREIGN KEY (subject_part_id) REFERENCES subject_part(id),
    UNIQUE KEY (batch_id, week_num,subject_part_id),
    FOREIGN KEY (sunday) REFERENCES teacher(id),
    FOREIGN KEY (monday) REFERENCES teacher(id),
    FOREIGN KEY (tuesday) REFERENCES teacher(id),
    FOREIGN KEY (wednesday) REFERENCES teacher(id),
    FOREIGN KEY (thursday) REFERENCES teacher(id),
    FOREIGN KEY (friday) REFERENCES teacher(id),
    FOREIGN KEY (saturday) REFERENCES teacher(id)
);


CREATE USER 'web'@'localhost' IDENTIFIED WITH mysql_native_password BY 'web@f4e';
CREATE USER 'super'@'%' IDENTIFIED WITH mysql_native_password BY 'super@f4e';
CREATE USER 'admin'@'%' IDENTIFIED WITH mysql_native_password BY 'admin@f4e';
CREATE USER 'dev'@'%' IDENTIFIED WITH mysql_native_password BY 'dev@f4e';
CREATE USER 'qa'@'%' IDENTIFIED WITH mysql_native_password BY 'qa@f4e';
GRANT ALL ON *.* TO 'super'@'%';
GRANT ALL ON *.* TO 'admin'@'%';
GRANT ALL ON *.* TO 'dev'@'%';
GRANT ALL ON *.* TO 'qa'@'%';
GRANT ALL ON *.* TO 'web'@'localhost';
flush privileges;


DROP USER 'admin'@'%';
DROP USER 'super'@'%';
DROP USER 'web'@'localhost';


