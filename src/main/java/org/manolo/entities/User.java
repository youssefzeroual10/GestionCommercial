package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class User  implements Serializable{
	@Id
	private String IdUser;
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	private String dateEmbauche;
	@Transient
	private double totalCommande;
	@Transient
	List<Commande> commande;
	@Transient
	List<Action> action;
	@Transient
	double benifice;
		
	public List<Commande> getCommande() {
		return commande;
	}
	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}
	public List<Action> getAction() {
		return action;
	}
	public void setAction(List<Action> action) {
		this.action = action;
	}
	public double getBenifice() {
		return benifice;
	}
	public void setBenifice(double benifice) {
		this.benifice = benifice;
	}
	public double getTotalCommande() {
		return totalCommande;
	}
	public void setTotalCommande(double totalCommande) {
		this.totalCommande = totalCommande;
	}
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

		
	@ManyToMany
	@JoinTable(name="user_role")
	private Collection<Role> roles;
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public String getIdUser() {
		return IdUser;
	}
	public void setIdUser(String idUser) {
		IdUser = idUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public User(String idUser, String password, String email, String telephone, String adresse,String nom,String prenom,String dateEmbauche) {
		super();
		IdUser = idUser;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche=dateEmbauche;
	}
	
	public User(User user) {
		super();
		this.IdUser = IdUser;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche=dateEmbauche;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
