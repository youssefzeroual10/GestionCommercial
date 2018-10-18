package org.manolo.metier;

import java.util.List;

import org.manolo.dao.EtatRepository;
import org.manolo.entities.Categorie;
import org.manolo.entities.Etat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EtatMetierImpl  implements EtatMetier{
	@Autowired 
	private EtatRepository etatRepository;
	@Override
	public Etat saveEtat(Etat cat) {
		return etatRepository.save(cat);
	}

	@Override
	public Etat updateEtat(Etat cat) {
		return etatRepository.save(cat);
	}

	@Override
	public void deleteEtat(Long id) {
		etatRepository.delete(getEtat(id));
	}	

	@Override
	public Etat getEtat(Long id) {
		return etatRepository.findOne(id);
	}

	@Override
	public List<Etat> getAllEtats() {
		return etatRepository.findAll();
	}

	@Override
	public PageEtat getAllEtat(int size, int page) {
		Page<Etat> ops = etatRepository.getAllEtat(new PageRequest(page, size));
		PageEtat pEt = new PageEtat();
		pEt.setEtats(ops.getContent());
		pEt.setNombreEtats(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalEtats((int)ops.getTotalElements());
		return pEt; 
	}

	@Override
	public PageEtat getByEtatsMotCle(String motCle, int size, int page) {
		Page<Etat> ops = etatRepository.getEtatsByMotCle(motCle,new PageRequest(page, size));
		PageEtat pEt = new PageEtat();
		pEt.setEtats(ops.getContent());
		pEt.setNombreEtats(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalEtats((int)ops.getTotalElements());
		return pEt; 	
	}
}
