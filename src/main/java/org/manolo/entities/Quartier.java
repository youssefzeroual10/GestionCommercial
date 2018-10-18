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
public class Quartier implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQuartier;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="code_fk_ville")
	private Ville ville;
	@ManyToOne
	@JoinColumn(name="code_fk_user")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getIdQuartier() {
		return idQuartier;
	}
	public void setIdQuartier(Long idQuartier) {
		this.idQuartier = idQuartier;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public Quartier(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Quartier() {
		super();
	}
	
}
