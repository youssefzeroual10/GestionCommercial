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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity
public class Inventaire implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idInventaire;
	private Date dateInventaire ;
	private Date dateStart ;
	private Date dateEnd ;
	public Long getIdInventaire() {
		return idInventaire;
	}
	public void setIdInventaire(Long idInventaire) {
		this.idInventaire = idInventaire;
	}
	public Date getDateInventaire() {
		return dateInventaire;
	}
	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Inventaire(Date dateInventaire,Date dateStart, Date dateEnd) {
		super();
		this.dateInventaire = dateInventaire;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	public Inventaire() {
		super();
	}
	
	
	
}
