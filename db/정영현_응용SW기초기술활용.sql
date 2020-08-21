use test;

create table t_studentdata(			-- 학생정보 테이블
	stuid varchar(20) primary key,	-- 학번 몇자린지 몰라서 varchar로 설정
	name varchar(50) not null,		-- 이름
    birth char(10) not null,		-- 생년월일(yyyy-mm-dd)
    phone varchar(13) not null,		-- 전화번호 (000-0000-0000)
    zip char(5) not null, 			-- 우편번호
    addr1 varchar(50) not null,		-- 주소1
    addr2 varchar(50) not null,		-- 주소2
    email varchar(50) not null		-- 이메일
);

create table t_subject(				-- 과목정보 테이블
	subid varchar(20) primary key,	-- 과목id
    subname varchar(50) not null, 	-- 과목이름
    subprof varchar(50) not null	-- 담당교수명
);

create table t_testscore(				-- 시험점수 테이블
	testid varchar(20) primary key,		-- 일렬번호
    stuid varchar(20),					-- 학번
    subid varchar(20),					-- 과목id
    score int default 0,				-- 점수
    testdate datetime default now(),	-- 시험일
    constraint fk_t_test_stuid foreign key(stuid) references t_studentdata(stuid),
    constraint fk_t_test_subid foreign key(subid) references t_subject(subid)
);