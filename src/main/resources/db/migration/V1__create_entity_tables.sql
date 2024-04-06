CREATE TABLE user_entity
(
    id                             UUID PRIMARY KEY,
    username                       VARCHAR(255) UNIQUE,
    phone_number                   VARCHAR(255) UNIQUE,
    email                          VARCHAR(255) UNIQUE,
    preferred_notification_channel VARCHAR(255)
);

CREATE TABLE balance_entity
(
    id          UUID PRIMARY KEY,
    amount      DECIMAL(19, 4),
    balance_id  VARCHAR(255) UNIQUE,
    user_entity UUID,
    FOREIGN KEY (user_entity) REFERENCES user_entity (id)
);

CREATE TABLE user_credentials
(
    id           UUID PRIMARY KEY,
    username     VARCHAR(255) UNIQUE,
    password     VARCHAR(255),
    user_entity_id UUID
);

CREATE TABLE transaction_entity
(
    id              UUID PRIMARY KEY,
    sender          VARCHAR(255),
    recipient       VARCHAR(255),
    amount          DECIMAL(19, 4),
    transaction_time TIMESTAMP
);
