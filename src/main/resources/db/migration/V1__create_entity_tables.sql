CREATE TABLE user_entity
(
    id                           UUID PRIMARY KEY,
    username                     VARCHAR(255),
    password                     VARCHAR(255),
    phone_number                  VARCHAR(255),
    email                        VARCHAR(255),
    preferred_notification_channel VARCHAR(255)
);

CREATE TABLE balance_entity
(
    id         UUID PRIMARY KEY,
    amount     DECIMAL(19, 4),
    balance_id  VARCHAR(255),
    user_entity UUID,
    FOREIGN KEY (user_entity) REFERENCES user_entity (id)
);
