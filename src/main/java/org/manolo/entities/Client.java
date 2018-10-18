package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Client  implements Serializable{
	@Id
	private String cin;
	private String nom;
	private String adresse;
	private String telephone;
	
	public Client(String cin, String nom, String adresse, String telephone) {
		super();
		this.cin = cin;
		this.nom = nom;
		
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@ManyToOne
	@JoinColumn(name="code_fk_quartier")
	private Quartier quartier;
	@ManyToOne
	@JoinColumn(name="code_fk_user")
	private User user;
	@ManyToOne
	@JoinColumn(name="code_fk_type")
	private TypeClient typeClient;
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	public Client() {
		super();
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/*@OneToOne
	@JoinColumn(name="code_fk_promotion")
	private Promotion promotion;
	@JsonIgnore
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	*/
	
	
}
