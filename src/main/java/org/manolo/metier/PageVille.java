package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Ville;


public class PageVille implements Serializable{
	private List <Ville> villes;
	private int page;
	private int nombreVilles;
	private int totalVilles;
	private int totalPages;
	
	public List<Ville> getVilles() {
		return villes;
	}
	public void setVilles(List<Ville> Villes) {
		this.villes = Villes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreVilles() {
		return nombreVilles;
	}
	public void setNombreVilles(int nombreVilles) {
		this.nombreVilles = nombreVilles;
	}
	public int getTotalVilles() {
		return totalVilles;
	}
	public void setTotalVilles(int totalVilles) {
		this.totalVilles = totalVilles;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
