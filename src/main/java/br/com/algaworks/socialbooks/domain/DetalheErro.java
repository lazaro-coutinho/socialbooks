package br.com.algaworks.socialbooks.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalheErro {
	
	private String titulo;
	
	private Long status;
	
	private Long timestamp;
	
	private String mensagemDesenvolvedor;

}
