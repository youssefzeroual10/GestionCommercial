package org.manolo.metier;

import java.util.List;

import org.manolo.dao.EtatRepository;
import org.manolo.dao.GenerateurCodeRepository;
import org.manolo.dao.GenerateurIdCommandeRepository;
import org.manolo.entities.Categorie;
import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.manolo.entities.GenerateurIdCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class GenerateurIdCommandeImpl  implements GenerateurIdCommandeMetier{
	@Autowired 
	private GenerateurIdCommandeRepository generateurIdCommandeRepository;
	@Override
	public Long getNextAutoIncrement() {
		GenerateurIdCommande id = new GenerateurIdCommande();
		
		Long idCommande = generateurIdCommandeRepository.getNextAutoIncrement();
		generateurIdCommandeRepository.save(id);
		return idCommande;
	}
	
	
}
