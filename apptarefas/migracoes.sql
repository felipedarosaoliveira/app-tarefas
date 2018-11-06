--migrações sql
<<<<<<< HEAD














create table usuarios(
	id serial not null primary key,
	nome varchar(120) not null,
    email varchar(120) not null,
    senha varchar (20) not null,
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    status varchar(100) not null
);
=======
create database "transpoBrasil";

create table projetos (
    id serial not null primary key,
    nome varchar(100) not null,
    descricao varchar(1000) not null,
    status varchar(100),
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    "dataHoraFim" timestamp not null
);
--tabela projeto
--tabela projeto
--tabela projeto
>>>>>>> 6e0badc1b53cf4c021770deb95381fdef76cb6ec
