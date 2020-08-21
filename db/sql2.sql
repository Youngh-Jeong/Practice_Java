use test;  -- test DB를 사용하겠다는 의미

create table t_member(
	uid varchar(20) primary key, 		-- 회원 아이디
    pwd varchar(20) not null,			-- 비밀번호
    name varchar(50) not null,			-- 이름
	phone varchar(13) not null,			-- 휴대폰 번호
    birth char(10) not null,			-- 생년월일(yyyy-mm-dd)
    gender char(1) not null,			-- 성별(M: 남, F : 여)
    email varchar(50) not null,			-- 이메일
    recommend varchar(20),				-- 추천인 아이디
    ismail char(1) default 'Y',			-- 메일수신 여부(Y : 수신, N : 미수신)
    issms char(1) default 'Y',			-- sms수신 여부(Y : 수신, N : 미수신)
    grade char(1) default 'D',			-- 등급
    point int default 0,				-- 보유 포인트
    lastvisit datetime default now(),	-- 최종 방문일
    joindate datetime default now(),	-- 회원 가입일
    isactive char(1) default 'Y'		-- 계정 사용여부(Y:사용, N:탈퇴, S:휴면)
    
);

create table t_address(
	aid int unsigned auto_increment primary key,		-- 주소ID
    uid	varchar(20),									-- 회원ID
    zip char(5) not null,								-- 우편번호
    addr1 varchar(50) not null,							-- 주소1
    addr2 varchar(50) not null,							-- 주소2
	isprime char(1) default 'N',						-- 기본배송지 여부
    constraint fk_t_address_uid foreign key (uid) references t_member (uid) on delete cascade
    -- uid컬럼은 반드시 t_member의 uid들 중 하나여야 함
    -- t_member의 uid들 중 하나라도 삭제되면 동일한 값을 가진 t_address의 uid도 삭제
);

drop table t_address;

create table t_address(
	aid int unsigned auto_increment primary key,		-- 주소ID
    uid	varchar(20),									-- 회원ID
    zip char(5) not null,								-- 우편번호
    addr1 varchar(50) not null,							-- 주소1
    addr2 varchar(50) not null,							-- 주소2
	isprime char(1) default 'N'						-- 기본배송지 여부
);

alter table t_address add constraint fk_t_address_uid
	foreign key(uid) references t_member(uid) on delete cascade;
-- 특정 테이블에 외래키를 추가하는 구문

-- 임시(temporary) 테이블로서 현재 DB가 꺼지기 전까지만 남아있는 테이블로 잠깐동안 테스트하는 용도로 사용됨
-- 잠깐동안 테스트하는 용도로 사용됨
create temporary table tmp(
	uid varchar(20) primary key,
    pwd varchar(20) not null
);

select * from tmp;
insert into tmp values ('test', '1234');

create table t_memberlist(
	ml_id varchar(20) primary key, 		-- 아이디
    ml_pwd varchar(20) not null,	    -- 암호
    ml_name varchar(50) not null, 		-- 이름
    ml_phone varchar(13) not null,		-- 전화번호
    ml_zip char(5) not null, 			-- 우편번호
    ml_addr1 varchar(50) not null,		-- 주소1
    ml_addr2 varchar(50) not null 		-- 주소2
);
insert into t_memberlist values ('test2', '1234','홍길동','010-1234-5678','12345','서울시 강남구 논현동', '123-456');

-- 회원의 이름을 '전우치'로 변경
update t_memberlist set ml_name = '홍길동' where ml_id = 'test';

delete from t_memberlist where ml_id = 'test2';
select * from t_memberlist;
create table t_productlist(
	pl_id varchar(20) primary key,	-- 상품 아이디
    pl_name varchar(50) not null,  	-- 상품명
    pl_price int default 0,			-- 가격
    pl_origin varchar(20) not null, -- 원산지
    pl_img1 varchar(50) not null,	-- 상품이미지1
    pl_img2 varchar(50),			-- 상품이미지2
    pl_img3 varchar(50),			-- 상품이미지3
    pl_desc varchar(50),			-- 설명이미지
    pl_stock int default -1,		-- 재고
    pl_isview char(1) default 'N'	-- 게시여부
);

create table t_orderlist(
	ol_id varchar(20) primary key,		-- 주소id
    ml_id varchar(20),					-- 회원id
    ol_rname varchar(50) not null,		-- 수취인명
    ol_rphone varchar(13) not null,		-- 수취인전화번호
    ol_rzip char(5) not null, 			-- 배송지 우편번호
    ol_radd1 varchar(50) not null,		-- 배송지 주소1
    ol_radd2 varchar(50) not null,		-- 배송지 주소2
    ol_payment char(1) default 'a',		-- 결제방식
    ol_payt int default '0',			-- 결제액
    ol_comment varchar(100),			-- 요구사항
    ol_status char(1) default 'a',		-- 주문상태
    ol_date datetime default now(),		-- 주문일
    constraint fk_t_order_ml_id foreign key(ml_id) references t_memberlist(ml_id)
);

create table t_orderdetail(
	od_id int unsigned auto_increment primary key,		-- 주문상세id
    ol_id varchar(20),									-- 주문id
    pl_id varchar(20),									-- 상품id
    od_cnt int default 1,								-- 상품개수
    od_img varchar(50) not null,						-- 상품 이미지
    od_price int default 0,								-- 상품 단가
    od_name varchar(50) not null,						-- 상품명
    constraint fk_t_order_ol_id foreign key(ol_id) references t_orderlist(ol_id) on delete cascade,
    constraint fk_t_order_pl_id foreign key(pl_id) references t_productlist(pl_id) on delete cascade
);
