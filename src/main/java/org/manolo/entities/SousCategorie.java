package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SousCategorie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSousCategorie;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="code_fk_categorie")
	private Categorie categorie;
	public Long getIdSousCategorie() {
		return idSousCategorie;
	}
	public void setIdSousCategorie(Long idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public SousCategorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	public SousCategorie() {
		super();
	}
	
}
