package org.manolo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("decharge")
@XmlType(name="decharge")
public class Decharge extends MouvementCharge{

	public Decharge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decharge(String dateMouvement, int quantite) {
		super(dateMouvement, quantite);
		// TODO Auto-generated constructor stub
	}

	
}
