package org.manolo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GenerateurIdCommande implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCode;

	public Long getIdCode() {
		return idCode;
	}

	public void setIdCode(Long idCode) {
		this.idCode = idCode;
	}

	public GenerateurIdCommande(Long idCode) {
		super();
		this.idCode = idCode;
	}

	public GenerateurIdCommande() {
		super();
	} 
	

}
