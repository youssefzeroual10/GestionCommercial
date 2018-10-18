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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity
public class Promotion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPromotion;
	private int qteMin;
	private int qteCadeau;
	private String libelle;
	/*@OneToOne(fetch = FetchType.LAZY,mappedBy="promotion")
	@JoinColumn(name="article")
	private Article article;
	@OneToOne(fetch = FetchType.LAZY,mappedBy="promotion")
	@JoinColumn(name="client")
	private Client client;*/
	@ManyToOne
	@JoinColumn(name="code_fk_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="code_fk_article")
	private Article article;
	public Long getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}
	
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	public int getQteCadeau() {
		return qteCadeau;
	}
	public void setQteCadeau(int qteCadeau) {
		this.qteCadeau = qteCadeau;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
