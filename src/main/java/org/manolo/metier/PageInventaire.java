package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Inventaire;


public class PageInventaire implements Serializable{
	private List <Inventaire> inventaires;
	private int page;
	private int nombreInventaires;
	private int totalInventaires;
	private int totalArticles;;
	private int totalPages;
	public List<Inventaire> getInventaires() {
		return inventaires;
	}
	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreInventaires() {
		return nombreInventaires;
	}
	public void setNombreInventaires(int nombreInventaires) {
		this.nombreInventaires = nombreInventaires;
	}
	public int getTotalInventaires() {
		return totalInventaires;
	}
	public void setTotalInventaires(int totalInventaires) {
		this.totalInventaires = totalInventaires;
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
