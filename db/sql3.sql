use world;

select * from city;
select name, district from city;
-- 네덜란드에 속한 도시이름을 검색하라.
select name from city
where CountryCode = 'NLD';
-- 도시명에 'b'가 들어가는 한국 도시명을 검색하라

select name from city
where CountryCode = 'KOR' and name like '%b%'; 

select * from city 
where population >= 500000 and population <= 1000000;

-- population이 70만 이상 100만 이하인 도시들 중 한국과 미국 도시를 출력
select name, countrycode, population from city
where population >= 700000 and population <= 1000000 and (CountryCode = 'KOR' or CountryCode = 'USA');

-- population이 100만 이상인 한국, 미국, 중국의 도시를 출력
select name, Countrycode from city
where population >= 1000000 and CountryCode in ('KOR', 'USA', 'CHN');

-- 나라별로 도시의 개수를 구하여 출력
select countrycode, count(countrycode) cnt, avg(Population) pop
from city
group by countrycode
having avg(population)>=500000;

select * from country;
select code, name, gnp, GNPOld, GNP + GNPOld hap
from country;

create table city2 (
	cid int auto_increment primary key,
    cname varchar(50) Not null,
    country char(3) not null,
    district varchar(20) not null
);

insert into city2 (cid, cname, country, district)
	select id, name, countrycode, district from city
    where Population >= 500000;
    
 create table city3 (select id, name, countrycode, district from city
    where Population >= 500000);
    
-- city를 이용하여 나라코드의 오름차순으로 정렬하되 같은 나라안에서는 district를 이용하여 정렬한 후 출력 : 나라는 한국, 미국, 네덜란드
select * from city
where CountryCode in ('KOR', 'USA', 'NLD')
order by countrycode asc, district desc;

select if(20<30,'참입니다','거짓입니다');

-- country에서 gnp가 gnpold보다 낮으면 '개발실패국가', 높으면 '개발성공국가'라고 출력하시오.
-- code, name, gnp, gnpold  등과 같이 출력 

select code, name, gnp, gnpold, if(gnp<gnpold, '개발실패국가', '개발성공국가') '개발성공여부'
from country;

 -- 위와 동일한 조건으로 개발실패와 성공 국가의 개수를 출격
 
 select if(gnp<gnpold, '개발실패국가', '개발성공국가') isSuccess, count(if(gnp<gnpold, '개발실패국가', '개발성공국가')) numOfSuccess
 from country
 group by isSuccess;
 
 select ifnull(gnpold, '널') from country;
 select nullif(100, 100), nullif(100, 200);
 select case 10 when 5 then '오' when 10 then '십' else '몰라' end;
 select ascii('a');
 select char(97);
 select char_length('abcd가나다라');
 select length('abcd가나다라');
 select concat('abc' , 'def');
 select concat_ws('/', '2020', '01', '01');
 select elt(2, 'aa', 'bb', 'cc', 'dd');
 select field('ff', 'aa','bb','cc','dd','ee','ff');
 select find_in_set('ff', 'aa,cc,ff,zz');
 select instr('abcdefg','def');
 select locate('def','abcdef');
 select format(3.141592, 3);
 select bin(31), hex(31), oct(31);
 select insert('abcdefghij', 3, 4, '@@');
 select left('abcdefghij', 4);
 select right('abcdefghij', 4);
 select mid('abcdefghij', 4,3);
 select lcase('abCD가나');
 select ucase('abCD가나');
 select lpad('abcd', 7, '#');
 select rpad('abcd', 7, '#');
 select ltrim('     ab    cd    ');
 select rtrim('     ab    cd    ');
 select repeat('abc', 3); 
 select replace('abcdef', 'cd', 'zz');
 select reverse('abcd');
 select concat('::', space(5), '::');
 select substring_index('cafe.naver.com','.',-2);