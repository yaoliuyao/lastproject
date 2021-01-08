create table user_table(
id varchar(100),
username varchar(100),
[password] varchar(100),
)



CREATE TABLE userInfo (
	id varchar(1000) not null, ---id
	username varchar(20) primary key not null,  ---�ǳ�
	[password] varchar(20) not null, ---����
	sex char(2) check(sex = '��' or sex ='Ů') default('��') not null, ---�Ա�
	face varchar(200), ---ͷ��
	regTime datetime default getdate(), ---ע��ʱ��
	email varchar(100) not null, ---����
	mobile varchar(100) not null, ---��ϵ�绰
);
CREATE TABLE articleInfo (
	aid int primary key identity(1000,1) not null, ---id
	username varchar(20) foreign key references userInfo([username]),---�û��ǳ�
	topic varchar(300) not null, ---����
	face varchar(200) not null,  ---ͼƬ
	contents varchar(200) not null, ---����
	[time] datetime default getdate(), ---ʱ��
	[like] int,---ϲ��
);
CREATE TABLE commentsInfo (
	cid int primary key identity(1000,1) not null,
	ctime datetime default getdate(),
	aid int foreign key references articleInfo(aid),
	username varchar(20) foreign key references userInfo([username]),
	content varchar (100),
	likes int
);
create table collent(
	id int identity(1000,1),
	username varchar(20) foreign key references userInfo(username),
	aid int foreign key references articleInfo(aid),
	collenttime date default getdate()
)


drop table userInfo
drop table commentsInfo
drop table articleInfo
drop table user_table
