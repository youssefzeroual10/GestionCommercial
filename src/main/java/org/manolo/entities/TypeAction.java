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
public class TypeAction implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTypeAction;
	private String libelle;
	
	public Long getIdTypeAction() {
		return idTypeAction;
	}
	public void setIdTypeAction(Long idTypeAction) {
		this.idTypeAction = idTypeAction;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public TypeAction(String libelle) {
		super();
		this.libelle = libelle;
	}
	public TypeAction() {
		super();
	}
	
	
}
