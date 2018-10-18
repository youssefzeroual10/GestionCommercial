package org.manolo.metier;

import java.util.List;

import org.manolo.dao.CategorieRepository;
import org.manolo.dao.SousCategorieRepository;
import org.manolo.entities.Quartier;
import org.manolo.entities.SousCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class SousCategorieMetierImpl  implements SousCategorieMetier{
	@Autowired 
	private SousCategorieRepository sousCategorieRepository;
	@Autowired 
	private CategorieRepository categorieRepository;
	@Override
	public SousCategorie saveSousCategorie(SousCategorie cat) {
		return sousCategorieRepository.save(cat);
	}

	@Override
	public SousCategorie updateSousCategorie(Long idCategorie,Long idSousCategorie,String libelle) {
		SousCategorie sousCat = sousCategorieRepository.findOne(idSousCategorie);
		sousCat.setCategorie(categorieRepository.findOne(idCategorie));
		sousCat.setLibelle(libelle);
		return sousCategorieRepository.save(sousCat);
	}

	@Override
	public void deleteSousCategorie(Long id) {
		sousCategorieRepository.delete(getSousCategorie(id));
	}

	@Override
	public PageSousCategorie getAllSousCategories(int size, int page) {
		Page<SousCategorie> ops = sousCategorieRepository.getAllSousCategories(new PageRequest(page,size));
		PageSousCategorie pSc = new PageSousCategorie();
		pSc.setSousCategories(ops.getContent());
		pSc.setNombreSousCategories(ops.getNumberOfElements());
		pSc.setPage(ops.getNumber());
		pSc.setTotalPages(ops.getTotalPages());
		pSc.setTotalSousCategories((int)ops.getTotalElements());
		return pSc;
	}

	@Override
	public PageSousCategorie getBySousCategoriesMotCle(String motCle, int size, int page) {
		Page<SousCategorie> ops = sousCategorieRepository.getSousCategoriesByMotCle(motCle, new PageRequest(page, size));
		PageSousCategorie pSc = new PageSousCategorie();
		pSc.setSousCategories(ops.getContent());
		pSc.setNombreSousCategories(ops.getNumberOfElements());
		pSc.setPage(ops.getNumber());
		pSc.setTotalPages(ops.getTotalPages());
		pSc.setTotalSousCategories((int)ops.getTotalElements());
		return pSc;
}

	@Override
	public SousCategorie getSousCategorie(Long id) {
		return sousCategorieRepository.findOne(id);
	}

	@Override
	public List<SousCategorie> getAllSousCategories() {
		return sousCategorieRepository.findAll();
	}

	@Override
	public List<SousCategorie> getSousCatByCat(Long idCategorie) {
		return sousCategorieRepository.getSousCatByCat(idCategorie);
	}
}
