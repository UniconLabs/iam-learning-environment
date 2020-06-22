CREATE USER sis WITH PASSWORD 'sis' CREATEDB;
ALTER user sis WITH superuser;
CREATE DATABASE sis;

\c sis

CREATE TABLE SIS_COURSES (
    uid varchar(255) NOT NULL,
    courseId varchar(255) default NULL,
    PRIMARY KEY (uid, courseId)
);

COPY SIS_COURSES(uid, courseId) FROM '/tmp/pdata/sis.csv' DELIMITER ',' CSV HEADER ;