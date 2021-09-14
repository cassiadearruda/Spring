
/*MODEL TEMA PARA API DEMETER - Grupo 06
 *
 *		Projeto de Rede Social para integrar pessoas com necessidades a possíveis doadores
 *
 *
 *Grupo:
 *	Anderson
 * 	Cássia
 *	Matheus Farina
 *	Renata
 *	Vinicius Cardoso
 */
package org.generation.demeterAPI.model;

import java.util.List;

import javax.persistence.CascadeType;

//Pacotes importados

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Criação da Tabela

@Entity // -> Define Entidade
@Table(name = "tb_tema") // -> Dá o nome à tabela no MySQL
public class Tema {

	//Criação do atributo ID como Primary Key e Auto Increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Criação do atributo Categoria como String, tamanho máximo de 255 caracteres
	@NotNull
	@Size(max = 255)
	private String categoria;
	
	//Criação do atributo Filtro como String, tamanho máximo de 255 caracteres
	@NotNull
	@Size(max = 255)
	private String filtro;
	
	//Criação do atributo Localidade como String, tamanho máximo de 255 caracteres
	@NotNull
	@Size(max = 255)
	private String localidade;
	
	@OneToMany (mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("tema")
	private List<Postagem> postagem;

	// Início dos Getters e Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
}
