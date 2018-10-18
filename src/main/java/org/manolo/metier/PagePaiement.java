package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Paiement;


public class PagePaiement implements Serializable{
	private List <Paiement> paiements;
	private int page;
	private int nombrePaiements;
	private int totalPaiements;
	private int totalArticles;;
	private int totalPages;
	public List<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombrePaiements() {
		return nombrePaiements;
	}
	public void setNombrePaiements(int nombrePaiements) {
		this.nombrePaiements = nombrePaiements;
	}
	public int getTotalPaiements() {
		return totalPaiements;
	}
	public void setTotalPaiements(int totalPaiements) {
		this.totalPaiements = totalPaiements;
	}
	public int getTotalArticles() {
		return totalArticles;
	}
	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
		

}
