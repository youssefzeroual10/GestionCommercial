package org.manolo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@DiscriminatorColumn(name = "type_mouvement" , 
discriminatorType=DiscriminatorType.STRING
,length=20)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,
property="type")
@JsonSubTypes({
	@Type(name="entree",value=Entree.class),
	@Type(name="sortie",value=Sortie.class),
	@Type(name="defectueuse",value=Defectueuse.class)
})
@XmlSeeAlso({Entree.class,Sortie.class,Defectueuse.class})
public abstract class Mouvement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMouvement;
	private Date dateMouvement;
	private int quantite;
	private double prixAchat;
	private String dateExpedition;
	private double prixVente;
	private String libelle;
	private boolean valide;
	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	@Transient
	 List<Mouvement> mouvements;
	
	public List<Mouvement> getMouvements() {
		return mouvements;
	}
	
	public void setMouvements(List<Mouvement> mouvements) {
		this.mouvements = mouvements;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public String getDateExpedition() {
		return dateExpedition;
	}
	public void setDateExpedition(String dateExpedition) {
		this.dateExpedition = dateExpedition;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@ManyToOne
	@JoinColumn(name="code_fk_commande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="code_fk_article")
	private Article article;
	public Long getIdMouvement() {
		return idMouvement;
	}
	public void setIdMouvement(Long idMouvement) {
		this.idMouvement = idMouvement;
	}
	public Date getDateMouvement() {
		return dateMouvement;
	}
	public void setDateMouvement(Date dateMouvement) {
		this.dateMouvement = dateMouvement;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@JsonIgnore
	public Commande getCommande() {
		return commande;
	}
	@JsonSetter
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	public Mouvement(Date dateMouvement, int quantite, double prixAchat, String dateExpedition, double prixVente,
			String libelle) {
		super();
		this.dateMouvement = dateMouvement;
		this.quantite = quantite;
		this.prixAchat = prixAchat;
		this.dateExpedition = dateExpedition;
		this.prixVente = prixVente;
		this.libelle = libelle;
	}
	public Mouvement() {
		super();
	}
	
}
