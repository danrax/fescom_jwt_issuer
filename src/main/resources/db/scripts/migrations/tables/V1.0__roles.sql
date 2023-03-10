CREATE TABLE IF NOT EXISTS roles(
    role_id     int UNIQUE PRIMARY KEY NOT NULL,
    title       VARCHAR(70),
    description VARCHAR(50) NOT NULL,
    status      VARCHAR(10) NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP NOT NULL DEFAULT now()
);