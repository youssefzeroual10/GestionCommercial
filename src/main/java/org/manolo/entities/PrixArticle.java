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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class PrixArticle implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPrixArticle;
	private double prixVente;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="code_fk_article")
	private Article article;
	public Long getIdPrixArticle() {
		return idPrixArticle;
	}
	
	public void setIdPrixArticle(Long idPrixArticle) {
		this.idPrixArticle = idPrixArticle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@JsonIgnore
	public Article getArticle() {
		return article;
	}
	@JsonSetter
	public void setArticle(Article article) {
		this.article = article;
	}
	public PrixArticle(double prixVente, String libelle, Article article) {
		super();
		this.prixVente = prixVente;
		this.libelle = libelle;
		this.article = article;
	}
	public PrixArticle() {
		super();
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	
	
}
