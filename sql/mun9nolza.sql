--테이블생성

--회원
CREATE TABLE member (
	user_id	varchar2(100)		primary key,
	user_pw	varchar2(100)		NOT NULL,
	user_name	varchar2(100)		NOT NULL,
	gender	varchar2(100)		NULL,
	phone_num	varchar2(100)		NULL,
	email	varchar2(100)		NULL,
	status	varchar2(100)		NULL
);

--장바구니
CREATE TABLE cart (
	mypro_no	number		primary key,
	user_id	varchar2(100)		NOT NULL,
	pro_code	number		NOT NULL,
	mypro_price	number		NULL,
	mypro_cnt	 number		NULL
);

--상품
CREATE TABLE product (
	pro_code	number		primary key,
	pro_name	varchar2(100)		NULL,
	pro_desc	clob		NULL,
	pro_image	varchar2(500)		NULL,
	pro_price	number		NULL,
	pro_discount	number		NULL,
	pro_sell	number		NULL,
	pro_stock	number		NULL,
	category	varchar2(200)		NULL
);

--문의
CREATE TABLE inquire (
	inq_no	number		primary key,
	user_id	varchar2(100)		NOT NULL,
	pro_code	number		NOT NULL,
	inq_title	varchar2(200)		NULL,
	inq_content	varchar2(500)		NULL,
	inq_date	date		NULL,
	inq_img	varchar2(300)		NULL,
	answer	varchar2(300)		NULL
);

--주문내역
CREATE TABLE orderlist (
	order_no	number		primary key,
	order_date	date	DEFAULT sysdate	NULL,
	user_id	varchar2(100)		NOT NULL,
	order_recipient	varchar2(100)		NULL,
	order_addr	varchar2(200)		NULL,
	detail_addr	varchar2(500)		NULL,
	order_phone	varchar2(100)		NULL,
	total_price	number		NULL,
	delivery_fee	number		NULL,
	delivery_memo	varchar2(500)		NULL
);

--주문상세
CREATE TABLE orderdetail (
	order_no	number		primary key,
    pro_code	number		,
	de_pro_cnt	number		NULL,
	de_pro_price	number		NULL
);

--상품리뷰
CREATE TABLE review (
	re_no	number		primary key,
	order_no	number		NULL,
	pro_code	number		NOT NULL,
	user_id	varchar2(100)		NULL,
	re_title	varchar2(100)		NULL,
	re_rate	number		NULL,
	re_content	 varchar2(500)		NULL,
	re_image	varchar2(100)		NULL,
	re_date	date	DEFAULT sysdate	NULL
);

--상품이미지
CREATE TABLE productimage (
	img_no	number		primary key,
	pro_code	number		NOT NULL,
	img_prop	varchar2(200)		NULL,
	image	varchar2(500)		NULL
);

--테이블 생성 때 기본키만 설정해서 생성 완료.

CREATE TABLE member (
	user_id	varchar2(100)		NOT NULL,
	user_pw	varchar2(100)		NOT NULL,
	user_name	varchar2(100)		NOT NULL,
	gender	varchar2(100)		NULL,
	phone_num	varchar2(100)		NULL,
	email	varchar2(100)		NULL,
	status	varchar2(100)		NULL
);

CREATE TABLE cart (
	mypro_no	number		NULL,
	user_id	varchar2(100)		NOT NULL,
	pro_code	number		NOT NULL,
	mypro_price	number		NULL,
	mypro_cnt	number		NULL
);

CREATE TABLE product (
	pro_code	number		NOT NULL,
	pro_name	varchar2(100)		NULL,
	pro_desc	clob		NULL,
	pro_image	varchar2(500)		NULL,
	pro_price	number		NULL,
	pro_discount	number		NULL,
	pro_sell	number		NULL,
	pro_stock	number		NULL,
	category	varchar2(200)		NULL
);

--DROP TABLE inquire;
CREATE TABLE inquire (
	inq_no	number		NOT NULL,
	user_id	varchar2(100)		NOT NULL,
	pro_code	number		NOT NULL,
	inq_title	varchar2(200)		NULL,
	inq_content	varchar2(500)		NULL,
	inq_date	date		NULL,
	inq_img	varchar2(300)		NULL,
	answer	varchar2(300)		NULL,
	prod_name	varchar2(100)	NOT NULL
);

CREATE TABLE orderlist (
	order_no	number		NULL,
	order_date	date	DEFAULT sysdate	NULL,
	pro_code	number		NOT NULL,
	user_id	varchar2(100)		NOT NULL,
	order_recipient	varchar2(100)		NULL,
	order_addr	varchar2(300)		NULL,
	detail_addr	varchar2(500)		NULL,
	order_phone	varchar2(100)		NULL,
	total_price	number		NULL,
	delivery_fee	number		NULL,
	delivery_memo	varchar2(500)		NULL,
	order_status	varchar2(100)		NULL
);

CREATE TABLE review (
	re_no	number		NOT NULL,
	order_no	number		NULL,
	pro_code	number		NOT NULL,
	user_id	varchar2(100)		NULL,
	re_title	varchar2(100)		NULL,
	re_rate	number		NULL,
	re_content	varchar2(500)		NULL,
	re_image	varchar2(100)		NULL,
	re_date	date	DEFAULT sysdate	NULL
);

CREATE TABLE productimage (
	img_no	number		NULL,
	pro_code	number		NOT NULL,
	img_prop	varchar2(200)		NULL,
	image	varchar2(500)		NULL
);

CREATE TABLE orderdetail (
	pro_code	number		NOT NULL,
	order_no	number		NULL,
	de_pro_cnt	number		NULL,
	de_pro_price	number		NULL
);


-----------------------------------------------------------------------
commit;

--member
select * from member;

insert into member
 values ('user1', '1111', '홍길동', '남', '010-1111-1111', 'user1@naver.com', 'user');
insert into member
 values ('user2', '2222', '이지은', '여', '010-2222-2222', 'user2@naver.com', 'user'); 
insert into member
 values ('user3', '3333', '이요한', '남', '010-3333-3333', 'user3@naver.com', 'user');
insert into member
 values ('user4', '4444', '김지영', '여', '010-4444-4444', 'user4@naver.com', 'user'); 
insert into member
 values ('user5', '5555', '김지은', '여', '010-5555-5555', 'user5@naver.com', 'user');  
 
--cart
select * from cart;

insert into cart
 values (3, 'user1', 1, 20000, 2); 
insert into cart
 values (4, 'user2', 3, 10000, 1);  
 
--product
select * from product;

insert into product
 values (3, '2024 위클리', '좋아요', 'b1.jpg', 20000, 18000, 0, 50, '다이어리');
insert into product
 values (4, '2024 먼슬리', '좋아요', 'b1.jpg', 28000, 25000, 0, 50, '다이어리');
insert into product
 values (5, '2024 캘린더', '좋아요', 'b1.jpg', 15000, 10000, 0, 50, '캘린더'); 

--inquire
select * from inquire order by 1;

insert into inquire
 values (inq_no_seq.nextval, 'user1', 3, '문의드려요', 'ㅇㅇㅇㅇㅇㅇㅇㅇ', '2024/01/15', 'D001.png', '답변', '2024 위클리');
insert into inquire
 values (inq_no_seq.nextval, 'user5', 3, '문의드려요', 'ㅇㅇㅇㅇㅇㅇㅇㅇ', '2024/01/15', 'D002.png', '답변', '2024 위클리');
insert into inquire
 values (inq_no_seq.nextval, 'user1', 5, '문의드려요', 'ㅇㅇㅇㅇㅇㅇㅇㅇ', '2024/01/15', 'D002.png', '답변', '2024 캘린더');
insert into inquire
 values (inq_no_seq.nextval, 'user3', 4, '문의드려요', 'ㅇㅇㅇㅇㅇㅇㅇㅇ', '2024/01/15', 'D001.png', '답변', '2024 먼슬리');

--orderlist
select * from orderlist;

insert into orderlist 
 values (24011501, '2024/01/15', 'user1', '홍길동', '대구', '달서구', '010-1111-1111', 13500, 3000,  '문앞'); 
insert into orderlist 
 values (24011504, '2024/01/15', 'user2', '이지은', '대구', '달서구', '010-2222-2222', 50000, 0, '문앞'); 
insert into orderlist 
 values (240115013, '2024/01/15', 'user3', '이요한', '대구', '달서구', '010-3333-3333', 18000, 3000, '문앞');

--orderdetail
select * from orderdetail;

insert into orderdetail
 values (24011501, 1, 5, 13500);
insert into orderdetail
 values (24011504, 4, 2, 50000);
insert into orderdetail
 values (24011503, 3, 1, 18000); 
insert into orderdetail
 values (24011403, 3, 1, 18000); 
 
--review
select * from review;

insert into review
 values (1, 24011501, 1, 'user1', '리뷰', 3,'ㅇㅇㅇㅇㅇㅇㅇ', 'pen_Sample.jpg', '2024/01/18');
insert into review
 values (2, 24011504, 4, 'user2', '리뷰', 5,'ㅇㅇㅇㅇㅇㅇㅇ', 'b1.jpg', '2024/01/18'); 
 
--productimage
select * from productimage;

insert into productimage
 values (1, 1, '메인', 'pen_Sample.jpg');
insert into productimage
 values (2, 1, '상세', 'pen_Sample.jpg');
insert into productimage
 values (3, 1, '상세', 'pen_Sample.jpg');
insert into productimage
 values (4, 1, '상세', 'pen_Sample.jpg');
insert into productimage
 values (5, 2, '메인', 'diary_sample.jpg'); 
insert into productimage
 values (6, 2, '상세', 'diary_sample.jpg'); 
insert into productimage
 values (7, 2, '상세', 'diary_sample.jpg'); 
insert into productimage
 values (8, 2, '상세', 'diary_sample.jpg');  
 

 -- 필요한 시퀀스 값들

--장바구니(mypro_no_seq)
CREATE SEQUENCE mypro_no_seq;
--상품(pro_code_seq)
CREATE SEQUENCE pro_code_seq;
--문의(inq_no_seq)
CREATE SEQUENCE inq_no_seq;
--주문(order_no_seq)
CREATE SEQUENCE order_no_seq;
--리뷰(re_no_seq)
CREATE SEQUENCE re_no_seq;
--이미지(img_no_seq)
CREATE SEQUENCE img_no_seq;


--mapper용
select pro_code, pro_name from product
where category='다이어리';

select * from inquire order by 1;

insert into inquire(inq_no, user_id, pro_code, inq_title, inq_content, inq_date, inq_img, prod_name)
values(inq_no_seq.nextval, 'user2', '5', '문의드려요', 'ㅇㅇㅇㅇㅇㅇㅇㅇ', sysdate, 'D001.png', '2024 먼슬리');

update inquire set inq_content ='ggggg', inq_img='D001.png' where inq_no = 4;


select b.* from
(select rownum rn, a.* from
    (select * from inquire) a 
)b
where b.rn > (1-1)*9 and b.rn <= 1*9 order by inq_no;