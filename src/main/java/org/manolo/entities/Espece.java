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
@DiscriminatorValue("espece")
@XmlType(name="espece")
public class Espece extends Paiement {

	public Espece() {
		super();
	}

	public Espece(String datePaiement) {
		super(datePaiement);
	}
	
	

}
