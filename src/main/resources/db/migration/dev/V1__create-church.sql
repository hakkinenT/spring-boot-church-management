CREATE TABLE tb_church(
    cnpj VARCHAR(14) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mother_church_cnpj VARCHAR(14),
    FOREIGN KEY (mother_church_cnpj) REFERENCES tb_church(cnpj)
);