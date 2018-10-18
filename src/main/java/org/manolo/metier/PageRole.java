package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Role;


public class PageRole implements Serializable{
	private List <Role> roles;
	private int page;
	private int nombreRoles;
	private int totalRoles;
	private int totalPages;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreRoles() {
		return nombreRoles;
	}
	public void setNombreRoles(int nombreRoles) {
		this.nombreRoles = nombreRoles;
	}
	public int getTotalRoles() {
		return totalRoles;
	}
	public void setTotalRoles(int totalRoles) {
		this.totalRoles = totalRoles;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
