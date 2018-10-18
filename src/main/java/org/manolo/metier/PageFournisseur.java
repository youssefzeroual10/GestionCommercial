package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Fournisseur;
import org.manolo.entities.Ville;


public class PageFournisseur implements Serializable{
	private List <Fournisseur> fournisseurs;
	private int page;
	private int nombreFournisseurs;
	private int totalFournisseurs;
	private int totalPages;
	
	public List<Fournisseur> getFournisseur() {
		return fournisseurs;
	}
	public void setFournisseur(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreFournisseurs() {
		return nombreFournisseurs;
	}
	public void setNombreFournisseurs(int nombreFournisseurs) {
		this.nombreFournisseurs = nombreFournisseurs;
	}
	public int getTotalFournisseurs() {
		return totalFournisseurs;
	}
	public void setTotalFournisseurs(int totalFournisseurs) {
		this.totalFournisseurs = totalFournisseurs;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
