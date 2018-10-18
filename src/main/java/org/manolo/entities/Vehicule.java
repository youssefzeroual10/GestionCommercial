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
public class Vehicule implements Serializable {
	@Id
	private String immatriculation;
	private String carteGrise;
	private boolean disponibilite;
	@ManyToOne
	@JoinColumn(name="code_fk_user")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getCarteGrise() {
		return carteGrise;
	}
	public void setCarteGrise(String carteGrise) {
		this.carteGrise = carteGrise;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public Vehicule(String immatriculation, String carteGrise, boolean disponibilite) {
		super();
		this.immatriculation = immatriculation;
		this.carteGrise = carteGrise;
		this.disponibilite = disponibilite;
	}
	public Vehicule() {
		super();
	}
	
	
	

}
