create table if not exists users(
    user_id     int  UNIQUE PRIMARY KEY NOT NULL,
    name        VARCHAR(70),
    last_name   VARCHAR(50) NOT NULL,
    email       VARCHAR(50) NOT NULL,
    password    VARCHAR (40) NOT NULL,
    role_id     int NOT NULL,
    status      VARCHAR(10) NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP NOT NULL DEFAULT now()
    -- FOREIGN KEY (role_id) REFERENCES roles(role_id)
);