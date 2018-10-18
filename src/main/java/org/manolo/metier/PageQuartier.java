package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Quartier;


public class PageQuartier implements Serializable{
	private List <Quartier> quartiers;
	private int page;
	private int nombreQuartiers;
	private int totalQuartiers;
	private int totalPages;
	
	public List<Quartier> getQuartiers() {
		return quartiers;
	}
	public void setQuartiers(List<Quartier> Quartiers) {
		this.quartiers = Quartiers;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreQuartiers() {
		return nombreQuartiers;
	}
	public void setNombreQuartiers(int nombreQuartiers) {
		this.nombreQuartiers = nombreQuartiers;
	}
	public int getTotalQuartiers() {
		return totalQuartiers;
	}
	public void setTotalQuartiers(int totalQuartiers) {
		this.totalQuartiers = totalQuartiers;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
