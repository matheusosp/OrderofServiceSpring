create table OrderofService (
	id bigint not null auto_increment,
    cliente_id bigint not null,
    description text not null,
    price decimal (10,2)not null,
    status varchar (20) not null,
    data_opening datetime not null, 
    data_finalization datetime,
    
    primary key(id)
);
alter table OrderofService add constraint fk_OrderofService
foreign key (cliente_id) references cliente (id);