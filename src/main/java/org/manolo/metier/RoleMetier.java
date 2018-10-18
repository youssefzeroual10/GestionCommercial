package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Role;
import org.springframework.data.domain.Page;

public interface RoleMetier {
	public List<Role> getAllRoles();
	public Role saveRole(Role role);
	public Role updateRole(Role role);
	public void deleteRole(String  role);
	public PageRole getAllRole(int size,int page);
	public Role getRole(String role);
	
}
