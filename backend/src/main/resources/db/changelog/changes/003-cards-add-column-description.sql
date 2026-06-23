--liquibase formatted sql

--changeset Frolov:3
ALTER TABLE cards ADD COLUMN description TEXT;

--rollback ALTER TABLE cards DROP COLUMN description;