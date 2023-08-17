CREATE TABLE calculations (
   id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())),
   first_number int NOT NULL,
   second_number int NOT NULL,
   operation varchar(255) NOT NULL,
   result int NOT NULL,
   notes varchar(255)
);

ALTER TABLE calculations ADD PRIMARY KEY(id);