package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Commande implements Serializable {
	@Id
	private String idCommande;
	private String dateCommande;
	private double montant;
	private double reste;
	private boolean typeCommande;
	private boolean isViseted;
	public boolean isViseted() {
		return isViseted;
	}
	public void setViseted(boolean isViseted) {
		this.isViseted = isViseted;
	}
	private String bonCommande;
	
	
	public String getBonCommande() {
		return bonCommande;
	}
	public void setBonCommande(String bonCommande) {
		this.bonCommande = bonCommande;
	}
	public boolean isTypeCommande() {
		return typeCommande;
	}
	public void setTypeCommande(boolean typeCommande) {
		this.typeCommande = typeCommande;
	}
	public double getReste() {
		return reste;
	}
	public void setReste(double reste) {
		this.reste = reste;
	}
	private boolean statuts;
	public boolean isStatuts() {
		return statuts;
	}
	public void setStatuts(boolean statuts) {
		this.statuts = statuts;
	}
	@ManyToOne
	@JoinColumn(name="code_fk_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="code_fk_etat")
	private Etat etat;
	@ManyToOne
	@JoinColumn(name="code_fk_user")
	private User user;
	@ManyToOne
	@JoinColumn(name="code_fk_fournisseur")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "commande" ,fetch=FetchType.LAZY) 
	private Collection<Mouvement> mouvements;
	public Collection<Mouvement> getMouvements() {
		return mouvements;
	}
	public void setMouvements(Collection<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commande(String idCommande, String dateCommande, double montant) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.montant = montant;
	}
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Commande() {
		super();
	}

}
