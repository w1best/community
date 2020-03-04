create table comment
(
	id bigint auto_increment primary key,
	parent_id bigint,
	type int,
	commentator int,
	gmt_create bigint,
	gmt_modified bigint,
	message text
);
comment on column comment.id is '主键';
comment on column comment.parent_id is '父评论id';
comment on column comment.type is '父类型';
comment on column comment.commentator is '评论人id';
comment on column comment.gmt_create is '创建时间';
comment on column comment.gmt_modified is '修改时间';
comment on column comment.message is '评论内容';

