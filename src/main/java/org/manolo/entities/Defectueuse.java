package org.manolo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue("defectueuse")
@XmlType(name="defectueuse")
public class Defectueuse extends Mouvement {

	public Defectueuse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Defectueuse(Date dateMouvement, int quantite, double prixAchat, String dateExpedition, Long prixVente,
			String libelle) {
		super(dateMouvement, quantite, prixAchat, dateExpedition, prixVente, libelle);
		// TODO Auto-generated constructor stub
	}
	
	
}
