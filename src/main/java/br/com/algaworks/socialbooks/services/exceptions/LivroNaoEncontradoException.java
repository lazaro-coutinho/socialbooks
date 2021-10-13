package br.com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends NaoEncontradoException {
	
	private static final long serialVersionUID = 1L;
	
	public LivroNaoEncontradoException() {
		super("Livro não encontrado.");
	}
	
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
