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
	@Type(name="charge",value=Charge.class),
	@Type(name="decharge",value=Decharge.class)
})
@XmlSeeAlso({ChargeCamion.class,Decharge.class})
public abstract class MouvementCharge implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMouvementCharge;
	private String dateMouvement;
	private int quantite;
	@Transient
	List<MouvementCharge> mouvements;
	@ManyToOne
	@JoinColumn(name="code_fk_charge")
	private ChargeCamion charge;
	@ManyToOne
	@JoinColumn(name="code_fk_article")
	private Article article;
	public MouvementCharge(String dateMouvement, int quantite) {
		super();
		this.dateMouvement = dateMouvement;
		this.quantite = quantite;
	}
	public MouvementCharge() {
		super();
	}
	public Long getIdMouvementCharge() {
		return idMouvementCharge;
	}
	public void setIdMouvementCharge(Long idMouvementCharge) {
		this.idMouvementCharge = idMouvementCharge;
	}
	public String getDateMouvement() {
		return dateMouvement;
	}
	public void setDateMouvement(String dateMouvement) {
		this.dateMouvement = dateMouvement;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public List<MouvementCharge> getMouvements() {
		return mouvements;
	}
	public void setMouvements(List<MouvementCharge> mouvements) {
		this.mouvements = mouvements;
	}
	public ChargeCamion getCharge() {
		return charge;
	}
	public void setCharge(ChargeCamion charge) {
		this.charge = charge;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
}
