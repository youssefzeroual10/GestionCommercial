package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idArticle;
	private String designation;
	private int seuilAlert;
	private int quantite;
	@ManyToOne
	@JoinColumn(name="code_fk_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name="code_fk_taxe")
	private Taxe taxe;
	@ManyToOne
	@JoinColumn(name="code_fk_sous_categorie")
	private SousCategorie sousCategorie;
	@OneToMany(mappedBy = "article" ,fetch=FetchType.LAZY) 
	private Collection<PrixArticle> articles;
    /*@OneToOne
	@JoinColumn(name="code_fk_promotion")
	private Promotion promotion;
	@JsonIgnore
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}*/
	public Collection<PrixArticle> getArticles() {
		return articles;
	}
	public void setArticles(Collection<PrixArticle> articles) {
		this.articles = articles;
	}
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSeuilAlert() {
		return seuilAlert;
	}
	public void setSeuilAlert(int seuilAlert) {
		this.seuilAlert = seuilAlert;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Taxe getTaxe() {
		return taxe;
	}
	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}
	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}
	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Article(String designation,  int seuilAlert) {
		super();
		this.designation = designation;
		this.seuilAlert = seuilAlert;
	}
	public Article() {
		super();
	}
	
	
}
