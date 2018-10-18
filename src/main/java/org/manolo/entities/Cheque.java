package org.manolo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue("cheque")
@XmlType(name="cheque")
public class Cheque extends Paiement {
	private String photo;
	private String datePaiement;
	public Cheque() {
		super();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	


	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Cheque(String datePaiement, String photo) {
		super(datePaiement);
		this.photo = photo;
	}

	
	
}
