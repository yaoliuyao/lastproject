-- 创建数据库
create database  bookShop
go

use bookShop;

-- 创建管理员表
create table book_admin
 (
    [uid] int identity ,	 -- '主键ID'
    [user] varchar(32) not null,		 --'管理员账号',
    [password] varchar(16) not null,	 --'管理员密码',
	state int default 1 not null,			--状态，1 表示正常，0 表示删除
    createtimei datetime default getdate() not null,-- '创建时间'
    primary key (uid),
	unique([user])
);

-- 用户表
create table  book_user
 (
	userno int identity, --'主键id'
    username varchar(100) not null,  --'用户名'
    userpass varchar(16) not null, -- '用户密码',
	phone varchar(13) not null,		--手机号，唯一
	state int default 1 not null,			--状态，1 表示正常，0 表示删除
    createtime datetime default getdate() not null, --'创建时间'
    primary key (userno),

    unique (phone),
);

-- 会员详细信息
create table book_member
 (
    profileNo int identity,			-- '主键id'
	userNo int,						--'外键，用户编号'
	phone varchar(13) not null,
	name varchar(100) not null,		--'姓名'
	sex char(2) not null,			--	'性别',
	birthday date not null,			--'生日'
	grade int default 1 not null ,	--'等级 默认 lv1 级’
	state int default 1 not null,			--状态，1 表示正常，0 表示删除
    createtime datetime default getDate() -- '创建时间',
    primary key (profileNo),
   foreign key (userNO) references book_user(userNO),
)
-- 书籍地区表
create table book_region
(
	rid int identity primary key,	--编号
	region varchar(100) not null,	--地区
	created datetime default getdate()	--创建时间
);
-- 书籍类型表
create table book_type
(
    typeNo int identity,			 --'主键id',
    name varchar(32) not null,		-- '类型名称',
    createtime datetime default getDate() not null -- '创建时间',
    primary key (typeNO)
) 
-- 书籍商品表
create table book_commodity
(
    productNo int identity,			--'编号id'
    typeNo int,						--'分类id',
	rid int,						--地区编号id
    bookName varchar(200) not null,	-- '图书名称',
	author varchar(100) not null,	--'作者'
    price money not null,			--'销售价格'
	buyCount int,					-- '销售数量'
	stock int not null,				-- '库存',
    cover varchar(200) not null	,	 --'封面图',
	content varchar(2000),			--'图书简介'
	state int default 2 not null,			--状态，1 表示上架，2 表示下架 0 表示删除
    createtime datetime default getdate() --'创建时间',
   
    PRIMARY KEY (productNO),
    foreign key (typeNO) references book_type(typeNo),
	 foreign key (rid) references book_region(rid),
) 
update book_user 
set username='tom',userpass ='123456'

--测试数据

insert into book_admin([user], password) values('admin', '123456');

insert into book_user(username,userpass,phone) values('tom','123456','110');
insert into book_user(username,userpass,phone) values('jok','123456','120');

insert into book_member(userNO,phone,name,sex,birthday,grade) values(1,'110','张三','男','2020-01-01',1);

insert into book_region(region) values('大陆')
insert into book_region(region) values('韩国')

insert into book_type(name) values('励志');
insert into book_type(name) values('历史');

insert into book_commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content)
values(1,1,'学习高手','李拓远',23,100,200,'/img/a.jpg','如何记忆，才能牢固掌握知识点？ 如何复习，才能夯实完整知识体系？如何自学，才能实现终身跨界成长？这些问题，《学习高手》里都有答案。本书是一本写给广大学生和家长的，培养高效学习能力的方法工具书。作者作为哈佛、耶鲁高分毕业生，结合先进的理论知识、经典的学习经验，系统分享了超实用的学习法。全书分为5大模块、30节大课、100+方法，帮助你提高学习成绩，打开人生格局。');

insert into book_commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content)
values(2,1,'决战朝鲜','李峰',19,100,200,'/img/b.jpg','本书是一部全景式再现朝鲜战争历史命运的经典作品，以恢宏的气势、凝练的语言、多维度的视角记述和分析了朝鲜战争成因、决策过程、五次战役及板门店停战谈判等重大事件，包括战前国际国内形势、重要战役战况、双方将帅决策过程及这场战争中涌现的堪称“军神”级人物，塑造了一大批性格鲜明的人物形象。同时，本书通过翔实的史料全面揭开朝鲜战争台前幕后的诸多历史真相，如中美苏朝最高领导层的博弈较量，朝鲜人民军南征的真相，中国出兵朝鲜真相，中美军战力真实对比，苏联对华军援、空军参战的内幕，志愿军战俘的真实境遇，板门店谈判过程等等，破除了有关朝鲜战争的种种迷思与误解，非常真实出彩')

update book_type set region ='大陆' 

select * from book_admin
select * from book_user 

select typeNo  from book_type
group by typeNo
select * from book_type 
left join book_commodity on book_type.typeNo= book_commodity.typeNo


 select book_commodity.state from book_commodity
 left join book_type on book_type.typeNo= book_commodity.typeNo
 join book_region on book_commodity.rid = book_region.rid
 	 order by book_type.typeNo
                offset 0 rows
                fetch next 5 rows only 


--购物车表
create table book_cart
(
	cartNo int identity,	-- 购物车id
	productNo int,			-- 商品id(书籍编号)
	userNo int,				-- 用户id
	booknum int not null default 0,	--加入购物车的商品数量
	cPrice money not null default 0.00,	--加入购物车时的价格
	created date not null default getdate(),	--创建时间
	
	primary key (cartNo),
    foreign key (productNo) references book_commodity(productNo),
	foreign key (userNo) references book_user(userNo),
)
	insert into book_cart(productNo,userNo,booknum,cPrice) values(1,1,2,23)
--用户收货地址表
create table user_address
(
	addressNo int identity,		--地址编号
	userNo int,					--用户 id
	consignee varchar(100)not null, --收货人
	detail_address varchar(300)not null, --收货详细地址
	tel varchar(11) not null,		--收货人手机号
	created datetime not null default getdate(),

	primary key (addressNo),
	foreign key (userNo) references book_user(userNo),

);

insert into user_address(userno,consignee,detail_address,tel) values(1,'admin','广东省珠海市斗门区白蕉镇南方IT学院',110);

--订单表
create table book_order
(
	orderNo int identity,	--订单编号
	userNo int,				--用户编号
	productNo int,			--书籍商品编号
	addressNo int,			--收货地址编号
	payment_number int not null,	--支付方式 ,1 微信，2 支付宝
	productnum int not null,		--书籍商品数量
	amount money default 0,		--订单总价
	status int not null,		--订单状态 0取消付款，1待发货，2待收货，3已完成
	remarks varchar(1000),		--订单备注
	createTime datetime default getdate() --创建时间	

	primary key (orderNo),
    foreign key (productNo) references book_commodity(productNo),
	foreign key (userNo) references book_user(userNo),
    foreign key (addressNo) references user_address(addressNo),
)

insert into book_order(userno,productNo,addressNo,payment_number,productnum,amount,status)
values(1,1,1,1,1,23,1);
select * from book_order
select * from user_address