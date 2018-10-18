package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity
public class Taxe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTaxe;
	@NotNull
	@Min(value=1,message="supp 1")
	private double taux;
	public Long getIdTaxe() {
		return idTaxe;
	}
	public void setIdTaxe(Long idTaxe) {
		this.idTaxe = idTaxe;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public Taxe(double taux) {
		super();
		this.taux = taux;
	}
	public Taxe() {
		super();
	}
	
}
