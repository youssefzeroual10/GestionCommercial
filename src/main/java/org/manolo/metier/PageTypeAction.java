package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.TypeAction;


public class PageTypeAction implements Serializable{
	private List <TypeAction> types;
	private int page;
	private int nombreTypeActions;
	private int totalTypeActions;
	private int totalPages;
	public List<TypeAction> getTypes() {
		return types;
	}
	public void setTypes(List<TypeAction> types) {
		this.types = types;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreTypeActions() {
		return nombreTypeActions;
	}
	public void setNombreTypeActions(int nombreTypeActions) {
		this.nombreTypeActions = nombreTypeActions;
	}
	public int getTotalTypeActions() {
		return totalTypeActions;
	}
	public void setTotalTypeActions(int totalTypeActions) {
		this.totalTypeActions = totalTypeActions;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
	
	

}
