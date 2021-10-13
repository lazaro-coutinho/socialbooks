package br.com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livro")
@NoArgsConstructor
@Getter
@Setter
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	private String nome;
	
	@NotNull(message = "Data de publicação é obrigatória.")
	@Column(name = "data_publicacao")
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;
	
	@NotEmpty(message = "Editora é obrigatório.")
	@JsonInclude(Include.NON_NULL)
	private String editora;
	
	@NotEmpty(message = "Resumo é obrigatório.")
	@Size(max = 100, message = "Resumo deve ter no máximo 255 caracteres.")
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@OneToMany(mappedBy = "livro")
	@JsonInclude(Include.NON_EMPTY)
	private List<Comentario> comentarios;
	
	@NotNull(message = "Autor é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
	public Livro(String nome) {
		this.nome = nome;
	}

}
