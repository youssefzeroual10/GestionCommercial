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
public class Avance implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAvance;
	private double montant;
	@ManyToOne
	@JoinColumn(name="code_fk_paiement")
	private Paiement paiement;
	public Long getIdAvance() {
		return idAvance;
	}
	public void setIdAvance(Long idAvance) {
		this.idAvance = idAvance;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public Avance(double montant) {
		super();
		this.montant = montant;
	}
	public Avance() {
		super();
	}
	
	
	
}
