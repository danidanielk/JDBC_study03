--어떤 특정한 식당에 대한 테이블
--식당 지점 (체인점 지역), 식당주인, 좌석수

--예약 테이블
-- 예약자 이름,예약 시간, 예약자 전화번호,예약 지점

select * from reservation; 
select * from restaurant; 

create table restaurant (
r_name varchar2(30 char) default 'i have a dream' not null,
r_location varchar2(30 char) primary key,
r_oner varchar2(30 char) not null,
r_seat number(5) not null
);

select * from STORE;

insert into restaurant values(default,'moran','dani',500);
insert into restaurant values(default,'gangnam','dani',500);
insert into restaurant values(default,'seoul','dani',500);
select rr_no,rr_name,rr_phone from reservation where rr_name = 'dani' ;

create table reservation (
rr_no number(3) primary key,
rr_name varchar2(30 char) not null,
rr_date date not null,
rr_phone number(30) not null,
rr_location varchar2(30 char)not null
);
select * from reservation where rr_name = 'danidani';
create sequence reservation_seq;

insert into reservation values(reservation_seq.nextval,'soyeon',to_date('20220906','YYYYMMDD'),01012345678,'moran');
insert into reservation values(reservation_seq.nextval,'seni',to_date('20220809','YYYYMMDD'),01025546352,'gangnam');
insert into reservation values(reservation_seq.nextval,'yoseb',to_date('20220601','YYYYMMDD'),01041177173,'seoul');
insert into reservation values(reservation_seq.nextval,'fish',to_date('202210101820','YYYYMMDD_HH24:MI:SS'),01022222222,'heaven');