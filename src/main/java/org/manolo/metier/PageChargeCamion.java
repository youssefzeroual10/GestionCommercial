package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.ChargeCamion;


public class PageChargeCamion implements Serializable{
	private List <ChargeCamion> chargeCamions;
	private int page;
	private int nombreChargeCamions;
	private int totalChargeCamions;
	private int totalPages;
	
	public List<ChargeCamion> getChargeCamion() {
		return chargeCamions;
	}
	public void setChargeCamion(List<ChargeCamion> chargeCamions) {
		this.chargeCamions = chargeCamions;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreChargeCamions() {
		return nombreChargeCamions;
	}
	public void setNombreChargeCamions(int nombreChargeCamions) {
		this.nombreChargeCamions = nombreChargeCamions;
	}
	public int getTotalChargeCamions() {
		return totalChargeCamions;
	}
	public void setTotalChargeCamions(int totalChargeCamions) {
		this.totalChargeCamions = totalChargeCamions;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
