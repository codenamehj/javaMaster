--砺戚鷺持失

--噺据
CREATE TABLE member (
	user_id	varchar2(100)		primary key,
	user_pw	varchar2(100)		NOT NULL,
	user_name	varchar2(100)		NOT NULL,
	gender	varchar2(100)		NULL,
	phone_num	varchar2(100)		NULL,
	email	varchar2(100)		NULL,
	status	varchar2(100)		NULL
);

--舌郊姥艦
CREATE TABLE cart (
	mypro_no	number		primary key,
	user_id	varchar2(100)		NOT NULL,
	pro_code	number		NOT NULL,
	mypro_price	number		NULL,
	mypro_cnt	 number		NULL
);

--雌念
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

--庚税
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

--爽庚鎧蝕
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

--爽庚雌室
CREATE TABLE orderdetail (
	order_no	number		primary key,
    pro_code	number		,
	de_pro_cnt	number		NULL,
	de_pro_price	number		NULL
);

--雌念軒坂
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

--雌念戚耕走
CREATE TABLE productimage (
	img_no	number		primary key,
	pro_code	number		NOT NULL,
	img_prop	varchar2(200)		NULL,
	image	varchar2(500)		NULL
);

--砺戚鷺 持失 凶 奄沙徹幻 竺舛背辞 持失 刃戟.

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
 values ('user1', '1111', '畠掩疑', '害', '010-1111-1111', 'user1@naver.com', 'user');
insert into member
 values ('user2', '2222', '戚走精', '食', '010-2222-2222', 'user2@naver.com', 'user'); 
insert into member
 values ('user3', '3333', '戚推廃', '害', '010-3333-3333', 'user3@naver.com', 'user');
insert into member
 values ('user4', '4444', '沿走慎', '食', '010-4444-4444', 'user4@naver.com', 'user'); 
insert into member
 values ('user5', '5555', '沿走精', '食', '010-5555-5555', 'user5@naver.com', 'user');  
 
--cart
select * from cart;

insert into cart
 values (3, 'user1', 1, 20000, 2); 
insert into cart
 values (4, 'user2', 3, 10000, 1);  
 
--product
select * from product;

insert into product
 values (3, '2024 是適軒', '疏焼推', 'b1.jpg', 20000, 18000, 0, 50, '陥戚嬢軒');
insert into product
 values (4, '2024 胡十軒', '疏焼推', 'b1.jpg', 28000, 25000, 0, 50, '陥戚嬢軒');
insert into product
 values (5, '2024 超鍵希', '疏焼推', 'b1.jpg', 15000, 10000, 0, 50, '超鍵希'); 

--inquire
select * from inquire order by 1;

insert into inquire
 values (inq_no_seq.nextval, 'user1', 3, '庚税球形推', 'しししししししし', '2024/01/15', 'D001.png', '岩痕', '2024 是適軒');
insert into inquire
 values (inq_no_seq.nextval, 'user5', 3, '庚税球形推', 'しししししししし', '2024/01/15', 'D002.png', '岩痕', '2024 是適軒');
insert into inquire
 values (inq_no_seq.nextval, 'user1', 5, '庚税球形推', 'しししししししし', '2024/01/15', 'D002.png', '岩痕', '2024 超鍵希');
insert into inquire
 values (inq_no_seq.nextval, 'user3', 4, '庚税球形推', 'しししししししし', '2024/01/15', 'D001.png', '岩痕', '2024 胡十軒');

--orderlist
select * from orderlist;

insert into orderlist 
 values (24011501, '2024/01/15', 'user1', '畠掩疑', '企姥', '含辞姥', '010-1111-1111', 13500, 3000,  '庚蒋'); 
insert into orderlist 
 values (24011504, '2024/01/15', 'user2', '戚走精', '企姥', '含辞姥', '010-2222-2222', 50000, 0, '庚蒋'); 
insert into orderlist 
 values (240115013, '2024/01/15', 'user3', '戚推廃', '企姥', '含辞姥', '010-3333-3333', 18000, 3000, '庚蒋');

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
 values (1, 24011501, 1, 'user1', '軒坂', 3,'ししししししし', 'pen_Sample.jpg', '2024/01/18');
insert into review
 values (2, 24011504, 4, 'user2', '軒坂', 5,'ししししししし', 'b1.jpg', '2024/01/18'); 
 
--productimage
select * from productimage;

insert into productimage
 values (1, 1, '五昔', 'pen_Sample.jpg');
insert into productimage
 values (2, 1, '雌室', 'pen_Sample.jpg');
insert into productimage
 values (3, 1, '雌室', 'pen_Sample.jpg');
insert into productimage
 values (4, 1, '雌室', 'pen_Sample.jpg');
insert into productimage
 values (5, 2, '五昔', 'diary_sample.jpg'); 
insert into productimage
 values (6, 2, '雌室', 'diary_sample.jpg'); 
insert into productimage
 values (7, 2, '雌室', 'diary_sample.jpg'); 
insert into productimage
 values (8, 2, '雌室', 'diary_sample.jpg');  
 

 -- 琶推廃 獣碇什 葵級

--舌郊姥艦(mypro_no_seq)
CREATE SEQUENCE mypro_no_seq;
--雌念(pro_code_seq)
CREATE SEQUENCE pro_code_seq;
--庚税(inq_no_seq)
CREATE SEQUENCE inq_no_seq;
--爽庚(order_no_seq)
CREATE SEQUENCE order_no_seq;
--軒坂(re_no_seq)
CREATE SEQUENCE re_no_seq;
--戚耕走(img_no_seq)
CREATE SEQUENCE img_no_seq;


--mapper遂
select pro_code, pro_name from product
where category='陥戚嬢軒';

select * from inquire order by 1;

insert into inquire(inq_no, user_id, pro_code, inq_title, inq_content, inq_date, inq_img, prod_name)
values(inq_no_seq.nextval, 'user2', '5', '庚税球形推', 'しししししししし', sysdate, 'D001.png', '2024 胡十軒');

update inquire set inq_content ='ggggg', inq_img='D001.png' where inq_no = 4;


select b.* from
(select rownum rn, a.* from
    (select * from inquire) a 
)b
where b.rn > (1-1)*9 and b.rn <= 1*9 order by inq_no;