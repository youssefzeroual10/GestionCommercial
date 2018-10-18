package org.manolo.metier;

import java.util.Date;
import java.util.List;

import org.manolo.dao.CommandeRepository;
import org.manolo.dao.EtatRepository;
import org.manolo.dao.FournisseurRepository;
import org.manolo.dao.RoleRepository;
import org.manolo.entities.Categorie;
import org.manolo.entities.Commande;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.manolo.entities.Role;
import org.manolo.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RoleMetierImpl  implements RoleMetier{
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll() ;
	}
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(String role) {
		roleRepository.delete(role);
	}	

	@Override
	public PageRole getAllRole(int size, int page) {
		Page<Role> ops = roleRepository.getAllRole(new PageRequest(page, size));
		PageRole pEt = new PageRole();
		pEt.setRoles(ops.getContent());
		pEt.setNombreRoles(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalRoles((int)ops.getTotalElements());
		return pEt; 
	}

	@Override
	public Role getRole(String role) {
		
		return roleRepository.findOne(role);
	}

	}
