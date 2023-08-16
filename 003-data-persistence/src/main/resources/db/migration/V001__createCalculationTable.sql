CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE calculations (
    id uuid DEFAULT uuid_generate_v4(),
    first_number INTEGER NOT NULL,
    second_number INTEGER NOT NULL,
    operation VARCHAR NOT NULL,
    PRIMARY KEY (id)
);