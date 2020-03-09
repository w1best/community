create table comment
(
	id bigint auto_increment primary key,
	parent_id bigint,
	type int,
	commentator bigint,
	gmt_create bigint,
	gmt_modified bigint,
	content varchar2(1024)
);

