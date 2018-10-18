package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Etat implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEtat;
	private String libelle;
	public Long getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(Long idEtat) {
		this.idEtat = idEtat;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Etat(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Etat() {
		super();
	}
	
}
