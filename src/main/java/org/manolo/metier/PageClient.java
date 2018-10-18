package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Client;
import org.manolo.entities.Ville;


public class PageClient implements Serializable{
	private List <Client> clients;
	private int page;
	private int nombreClients;
	private int totalClients;
	private int totalPages;
	
	public List<Client> getClient() {
		return clients;
	}
	public void setClient(List<Client> clients) {
		this.clients = clients;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreClients() {
		return nombreClients;
	}
	public void setNombreClients(int nombreClients) {
		this.nombreClients = nombreClients;
	}
	public int getTotalClients() {
		return totalClients;
	}
	public void setTotalClients(int totalClients) {
		this.totalClients = totalClients;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
