--���� ����
create user c##team identified by team;
grant connect, resource, dba to c##team;
conn c##team/team;

--drop table BOARDDTO;
create table BOARDDTO(
	board_no int primary key, --�۹�ȣ
	title varchar2(30) not null, --����
	content varchar2(100) not null,--����
    writer varchar2(20) not null,--�ۼ���
    uuid int references USERDTO(uuid),--���� ���̵�
    subject varchar2(10),
    tag varchar2(10),--�Խ��� �з�
    like_cnt int,--���ƿ� ��
    view_cnt int,--��ȸ��
	board_date date not null,--�����
    is_solved char(1), --�����Խ��� �ذ� ����
    selected_reply int unique
); 

ALTER TABLE BOARDDTO ADD foreign KEY(selected_reply) references REPLY (selected_reply);

--DROP sequence board_seq;
create sequence board_seq nocache; 
--���� notice 
insert into BOARDDTO values (board_seq.nextval, '�������۽ð�','������ 9�ÿ� ���۵˴ϴ�. �������� ������', '������', 11, 'notice','#�߿�', 2, 2, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '�������','������ ������ �ֽ��ϴ�. ������ ���º��Դϴ�.', '������', 11, 'notice','#���', 0, 6, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '�ް�����','4�� 21�� �ް� �����Դϴ�.', '������', 6, 'notice','#�ް�', 12, 6, sysdate,null,null);

--���� free
insert into BOARDDTO values (board_seq.nextval, '�ų���','��������Ʈ�ϱ� �ų�', '����', 8, 'free','#�ų�', 0, 1, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '����','���� �ʹ� ����. ������ ��� �ʹ�', '����', 7, 'free','#����', 1, 1, sysdate,null,null);
insert into BOARDDTO values (board_seq.nextval, '�౸','�ϰ� �ʹ�', '��ȣ', 9, 'free','#�౸', 3, 3, sysdate,null,null);

--���� question
insert into BOARDDTO values (board_seq.nextval, '�����ֽ��ϴ�.','�ڹ� �ʹ� �������', '����', 8, 'question','#�ڹ�', 1, 1, sysdate,'N',null);
insert into BOARDDTO values (board_seq.nextval, '����','�����ϸ� ��� �ǳ���?', '����', 8, 'question','#����', 0, 1, sysdate,'N',null);

select * from BOARDDTO;

--DROP TABLE REPLY;
create table REPLY(
  reply_no int primary key, --��۹�ȣ
  reply_writer varchar2(20) not null, --����ۼ���
  reply_content varchar2(100) not null, --��۳���
  board_no int references BOARDDTO(board_no), --����� �� �θ�۹�ȣ
  reply_date date, --�����
  selected_reply int unique
);

--drop sequence reply_seq;
create sequence reply_seq nocache; 

insert into REPLY values (reply_seq.nextval, '����','�׷���', 21, sysdate,null);
insert into REPLY values (reply_seq.nextval, '����','����', 21, sysdate,null);
insert into REPLY values (reply_seq.nextval, '����','������!', 21, sysdate,null);
--�����Խ���
insert into REPLY values (reply_seq.nextval, '������','3�� �����ϸ� 1�� �Ἦ�� �˴ϴ�.', 23, sysdate,null);

select * from REPLY;

--drop table USERDTO;
create table USERDTO(
	uuid int primary key, --���� ������ȣ
	userid varchar2(20) not null unique, --�α��� ���̵�
	password varchar2(20) not null,--�α��� �н�����
    nickname varchar2(20) not null,--�г���
    is_admin CHAR(1), --������ ����
    is_banned CHAR(1),
    read_notice_cnt int
); 
--DROP sequence uuid_seq;
create sequence uuid_seq nocache; 
--�Ϲ� ����
insert into USERDTO values (uuid_seq.nextval, 'abcd','!1234','����', 'N', 'N', 1);
insert into USERDTO values (uuid_seq.nextval, 'hi','abde1','����', 'N', 'Y', 3);
insert into USERDTO values (uuid_seq.nextval, 'ho','764pass','��ȣ', 'N', 'N', 5);
insert into USERDTO values (uuid_seq.nextval, 'system','pass123','����','N', 'N', 6);

--������ 
insert into USERDTO values (uuid_seq.nextval, 'ssam','scott','������', 'Y', null, null);
insert into USERDTO values (uuid_seq.nextval, 'pro','tiger','������', 'Y', null, null);

select * from USERDTO;
