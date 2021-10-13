package br.com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.algaworks.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
