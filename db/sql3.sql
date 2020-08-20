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
    
select * from city2;
