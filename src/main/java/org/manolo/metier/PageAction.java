package org.manolo.metier;

import java.io.Serializable;
import java.util.List;

import org.manolo.entities.Action;


public class PageAction implements Serializable{
	private List <Action> actions;
	private int page;
	private int nombreActions;
	private int totalActions;
	private int totalPages;
	
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> Actions) {
		this.actions = Actions;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreActions() {
		return nombreActions;
	}
	public void setNombreActions(int nombreActions) {
		this.nombreActions = nombreActions;
	}
	public int getTotalActions() {
		return totalActions;
	}
	public void setTotalActions(int totalActions) {
		this.totalActions = totalActions;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	
	

}
