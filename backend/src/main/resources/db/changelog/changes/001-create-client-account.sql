--liquibase formatted sql

--changeset Frolov:1
CREATE TABLE client_account (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    gender VARCHAR(1),
    status VARCHAR(20) DEFAULT 'ACTIVE',
    create_dttm TIMESTAMP WITH TIME ZONE NOT NULL,
    modify_dttm TIMESTAMP WITH TIME ZONE NOT NULL
);

--rollback DROP TABLE client_account;