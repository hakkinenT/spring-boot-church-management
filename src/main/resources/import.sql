INSERT INTO tb_church (cnpj, name, email, mother_church_cnpj) VALUES ('66776441000198', 'Igreja Batista do Centenário', 'ibc@gmail.com', null);
INSERT INTO tb_church (cnpj, name, email, mother_church_cnpj) VALUES ('19474133000128', 'Congregação Batista de Santa Rosa de Lima', 'csrl@gmail.com', '66776441000198');
INSERT INTO tb_church (cnpj, name, email, mother_church_cnpj) VALUES ('66764546000127', 'Congregação Batista de Divina Pastora', 'cdp@gmail.com', '66776441000198');
INSERT INTO tb_church (cnpj, name, email, mother_church_cnpj) VALUES ('46651775000128', 'Congregação Batista do Roque Mendes', 'crm@gmail.com', '66776441000198');

INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('79686175024', 'José Maria', 'Santos', '1965-08-12', 'jose@gmail.com', 'Viúvo', '1960-01-23');
INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('81965210066', 'Maria Claúdia', 'Santos Silva', '1975-09-22', 'maria@gmail.com', 'Divorciada', '1990-05-13');
INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('39661842060', 'Francisca', 'Almeida', '1970-12-15', 'francisca@gmail.com', 'Casada', '1998-09-23');
INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('97095967059', 'Juliano', 'Batista', '1983-06-19', 'juliano@gmail.com', 'Solteiro', '2024-11-09');
INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('68512249099', 'Caroline', 'Cardoso', '1991-03-28', 'caroline@gmail.com', 'Casada', '2024-11-09');
INSERT INTO tb_person (cpf, first_name, last_name, birth_date, email, marital_status, conversion_date) VALUES ('36686759023', 'Nívea', 'Santos', '1955-11-22', 'nivea@gmail.com', 'Solteira', '2024-12-23');

INSERT INTO tb_new_convert (cpf) VALUES ('97095967059');
INSERT INTO tb_new_convert (cpf) VALUES ('68512249099');
INSERT INTO tb_new_convert (cpf) VALUES ('36686759023');

INSERT INTO tb_member (cpf, baptism_date) VALUES ('79686175024', '1961-10-03');
INSERT INTO tb_member (cpf, baptism_date) VALUES ('81965210066', '1991-03-02');
INSERT INTO tb_member (cpf, baptism_date) VALUES ('39661842060', '1999-06-10');