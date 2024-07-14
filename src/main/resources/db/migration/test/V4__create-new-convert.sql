CREATE TABLE tb_new_convert(
    cpf VARCHAR(11) PRIMARY KEY NOT NULL,
    FOREIGN KEY (cpf) REFERENCES tb_person(cpf)
);