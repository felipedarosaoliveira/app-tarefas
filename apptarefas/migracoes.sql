--migrações sql














create table usuarios(
	id serial not null primary key,
	nome varchar(120) not null,
    email varchar(120) not null,
    senha varchar (20) not null,
    "dataHoraCriacao" timestamp not null,
    "dataHoraAtualizacao" timestamp not null,
    status varchar(100) not null
);