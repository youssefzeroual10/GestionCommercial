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
public class Action implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAction;
	private String Description;
	private String facture;
	private double montant;
	private String dateAction;
	private String dateAlert;
	private boolean paye;
	private boolean alert;
	public String getFacture() {
		return facture;
	}

	public void setFacture(String facture) {
		this.facture = facture;
	}

	public TypeAction getTypeAction() {
		return typeAction;
	}

	public void setTypeAction(TypeAction typeAction) {
		this.typeAction = typeAction;
	}


	
	@ManyToOne
	@JoinColumn(name="code_fk_vehicule")
	private Vehicule vehicule;
	@ManyToOne
	@JoinColumn(name="code_fk_typeAction")
	private TypeAction typeAction;

	public Long getIdAction() {
		return idAction;
	}

	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDateAction() {
		return dateAction;
	}

	public void setDateAction(String dateAction) {
		this.dateAction = dateAction;
	}

	public boolean isPaye() {
		return paye;
	}

	public void setPaye(boolean paye) {
		this.paye = paye;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	

	public String getDateAlert() {
		return dateAlert;
	}

	public void setDateAlert(String dateAlert) {
		this.dateAlert = dateAlert;
	}
	

	public Action(String description, String facture, double montant, String dateAction, String dateAlert, boolean paye,
			boolean alert, Vehicule vehicule, TypeAction typeAction) {
		super();
		Description = description;
		this.facture = facture;
		this.montant = montant;
		this.dateAction = dateAction;
		this.dateAlert = dateAlert;
		this.paye = paye;
		this.alert = alert;
		this.vehicule = vehicule;
		this.typeAction = typeAction;
	}

	public Action() {
		super();
	}
	
	
}
