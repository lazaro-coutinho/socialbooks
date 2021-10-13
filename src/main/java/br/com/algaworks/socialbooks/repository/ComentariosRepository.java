package br.com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.algaworks.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
