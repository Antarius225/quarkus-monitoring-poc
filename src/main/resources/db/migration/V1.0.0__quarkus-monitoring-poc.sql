
    create sequence ApplicationType_SEQ start with 1 increment by 50;

    create sequence Monitoring_SEQ start with 1 increment by 50;

    create table ApplicationType (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table Monitoring (
        application_id bigint,
        id bigint not null,
        timestamp timestamp(6),
        message varchar(255),
        status varchar(255) check (status in ('UP','DOWN','UNKNOWN')),
        primary key (id)
    );

    alter table if exists Monitoring 
       add constraint FKco3vxtunqnrkcmvhtbk0kmvas 
       foreign key (application_id) 
       references ApplicationType;
INSERT INTO ApplicationType (id, name) VALUES (1, 'ZSmart');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('DOWN', 1, 1, '2024-01-01 00:00:00', 'Everything is bad');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('UP', 1, 2, '2024-01-01 00:00:05', 'Everything is fine');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('UP', 1, 3, '2024-01-01 00:00:10', 'Everything is fine');
INSERT INTO monitoring (status, application_id, id, timestamp, message) VALUES ('DOWN', 1, 4, '2024-01-01 00:00:15', 'Everything is bad');
SELECT setval('monitoring_seq', (SELECT MAX(id) FROM monitoring)+1);
