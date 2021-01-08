create table user_table(
id varchar(100),
username varchar(100),
[password] varchar(100),
)



CREATE TABLE userInfo (
	id varchar(1000) not null, ---id
	username varchar(20) primary key not null,  ---昵称
	[password] varchar(20) not null, ---密码
	sex char(2) check(sex = '男' or sex ='女') default('男') not null, ---性别
	face varchar(200), ---头像
	regTime datetime default getdate(), ---注册时间
	email varchar(100) not null, ---邮箱
	mobile varchar(100) not null, ---联系电话
);
CREATE TABLE articleInfo (
	aid int primary key identity(1000,1) not null, ---id
	username varchar(20) foreign key references userInfo([username]),---用户昵称
	topic varchar(300) not null, ---标题
	face varchar(200) not null,  ---图片
	contents varchar(200) not null, ---内容
	[time] datetime default getdate(), ---时间
	[like] int,---喜欢
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
