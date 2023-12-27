SELECT * FROM tab;

create table student (
student_no VARCHAR2(10) primary key,
student_name VARCHAR2(100) not null,
eng_score NUMBER DEFAULT 80,
math_score NUMBER default 70
);

--등록, 수정, 삭제, 단건조회, 목록
insert into student(student_no, student_name, eng_score, math_score)
values ('23-001', '홍길동', 70, 75);

insert into student(student_no, student_name)--, eng_score, math_score)
values ('23-006', '김민수');

select * from student order by 1;



UPDATE student
set eng_score = 85
    , math_score = 75
where student_no = '23-002';

delete from student where student_no = '23-002';

select * from student where student_no = '23-002';

create table book (
book_code VARCHAR2(10) primary key,
book_title VARCHAR2(100) not null,
author VARCHAR2(100),
press VARCHAR2(100),
price NUMBER default 15000
);

--등록
insert into book (book_code, book_title, author, press, price)
values ('B002', 'ORACLE SQL', '예담', 'YD', 20000);

--목록
select * from book order by 1;

--단건조회
select * from book where book_code = 'B002';

--수정
UPDATE book
set price = 30000
where book_code = 'B002';

--삭제
delete from book where book_code = 'B002';

-----------------미니프로젝트-------------------
--테이블 생성--
CREATE TABLE users(
name VARCHAR2(100),
id VARCHAR2(100) PRIMARY KEY,
password VARCHAR2(50) NOT NULL,
birth DATE,
division VARCHAR2(50)
);

CREATE TABLE lectures(
lecture_code VARCHAR2(20) PRIMARY KEY,
lecture_title VARCHAR2(100),
teacher_name VARCHAR2(50),
lecture_start DATE,
student_num NUMBER(10),
lecture_price NUMBER(30)
);

CREATE TABLE enrolment(
lecture_code VARCHAR2(20) PRIMARY KEY,
user_id VARCHAR2(100),
register_date DATE DEFAULT SYSDATE
);

select *
from lectures;

--강사 추가--
INSERT INTO users
VALUES('김수학', 'idt001','pwt001','1980-05-08','teacher');

--학생 추가--
INSERT INTO users 
VALUES ('나학생','id002','pw002','2006-12-20','student');

INSERT INTO users
VALUES('마학생', 'id003', 'pw003', '2015-05-06','student');

--강사 삭제--
DELETE FROM users
WHERE id = 'idt001'
AND password = 'pwt001';

--여러 테이블의 값 들고오기--
SELECT l.lecture_code, l.lecture_title, l.teacher_name, l.lecture_start, l.student_num, l.lecture_price
FROM lectures l,enrolment e 
WHERE  e.user_id= 'id001'
AND l.lecture_code = e.lecture_code;

--강의 등록--
INSERT INTO enrolment(lecture_code, user_id)
VALUES ('k001', 'id003');

--강의 추가--
INSERT INTO lectures
VALUES ('m003', '수학(다)', '김수학', '2023-12-25', 20, 250000);

--강의 취소--
DELETE FROM lectures 
WHERE lecture_code = 'm003'
AND teacher_name = '김수학';

--확인용 쿼리--
SELECT *
FROM lectures
where lecture_code='m003';


SELECT * 
FROM lectures;

ALTER TABLE users
DROP COLUMN email;

UPDATE lectures 
SET lecture_title = '수학(나)'
WHERE lecture_title = '수학(하)';

UPDATE lectures 
SET lecture_price = 300000
WHERE lecture_price = 3000000;

select id
from users
where id = 'id001';

select count(select * from enrolment where lecture_code='k001')as d
from lectures;

select * from lectures;

SELECT COUNT(*) AS dup FROM enrolment 
WHERE lecture_code='k002'
AND user_id='id001';

select *
from enrolment;
SELECT lecture_code, user_id, COUNT(*) FROM enrolment GROUP BY lecture_code, user_id HAVING COUNT(*)>1;

select count(*) from enrolment where lecture_code='k001';

--여러 테이블 값 가져오기--
select l.lecture_code, l.lecture_title, l.teacher_name, l.student_num, l.lecture_start, l.lecture_price
from lectures l, enrolment e
where l.lecture_code = e.lecture_code;

insert into enrolment(lecture_code, user_id)
values ('k001', 'id001');



---------2023-12-22----------

CREATE TABLE board(
    board_no number primary key,
    title varchar2(100) not null,
    content VARCHAR2(500) not null,
    writer VARCHAR2(50) not null,
    write_date date default sysdate,
    click_cnt number default 0,
    image varchar2(100)
);

create SEQUENCE board_seq;


INSERT INTO board(board_no, title, writer, content) 
VALUES (board_seq.nextval, '오늘은 금요일', '김박사', '불코딩하자');

INSERT INTO board(board_no, title, writer, content) 
VALUES (board_seq.nextval, '우리반 화이팅!!', '김막내', '열심히 공부해요');

SELECT * 
FROM board order by 1;

----2023-12-26----
select * from tab;

create table member(
    id varchar2(20) primary key,
    pw varchar2(10) not null,
    name varchar2(100) not null,
    responsibility varchar2(10) default 'User' --Admin/User
);

insert into member values('user1','1111','홍길동','User');
insert into member values('user2','2222','김철수','User');
insert into member values('user3','3333','관리자','Admin');

commit;

----2023-12-27
select * from student;