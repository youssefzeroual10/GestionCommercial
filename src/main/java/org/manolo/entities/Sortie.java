package org.manolo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("sortie")
@XmlType(name="sortie")
public class Sortie extends Mouvement{

	public Sortie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sortie(Date dateMouvement, int quantite, double prixAchat, String dateExpedition, Long prixVente,
			String libelle) {
		super(dateMouvement, quantite, prixAchat, dateExpedition, prixVente, libelle);
		// TODO Auto-generated constructor stub
	}

	
}
