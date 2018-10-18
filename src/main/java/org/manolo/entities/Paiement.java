package org.manolo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_paiement" ,discriminatorType=DiscriminatorType.STRING,length=20)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,
property="type")
@JsonSubTypes({
	@Type(name="credit",value=Credit.class),
	@Type(name="cheque",value=Cheque.class),
	@Type(name="espece",value=Espece.class)
})
@XmlSeeAlso({Credit.class,Cheque.class,Espece.class})
public abstract class Paiement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaiement;
	private String datePaiement;
	private String libelle ;
	private double montant;
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@ManyToOne
	@JoinColumn(name = "code_fk_commande")
	private Commande commande;

	public Long getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Paiement(String datePaiement) {
		super();
		this.datePaiement = datePaiement;
	}
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Paiement() {
		super();
	}

}
