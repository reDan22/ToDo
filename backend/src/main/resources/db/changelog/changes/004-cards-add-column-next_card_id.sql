--liquibase formatted sql

--changeset Frolov:4
ALTER TABLE cards ADD COLUMN next_card_id BIGINT;
ALTER TABLE cards ADD CONSTRAINT fk_next_card FOREIGN KEY (next_card_id) REFERENCES cards(id);

--rollback ALTER TABLE cards DROP CONSTRAINT fk_next_card;
--rollback ALTER TABLE cards DROP COLUMN next_card_id;