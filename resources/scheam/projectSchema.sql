--유저 생성
create user c##team identified by team;
grant connect, resource, dba to c##team;
conn c##team/team;

--drop table BOARDDTO;
create table BOARDDTO(
	board_no int primary key, --글번호
	title varchar2(30) not null, --제목
	content varchar2(100) not null,--내용
    writer varchar2(20) not null,--작성자
    uuid int references USERDTO(uuid),--유저 아이디
    subject varchar2(10),
    tag varchar2(10),--게시판 분류
    like_cnt int,--좋아요 수
    view_cnt int,--조회수
	board_date date not null,--등록일
    is_solved char(1), --질문게시판 해결 여부
    selected_reply int unique
); 

ALTER TABLE BOARDDTO ADD foreign KEY(selected_reply) references REPLY (selected_reply);

--DROP sequence board_seq;
create sequence board_seq nocache; 
--공지 notice 
insert into BOARDDTO values (board_seq.nextval, '수업시작시간','수업은 9시에 시작됩니다. 지각하지 마세요', '희정샘', 23, 'notice','#중요', 2, 2, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '시험공지','다음주 시험이 있습니다. 내용은 오픈북입니다.', '희정샘', 23, 'notice','#긴급', 0, 6, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '휴강공지','4월 21일 휴강 예정입니다.', '이프로', 24, 'notice','#휴강', 12, 6, sysdate,null,null);

--자유 free
insert into BOARDDTO values (board_seq.nextval, '신난다','팀프로젝트하기 신남', '지수', 20, 'free','#신남', 0, 1, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '날씨','날씨 너무 좋다. 나가서 놀고 싶다', '재현', 19, 'free','#벚꽃', 1, 1, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '축구','하고 싶다', '주호',21, 'free','#축구', 3, 3, sysdate,null,null);

--질문 question
insert into BOARDDTO values (board_seq.nextval, '질문있습니다.','자바 너무 어려워요', '지수', 20, 'question','#자바', 1, 1, sysdate,'N',null);
insert into BOARDDTO values (board_seq.nextval, '질문','지각하면 어떻게 되나요?', '지수', 20, 'question','#질문', 0, 1, sysdate,'N',null);

select * from BOARDDTO;

--DROP TABLE REPLY cascade constraints;
create table REPLY(
  reply_no int primary key, --댓글번호
  reply_writer varchar2(20) not null, --댓글작성자
  reply_content varchar2(100) not null, --댓글내용
  board_no int references BOARDDTO(board_no), --댓글을 달 부모글번호
  reply_date date, --등록일
  selected_reply int unique
);

--drop sequence reply_seq;
create sequence reply_seq nocache; 

insert into REPLY values (reply_seq.nextval, '재현','그러게', 37, sysdate,null);
insert into REPLY values (reply_seq.nextval, '원우','나두', 37, sysdate,null);
insert into REPLY values (reply_seq.nextval, '지수','나가자!', 37, sysdate,null);
--질문게시판
insert into REPLY values (reply_seq.nextval, '이프로','3번 지각하면 1번 결석이 됩니다.', 39, sysdate,null);

select * from REPLY;

--drop table USERDTO;
create table USERDTO(
	uuid int primary key, --유저 고유번호
	user_id varchar2(20) not null unique, --로그인 아이디
	pass_word varchar2(20) not null,--로그인 패스워드
    nick_name varchar2(20) not null,--닉네임
    is_admin CHAR(1), --관리자 여부
    is_banned CHAR(1)
); 
--DROP sequence uuid_seq;
create sequence uuid_seq nocache; 
--일반 유저
insert into USERDTO values (uuid_seq.nextval, 'abcd','!1234','재현', 'N', 'N');
insert into USERDTO values (uuid_seq.nextval, 'hi','abde1','지수', 'N', 'Y');
insert into USERDTO values (uuid_seq.nextval, 'ho','764pass','주호', 'N', 'N');
insert into USERDTO values (uuid_seq.nextval, 'system','pass123','원우','N', 'N');

--관리자 
insert into USERDTO values (uuid_seq.nextval, 'ssam','scott','희정샘', 'Y', null);
insert into USERDTO values (uuid_seq.nextval, 'pro','tiger','이프로', 'Y', null);

select * from USERDTO;
