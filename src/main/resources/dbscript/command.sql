
CREATE TABLE potential_user
(
    user_id varchar(32) NOT NULL PRIMARY KEY,
    user_name varchar(64)  NULL UNIQUE,
    email varchar (64)   NULL UNIQUE,
    mobile varchar (32) NULL UNIQUE,
    type varchar(32),
    password varchar(512),
    enable boolean default true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);


CREATE TABLE prominent_user
(
    user_id varchar(32) NOT NULL PRIMARY KEY,
    user_name varchar(64)  NULL UNIQUE,
    email varchar (64)   NULL UNIQUE,
    mobile varchar (32) NULL UNIQUE,
    type varchar(32),
    password varchar(512),
    enable boolean default true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

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


