package org.manolo.service;

import java.util.Date;
import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.Role;
import org.manolo.entities.Commande;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.CommandeMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PageRole;
import org.manolo.metier.RoleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RoleService {
	@Autowired
	private RoleMetier roleMetier;
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<Role> getAllRoles() {
		return roleMetier.getAllRoles();
	}
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public Role saveRole(Role role) {
		return roleMetier.saveRole(role);
	}
	@RequestMapping(value = "/roles", method = RequestMethod.PUT)
	public Role updateRole(Role role) {
		return roleMetier.updateRole(role);
	}
	@RequestMapping(value = "/roles/{role}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable String role) {
		roleMetier.deleteRole(role);
	}
	@RequestMapping(value = "/getroles", method = RequestMethod.GET)
	public PageRole getAllRole(int size, int page) {
		return roleMetier.getAllRole(size, page);
	}
	@RequestMapping(value = "/roles/{role}", method = RequestMethod.GET)
	public Role getRole(@PathVariable String role) {
		return roleMetier.getRole(role);
	}
	
	
	
}
