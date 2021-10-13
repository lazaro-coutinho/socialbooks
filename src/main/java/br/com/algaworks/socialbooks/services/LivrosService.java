package br.com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.algaworks.socialbooks.domain.Livro;
import br.com.algaworks.socialbooks.repository.LivrosRepository;
import br.com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public void remover(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
	}
	
	public Livro buscar(Long id) {
		Optional<Livro> optionalLivro = livrosRepository.findById(id);
		if (optionalLivro.isEmpty()) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
		return optionalLivro.get();
	}
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}

}
