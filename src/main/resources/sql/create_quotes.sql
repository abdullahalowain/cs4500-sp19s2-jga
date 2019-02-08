create table quotes (
   id integer not null auto_increment,
   job_description varchar(255),
   job_title varchar(255),
   price double precision,
   primary key (id)
) engine=InnoDB