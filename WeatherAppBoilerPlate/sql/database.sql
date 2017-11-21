
create table city (
	uid varchar(36) not null,
	city_name varchar(255) not null,  
	city_id bigint,
	primary key (uid)
);
	
create table weather (
	uid varchar(36) not null,
	pressure double  not null,
	humidity double  not null,
	speed double  not null,
	max_temp double  not null,
	min_temp double  not null,
	percent_cloud double not null,
	date datetime,
	description varchar(255),
	icon varchar(255),
	city_uid varchar(36),
	primary key (uid)
);	

alter table weather 
    add constraint FK_spbcnq0v3grt5u4f1nw0l7g2o 
    foreign key (city_uid) 
    references city (uid);
