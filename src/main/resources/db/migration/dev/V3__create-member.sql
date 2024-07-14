CREATE TABLE tb_member(
    cpf VARCHAR(11) PRIMARY KEY NOT NULL,
    baptism_date DATE NOT NULL,
    FOREIGN KEY (cpf) REFERENCES tb_person(cpf)
);