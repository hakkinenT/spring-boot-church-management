CREATE TABLE tb_person(
    cpf VARCHAR(11) PRIMARY KEY NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(255),
    marital_status VARCHAR(255) NOT NULL,
    conversion_date DATE NOT NULL
);