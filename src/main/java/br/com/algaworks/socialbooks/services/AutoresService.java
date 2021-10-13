package br.com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.algaworks.socialbooks.domain.Autor;
import br.com.algaworks.socialbooks.repository.AutoresRepository;
import br.com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import br.com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = buscar(autor.getId());
			if (a != null) {
				throw new AutorExistenteException("Autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public void atualizar(Autor autor) {
		verificarExistencia(autor);
		autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Optional<Autor> optionalAutor = autoresRepository.findById(id);
		if (optionalAutor.isEmpty()) {
			throw new AutorNaoEncontradoException();
		}
		return optionalAutor.get();
	}
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}
	
	private void verificarExistencia(Autor autor) {
		buscar(autor.getId());
	}

}
