package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.TypeClient;


public class PageTypeClient implements Serializable{
	private List <TypeClient> types;
	private int page;
	private int nombreTypeClients;
	private int totalTypeClients;
	private int totalPages;
	public List<TypeClient> getTypes() {
		return types;
	}
	public void setTypes(List<TypeClient> types) {
		this.types = types;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreTypeClients() {
		return nombreTypeClients;
	}
	public void setNombreTypeClients(int nombreTypeClients) {
		this.nombreTypeClients = nombreTypeClients;
	}
	public int getTotalTypeClients() {
		return totalTypeClients;
	}
	public void setTotalTypeClients(int totalTypeClients) {
		this.totalTypeClients = totalTypeClients;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
	
	

}
