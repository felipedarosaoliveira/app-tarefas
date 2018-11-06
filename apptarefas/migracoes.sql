--migrações sql
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