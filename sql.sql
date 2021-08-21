CREATE DATABASE IF NOT EXISTS PTPESDB;
use PTPESDB;
CREATE TABLE pessoa (
	
    id INT 
    NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR (50),
    idade VARCHAR(3),
    altura VARCHAR(10),
    genero VARCHAR(10),
    peso VARCHAR(5)

);

CREATE TABLE pet (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    tipo VARCHAR(50),
    idade VARCHAR(3)

);

CREATE TABLE pet_pessoa (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT NOT NULL,
    id_pet INT NOT NULL,
    obs VARCHAR(150),
	
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_pet) REFERENCES pet(id)    
);


select * from pessoa;
select * from pet;
select * from pet_pessoa where pet_pessoa.id_pessoa = 1;

select distinct pessoa.id, pet.id, pet.nome, pessoa.nome from pet, pessoa
inner join pet_pessoa on pet_pessoa.id_pessoa = pessoa.id; 

select pet_pessoa.id_pet from pet_pessoa where pet_pessoa.id_pessoa = 1;


select * from pet where pet.id in (select pet_pessoa.id_pet from pet_pessoa where pet_pessoa.id_pessoa = 1);