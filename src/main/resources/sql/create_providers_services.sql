    create table providers_services (
       service_id integer not null,
        user_id integer not null
    ) engine=InnoDB
    alter table providers_services 
       add constraint FKo5uq88uuxkuc2m1a7ht9f3pi3 
       foreign key (user_id) 
       references user (id)
    alter table providers_services 
       add constraint FKgjeyr2o4fvhpebjcntw4jr68l 
       foreign key (service_id) 
       references services (id)
