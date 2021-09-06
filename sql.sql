CREATE DATABASE IF NOT EXISTS chat_db;

use chat_db;

CREATE TABLE USUARIO (
	
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR (50),
    email VARCHAR(150),
    avatar VARCHAR(100),
    descricao VARCHAR(240)
    
);

CREATE TABLE CHAT (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80),
    status_chat ENUM ('ABERTO', 'FECHADO'),
    cap_max INT,
    assunto VARCHAR(30)
    

);

CREATE TABLE usuario_chat (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_chat INT NOT NULL,
    favorito ENUM('SIM', 'NAO'),
    administrador ENUM('SIM', 'NAO'),
	
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_pet) REFERENCES pet(id)    
);


select * from usuario;
select * from chat;
select * from usuario_chat where usuario_chat.id_usuario = 1;

select distinct pessoa.id, pet.id, pet.nome, pessoa.nome from pet, pessoa
inner join pet_pessoa on pet_pessoa.id_pessoa = pessoa.id; 

select pet_pessoa.id_pet from pet_pessoa where pet_pessoa.id_pessoa = 1;


select * from pet where pet.id in (select pet_pessoa.id_pet from pet_pessoa where pet_pessoa.id_pessoa = 1);