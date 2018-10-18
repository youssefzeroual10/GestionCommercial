package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Taxe;


public class PageTaxe implements Serializable{
	private List <Taxe> taxes;
	private int page;
	private int nombreTaxes;
	private int totalTaxes;
	private int totalPages;
	
	public List<Taxe> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<Taxe> Taxes) {
		this.taxes = Taxes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreTaxes() {
		return nombreTaxes;
	}
	public void setNombreTaxes(int nombreTaxes) {
		this.nombreTaxes = nombreTaxes;
	}
	public int getTotalTaxes() {
		return totalTaxes;
	}
	public void setTotalTaxes(int totalTaxes) {
		this.totalTaxes = totalTaxes;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
