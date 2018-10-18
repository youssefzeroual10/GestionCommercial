package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.User;
import org.manolo.entities.Ville;


public class PageUser implements Serializable{
	private List <User> users;
	private int page;
	private int nombreUsers;
	private int totalUsers;
	private int totalPages;
	
	public List<User> getUser() {
		return users;
	}
	public void setUser(List<User> users) {
		this.users = users;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreUsers() {
		return nombreUsers;
	}
	public void setNombreUsers(int nombreUsers) {
		this.nombreUsers = nombreUsers;
	}
	public int getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
