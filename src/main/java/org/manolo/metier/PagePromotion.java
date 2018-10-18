package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Promotion;


public class PagePromotion implements Serializable{
	private List <Promotion> promotions;
	private int page;
	private int nombrePromotions;
	private int totalPromotions;
	private int totalArticles;;
	private int totalPages;
	public List<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombrePromotions() {
		return nombrePromotions;
	}
	public void setNombrePromotions(int nombrePromotions) {
		this.nombrePromotions = nombrePromotions;
	}
	public int getTotalPromotions() {
		return totalPromotions;
	}
	public void setTotalPromotions(int totalPromotions) {
		this.totalPromotions = totalPromotions;
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
