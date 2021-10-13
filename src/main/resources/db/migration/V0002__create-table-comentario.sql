create table comentario (
	id bigserial primary key,
	texto varchar(255) not null,
	usuario varchar(50) not null,
	data timestamp not null,
	livro_id int8 null
);

alter table comentario add constraint fk_livro_id foreign key (livro_id) references livro(id);