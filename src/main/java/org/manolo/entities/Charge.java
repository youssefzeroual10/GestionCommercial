package org.manolo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue("charge")
@XmlType(name="charge")
public class Charge  extends MouvementCharge{

	public Charge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Charge(String dateMouvement, int quantite) {
		super(dateMouvement, quantite);
		// TODO Auto-generated constructor stub
	}
	
	


	
	

}
