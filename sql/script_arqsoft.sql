show databases;
use aula01_web2;
show tables;


select * from cidades;


create database aqtsoft;

use aqtsoft;

create table pais(
	id int auto_increment primary key,
    nome text not null,
    sigla text not null
);

create table cliente(
	id int auto_increment primary key,
	nome text not null,
    telefone text,
    limite_credito int not null,
    idade int,
    idPais int,
    CONSTRAINT fk_paisCliente FOREIGN KEY (idPais) REFERENCES Pais (id)
);
    
    
    show tables;
    
    describe cliente;
    
    
    
    
    