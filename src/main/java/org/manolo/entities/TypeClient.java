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
public class TypeClient implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTypeClient;
	private String libelle;
	public Long getIdTypeClient() {
		return idTypeClient;
	}
	public void setIdTypeClient(Long idTypeClient) {
		this.idTypeClient = idTypeClient;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public TypeClient(String libelle) {
		super();
		this.libelle = libelle;
	}
	public TypeClient() {
		super();
	}
	
	
}
