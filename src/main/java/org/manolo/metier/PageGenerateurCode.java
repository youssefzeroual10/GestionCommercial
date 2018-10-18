package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;


public class PageGenerateurCode implements Serializable{
	private List <GenerateurCode> codes;
	private int page;
	private int nombreCode;
	private int totalCodes;
	private int totalPages;
	public List<GenerateurCode> getCodes() {
		return codes;
	}
	public void setCodes(List<GenerateurCode> codes) {
		this.codes = codes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreCode() {
		return nombreCode;
	}
	public void setNombreCode(int nombreCode) {
		this.nombreCode = nombreCode;
	}
	public int getTotalCodes() {
		return totalCodes;
	}
	public void setTotalCodes(int totalCodes) {
		this.totalCodes = totalCodes;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	

	
	
	

}
