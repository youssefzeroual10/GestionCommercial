package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.SousCategorie;


public class PageSousCategorie implements Serializable{
	private List <SousCategorie> sousCategories;
	private int page;
	private int nombreSousCategories;
	private int totalSousCategories;
	private int totalPages;
	
	public List<SousCategorie> getSousCategories() {
		return sousCategories;
	}
	public void setSousCategories(List<SousCategorie> SousCategories) {
		this.sousCategories = SousCategories;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreSousCategories() {
		return nombreSousCategories;
	}
	public void setNombreSousCategories(int nombreSousCategories) {
		this.nombreSousCategories = nombreSousCategories;
	}
	public int getTotalSousCategories() {
		return totalSousCategories;
	}
	public void setTotalSousCategories(int totalSousCategories) {
		this.totalSousCategories = totalSousCategories;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
