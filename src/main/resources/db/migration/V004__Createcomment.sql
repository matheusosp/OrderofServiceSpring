create table comment(
	id bigint not null auto_increment,
	order_service_id bigint not null,
	description text not null,
	data_send datetime not null,
	
	primary key (id)
);

alter table comment add constraint fk_comment_order_service
foreign key (order_service_id) references orderofservice(id);