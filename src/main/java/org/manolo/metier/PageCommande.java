package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Commande;


public class PageCommande implements Serializable{
	private List <Commande> commandes;
	private int page;
	private int nombreCommandes;
	private int totalCommandes;
	private int totalPages;
	
	public List<Commande> getCommande() {
		return commandes;
	}
	public void setCommande(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreCommandes() {
		return nombreCommandes;
	}
	public void setNombreCommandes(int nombreCommandes) {
		this.nombreCommandes = nombreCommandes;
	}
	public int getTotalCommandes() {
		return totalCommandes;
	}
	public void setTotalCommandes(int totalCommandes) {
		this.totalCommandes = totalCommandes;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
