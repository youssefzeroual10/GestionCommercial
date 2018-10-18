package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class ChargeCamion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCharge;
	private String dateCharge;
	@ManyToOne
	@JoinColumn(name="code_fk_superieur")
	private User superieur;
	@ManyToOne
	@JoinColumn(name="code_fk_chauffeur")
	private User chauffeur;
	private boolean typeChargeCamion;
	public boolean isTypeChargeCamion() {
		return typeChargeCamion;
	}
	public void setTypeChargeCamion(boolean typeChargeCamion) {
		this.typeChargeCamion = typeChargeCamion;
	}
	public Long getIdCharge() {
		return idCharge;
	}
	public void setIdCharge(Long idCharge) {
		this.idCharge = idCharge;
	}
	public String getDateCharge() {
		return dateCharge;
	}
	public void setDateCharge(String dateCharge) {
		this.dateCharge = dateCharge;
	}
	public User getSuperieur() {
		return superieur;
	}
	public void setSuperieur(User superieur) {
		this.superieur = superieur;
	}
	public User getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(User chauffeur) {
		this.chauffeur = chauffeur;
	}
	
	
}
