SELECT * FROM tab;

create table student (
student_no VARCHAR2(10) primary key,
student_name VARCHAR2(100) not null,
eng_score NUMBER DEFAULT 80,
math_score NUMBER default 70
);

--���?, ����, ����, �ܰ���ȸ, ���?
insert into student(student_no, student_name, eng_score, math_score)
values ('23-001', 'ȫ�浿', 70, 75);

insert into student(student_no, student_name)--, eng_score, math_score)
values ('23-006', '��μ�?');

select * from student order by 1;



UPDATE student
set eng_score = 85
    , math_score = 75
where student_no = '23-002';

delete from student where student_no = '23-001';

select * from student where student_no = '23-002';

create table book (
book_code VARCHAR2(10) primary key,
book_title VARCHAR2(100) not null,
author VARCHAR2(100),
press VARCHAR2(100),
price NUMBER default 15000
);

--���?
insert into book (book_code, book_title, author, press, price)
values ('B002', 'ORACLE SQL', '����', 'YD', 20000);

--���?
select * from book order by 1;

--�ܰ���ȸ
select * from book where book_code = 'B002';

--����
UPDATE book
set price = 30000
where book_code = 'B002';

--����
delete from book where book_code = 'B002';                                

-----------------�̴�������Ʈ-------------------
--���̺� ����--
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

--���� �߰�--
INSERT INTO users
VALUES('�����?', 'idt001','pwt001','1980-05-08','teacher');

--�л� �߰�--
INSERT INTO users 
VALUES ('���л�','id002','pw002','2006-12-20','student');

INSERT INTO users
VALUES('���л�', 'id003', 'pw003', '2015-05-06','student');

--���� ����--
DELETE FROM users
WHERE id = 'idt001'
AND password = 'pwt001';

--���� ���̺��� �� ������--
SELECT l.lecture_code, l.lecture_title, l.teacher_name, l.lecture_start, l.student_num, l.lecture_price
FROM lectures l,enrolment e 
WHERE  e.user_id= 'id001'
AND l.lecture_code = e.lecture_code;

--���� ���?--
INSERT INTO enrolment(lecture_code, user_id)
VALUES ('k001', 'id003');

--���� �߰�--
INSERT INTO lectures
VALUES ('m003', '����(��)', '�����?', '2023-12-25', 20, 250000);

--���� ���?--
DELETE FROM lectures 
WHERE lecture_code = 'm003'
AND teacher_name = '�����?'; 


--Ȯ�ο� ����--
SELECT *
FROM lectures
where lecture_code='m003';


SELECT * 
FROM lectures;

ALTER TABLE users
DROP COLUMN email;

UPDATE lectures 
SET lecture_title = '����(��)'
WHERE lecture_title = '����(��)';

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

--���� ���̺� �� ��������--
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
VALUES (board_seq.nextval, '������ �ݿ���', '��ڻ�', '���ڵ�����');

INSERT INTO board(board_no, title, writer, content) 
VALUES (board_seq.nextval, '�츮�� ȭ����!!', '�踷��', '������ �����ؿ�');

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

insert into member values('user1','1111','ȫ�浿','User');
insert into member values('user2','2222','��ö��','User');
insert into member values('user3','3333','������','Admin');
insert into member values('user4','4444','������','User');
insert into member values('user5','5555','��¯��','User');

commit;


----2023-12-27
select * from student;

----2023-12-28
select * from member;
-----����-----
create table product (
 product_code char(8) primary key, -- P2023-01
 product_name varchar2(100) not null,
 product_desc varchar2(300) not null,
 origin_price number not null,
 sale_price number,
 like_it number default 3, --��õ��
 image varchar2(30)
);
insert into product values('P2023-01', '���׸��� ��Ƽ����', '���׸��� ��Ƽ���� �����Դϴ�.', 5000, 4500, 5, '���׸���.jpg');
insert into product values('P2023-02', '��ī�󱸾� �ƶ��ī', '��ī�󱸾� �ƶ��ī �����Դϴ�.', 5500, 4500, 4, '��ī�󱸾� ��ġ.jpg');
insert into product values('P2023-03', '��������佺', '��������佺 �����Դϴ�.', 6000, 5000, 3, '��������佺.jpg');
insert into product values('P2023-04', '��Ƽ���Ǿ� ����ü��', '��Ƽ���Ǿ� ����ü�� �����Դϴ�.', 4000, 3500, 2, '��Ƽ���Ǿ�.jpg');
insert into product values('P2023-05', '�ɳ� ��ũ�����', '�ɳ� ��ũ����� �����Դϴ�.', 4500, 3000, 1, '�ɳ� ��ũ�����.jpg');
insert into product values('P2023-06', '�ڽ�Ÿ��ī ������', '�ڽ�Ÿ��ī ������ �����Դϴ�.', 3000, 2500, 0, '�ڽ�Ÿ��ī ������.jpg');

select * from product order by 1;


-- ���(��۹�ȣ, �Խñ۹�ȣ, ����, �ۼ���, �ۼ��Ͻ�)
CREATE TABLE reply(
    reply_no number primary key,
    board_no number not null,
    reply varchar2(100) not null,
    replyer varchar2(30) not null,
    reply_date date default sysdate
);
CREATE SEQUENCE reply_seq;

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 3, 'abc', 'user1');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 14, 'apple', 'user1');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 14, 'banana', 'user2');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 2, '������', 'user2');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 2, '������22', 'user1');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 3, '������!!', 'user2');

INSERT INTO reply(reply_no,board_no,reply,replyer)
VALUES (reply_seq.nextval, 1, '������!!', 'user5');

select r.*, m.name 
from reply r
join member m
on r.replyer = m.id
where board_no = 14
order by 1;

SELECT *
FROM reply
where board_no=2
order by 1;

commit;

--��� ����¡
select b.* from
    (select rownum rn, a.* from
        (
            select r.*, m.name 
            from reply r
            join member m
            on r.replyer = m.id
            where board_no = 14
            order by 1
    ) a)b
where b.rn > 0 and rownum<=5;

--��� ���� �� ��� Ȯ�� ��Ʈ
select * from reply;
select * from member;

select name, count(*)
from reply r
join member m
on r.replyer = m.id
group by name;


--2024-01-10
alter table member add image varchar2(100);
select * from member;

delete from member where id='user6';

commit;

--2024-01-10 test
create table books (
 book_code varchar2(10) primary key,
 book_name varchar2(100) not null,
 book_author varchar2(100) not null,
 book_press varchar2(100) not null,
 book_price number not null
);

insert into books values('B001','�̰��� �ڹٴ�','�ſ��','�Ѻ��̵��',28000);
insert into books values('B002','�׼ǰ���','��¯��','�Ѻ��̵��',10000);
insert into books values('B003','��°� �� ����','�Ƿη�','�Ѻ��̵��',17000);
insert into books values('B004','�����ٶ󸶹ٻ�','�������','�Ѻ��̵��',21000);
insert into books values('B005','���� ������ ������ �˸��� ����','�̼���','�Ѻ��̵��',30000);
