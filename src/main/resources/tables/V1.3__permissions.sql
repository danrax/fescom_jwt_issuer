create table if not exists permissions(
    permission_id   int PRIMARY KEY NOT NULL,
    title           TEXT NOT NULL,
    description     TEXT,
    status          VARCHAR(10) NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP NOT NULL DEFAULT now()
);