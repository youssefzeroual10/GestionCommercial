package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Etat;


public class PageEtat implements Serializable{
	private List <Etat> etats;
	private int page;
	private int nombreEtats;
	private int totalEtats;
	private int totalPages;
	
	public List<Etat> getEtats() {
		return etats;
	}
	public void setEtats(List<Etat> Etats) {
		this.etats = Etats;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreEtats() {
		return nombreEtats;
	}
	public void setNombreEtats(int nombreEtats) {
		this.nombreEtats = nombreEtats;
	}
	public int getTotalEtats() {
		return totalEtats;
	}
	public void setTotalEtats(int totalEtats) {
		this.totalEtats = totalEtats;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
