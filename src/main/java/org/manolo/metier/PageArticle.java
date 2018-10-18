package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Article;


public class PageArticle implements Serializable{
	private List <Article> articles;
	private int page;
	private int nombreArticles;
	private int totalArticles;
	private int totalPages;
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreArticles() {
		return nombreArticles;
	}
	public void setNombreArticles(int nombreArticles) {
		this.nombreArticles = nombreArticles;
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
