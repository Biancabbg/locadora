#drop database Locadora;

create database Locadora;
use Locadora;

create table Filme (
id int auto_increment primary key,
nome varchar(50),
diretor varchar(50),
ano_publicacao varchar(50),
preco_aluguel double,
status varchar(50)




);

create table Cliente (
id int auto_increment primary key,
nome varchar(50),
telefone varchar (50), 
email varchar (50),
data_reserva date, 
data_devolucao date,
nome_filme varchar (100)
);




select * from filme;
select * from Cliente;


DESCRIBE Cliente;