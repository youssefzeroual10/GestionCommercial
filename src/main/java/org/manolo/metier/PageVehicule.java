package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Vehicule;


public class PageVehicule implements Serializable{
	private List <Vehicule> vehicules;
	private int page;
	private int nombreVehicules;
	private int totalVehicules;
	private int totalPages;
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreVehicules() {
		return nombreVehicules;
	}
	public void setNombreVehicules(int nombreVehicules) {
		this.nombreVehicules = nombreVehicules;
	}
	public int getTotalVehicules() {
		return totalVehicules;
	}
	public void setTotalVehicules(int totalVehicules) {
		this.totalVehicules = totalVehicules;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
