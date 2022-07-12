package com.generation.games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_classe")
public class Classe {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String className;
	
	@NotNull
	private String habilidadeEspecial;
	
	@OneToMany (mappedBy = "classe", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("classe")
	private List<Personagem> personagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getHabilidadeEspecial() {
		return habilidadeEspecial;
	}

	public void setHabilidadeEspecial(String habilidadeEspecial) {
		this.habilidadeEspecial = habilidadeEspecial;
	}

	public List<Personagem> getPersonagem() {
		return personagem;
	}

	public void setPersonagem(List<Personagem> personagem) {
		this.personagem = personagem;
	}

	
	
	


}
