create table autor (
	id bigserial primary key,
	nome varchar(50) not null,
	data_nascimento timestamp not null,
	nacionalidade varchar(50) not null
);