--migraÃ§Ãµes sql

create database "transpoBrasil";

--tabela projeto
create table projetos (
    id serial not null primary key,
    nome varchar(100) not null,
    descricao varchar(1000) not null,
    status varchar(100),
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    "dataHoraFim" timestamp not null
);



create table usuarios(
	id serial not null primary key,
	nome varchar(120) not null,
    email varchar(120) not null,
    senha varchar (20) not null,
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    status varchar(100) not null
);


create table situacao(
	id serial not null primary key,
	nome varchar(120) not null,
	tipo varchar(120) not null, 
	"dataHoraCriacao" timestamp not null, 
	"dataHoraAtualizacao" timestamp not null,
	"dataHoraRemocao" timestamp,
	status varchar(100) not null
);

create table tarefas (
    id serial not null primary key,
    nome varchar(100) not null,
    descricao varchar(1000) not null,
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    "projetoId" bigint,
    "usuarioId" bigint,
    "situacaoId" bigint,
    foreign key ("projetoId") references projetos(id),
    foreign key ("usuarioId") references usuarios(id),
    foreign key ("situacaoId") references situacao(id)
    );

-- Atualizaçõ tabela Projetos 19/11/2018
alter table projetos alter column "dataHoraFim" drop not null;

--Atualização tabela usuarios
alter table usuarios add unique (email);

-- Atualização tabela usuarios
alter table usuarios add column "dataHoraRemocao" timestamp;

--Atualizando tabela tarefas
alter table tarefas add column "dataHoraRemocao" timestamp;

--Atualização tabela usuarios coluna senha (aumenta o tamanho da coluna para inserir senha criptografada)
ALTER TABLE usuarios ALTER COLUMN senha TYPE varchar(80);

--Insere usuario para testes: t@teste.com senha 12345678 (criptografada)
INSERT INTO usuarios(nome,email,senha,"dataHoraCriacao","dataHoraAtualizacao",status) VALUES
('Usuário Teste','t@teste.com','25d55ad283aa400af464c76d713c07ad',now(),now(),'ATIVO');
