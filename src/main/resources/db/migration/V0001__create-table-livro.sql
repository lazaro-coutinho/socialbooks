create table livro (
	id bigserial primary key,
	nome varchar(50) not null,
	data_publicacao timestamp not null,
	editora varchar(50) not null,
	resumo varchar(100) not null
);