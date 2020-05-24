
## 支付表
drop table payment if exites;
create table payment(
	id bigint(20) not null auto_increment comment 'id',
	serial varchar(200) default '',
	primary key(id)
)engine=innoDB auto_increment=1 default CHARSET=utf8;