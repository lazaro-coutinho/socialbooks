alter table livro add column autor_id int8;
alter table livro add constraint fk_autor_id foreign key (autor_id) references autor(id);