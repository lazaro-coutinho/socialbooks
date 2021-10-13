package br.com.algaworks.socialbooks.services.exceptions;

public class NaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public NaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
