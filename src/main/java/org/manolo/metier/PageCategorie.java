package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Categorie;


public class PageCategorie implements Serializable{
	private List <Categorie> categories;
	private int page;
	private int nombreCategories;
	private int totalCategories;
	private int totalPages;
	
	public List<Categorie> getcategories() {
		return categories;
	}
	public void setcategories(List<Categorie> categories) {
		this.categories = categories;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreCategories() {
		return nombreCategories;
	}
	public void setNombreCategories(int nombreCategories) {
		this.nombreCategories = nombreCategories;
	}
	public int getTotalCategories() {
		return totalCategories;
	}
	public void setTotalCategories(int totalCategories) {
		this.totalCategories = totalCategories;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
