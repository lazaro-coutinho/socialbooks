create table livro (
	id bigserial primary key,
	nome varchar(50) not null,
	data_publicacao date not null,
	editora varchar(50) not null,
	resumo varchar(100) not null,
	autor varchar(50) not null
);