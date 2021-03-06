package model;
// Generated 17-ene-2020 18:53:35 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Autor generated by hbm2java
 */
public class Autor implements java.io.Serializable {

	private Integer idAutor;
	private String nomAutor;
	private Set llibreses = new HashSet(0);

	public Autor() {
	}

	public Autor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	public Autor(String nomAutor, Set llibreses) {
		this.nomAutor = nomAutor;
		this.llibreses = llibreses;
	}

	public Integer getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNomAutor() {
		return this.nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	public Set getLlibreses() {
		return this.llibreses;
	}

	public void setLlibreses(Set llibreses) {
		this.llibreses = llibreses;
	}

}
