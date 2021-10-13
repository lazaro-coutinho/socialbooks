package br.com.algaworks.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends NaoEncontradoException {
	
	private static final long serialVersionUID = 1L;
	
	public AutorNaoEncontradoException() {
		super("Autor não encontrado.");
	}
	
	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
