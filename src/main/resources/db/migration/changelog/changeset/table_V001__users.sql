CREATE TABLE users (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE ,
    username VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(64) not null unique,
    role VARCHAR(50) not null ,
    is_banned boolean DEFAULT FALSE not null,
    created_at TIMESTAMPTZ DEFAULT current_timestamp,
    updated_at TIMESTAMPTZ DEFAULT current_timestamp
);

CREATE TABLE cards(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE ,
    cardNumber VARCHAR(50),
    expiration TIMESTAMPTZ DEFAULT current_timestamp,
    owner_id BIGINT,
    status VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    deleted boolean DEFAULT FALSE NOT NULL,
    balance DECIMAL(19,2) NOT NULL,

    CONSTRAINT fk_card_user FOREIGN KEY (owner_id) REFERENCES users(id)
);

CREATE TABLE transfers(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE ,
    from_card_id BIGINT,
    to_card_id BIGINT,
    amount DECIMAL(19,2) NOT NULL,
    status VARCHAR(50) not null ,
    created_at TIMESTAMPTZ DEFAULT current_timestamp,
    updated_at TIMESTAMPTZ DEFAULT current_timestamp,

    CONSTRAINT fk_transfer_for_card FOREIGN KEY (from_card_id) REFERENCES cards(id),
    CONSTRAINT fk_transfer_to_card FOREIGN KEY (to_card_id) REFERENCES cards(id)
);

CREATE TABLE tokens(
    username VARCHAR(255),
    refresh_token VARCHAR(255) NOT NULL UNIQUE
)

