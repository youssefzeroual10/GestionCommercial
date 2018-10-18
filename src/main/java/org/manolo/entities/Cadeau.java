package org.manolo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
@Entity
@DiscriminatorValue("cadeau")
@XmlType(name="cadeau")
public class Cadeau  extends Mouvement{

	public Cadeau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cadeau(Date dateMouvement, int quantite, double prixAchat, String dateExpedition, Long prixVente,
			String libelle) {
		super(dateMouvement, quantite, prixAchat, dateExpedition, prixVente, libelle);
		// TODO Auto-generated constructor stub
	}
	
	public Cadeau(Date dateMouvement, int quantite, double prixAchat, Date dateExpedition,Long article,
			Long commande){
		super();
		
	}


	
	

}
