package br.com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autor")
@NoArgsConstructor
@Getter
@Setter
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	private String nome;
	
	@NotNull(message = "Data de nascimento é obrigatória.")
	@Column(name = "data_nascimento")
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotEmpty(message = "Nacionalidade é obrigatória.")
	@JsonInclude(Include.NON_NULL)
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	@JsonInclude(Include.NON_EMPTY)
	private List<Livro> livros;

}
