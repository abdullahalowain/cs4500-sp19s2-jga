create table reviews (
   id integer not null auto_increment,
    review varchar(255),
    title varchar(255),
    reviewed_id integer,
    reviewer_id integer,
    primary key (id),
    constraint FKmwj3nbuwfldy5lxcfabn8plra foreign key (reviewed_id) references user (id),
    constraint FKffgcihxpbrcpcq58t9sev9i4  foreign key (reviewer_id) references user (id)
) engine=InnoDB