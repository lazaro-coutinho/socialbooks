package br.com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.algaworks.socialbooks.domain.DetalheErro;
import br.com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import br.com.algaworks.socialbooks.services.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handlerNaoEncontradoException
	(NaoEncontradoException e, HttpServletRequest request) {
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404L);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalheErro> handlerAutorExistenteException
	(AutorExistenteException e, HttpServletRequest request) {
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(409L);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

}
