--liquibase formatted sql

--changeset Frolov:2
CREATE TABLE cards (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES client_account(id),
    create_dttm TIMESTAMP WITH TIME ZONE NOT NULL,
    modify_dttm TIMESTAMP WITH TIME ZONE NOT NULL
);

--rollback DROP TABLE cards;