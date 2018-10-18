package org.manolo.dao;


import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.Role;
import org.manolo.entities.Taxe;
import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository  extends JpaRepository<Role, String>{
	@Query("select r from Role r ")
	public List <Role> getAllRoles();
	@Query("select r from Role r where r.role=:x")
	public Role getRole(@Param("x")String role);
	@Query("select r from Role r")
	public Page<Role> getAllRole(Pageable pageable);
	

}
