package org.manolo.metier;

import java.util.List;
import org.manolo.dao.CategorieRepository;
import org.manolo.dao.SousCategorieRepository;
import org.manolo.entities.Categorie;
import org.manolo.entities.SousCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CategorieMetierImpl implements CategorieMetier {
	@Autowired 
	private CategorieRepository categorieRepository;
	@Autowired 
	private SousCategorieRepository sousCategorieRepository;
	@Override
	public Categorie saveCategorie(Categorie cat) {
		return categorieRepository.save(cat);
	}

	@Override
	public Categorie updateCategorie(Categorie cat) {
		return categorieRepository.save(cat);
	}

	@Override
	public void deleteCategorie(Long id) {
		List<SousCategorie> sousCategories = sousCategorieRepository.getSousCatByCat(id);
		if(sousCategories.size() > 0) throw new RuntimeException("Vous devez supprimer les sous categories");

		categorieRepository.delete(getCategorie(id));
	}

	@Override
	public PageCategorie getAllCategories(int size, int page) {
		Page<Categorie> ops = categorieRepository.getAllCategories(new PageRequest(page, size));
		PageCategorie pCat = new PageCategorie();
		pCat.setcategories(ops.getContent());
		pCat.setNombreCategories(ops.getNumberOfElements());
		pCat.setPage(ops.getNumber());
		pCat.setTotalPages(ops.getTotalPages());
		pCat.setTotalCategories((int)ops.getTotalElements());
		return pCat; 
	}
	@Override
	public PageCategorie getByCategoriesMotCle(String motCle, int size, int page) {
		Page<Categorie> ops = categorieRepository.getCategoriesByMotCle(motCle, new PageRequest(page, size));
		PageCategorie pCat = new PageCategorie();
		pCat.setcategories(ops.getContent());
		pCat.setNombreCategories(ops.getNumberOfElements());
		pCat.setPage(ops.getNumber());
		pCat.setTotalPages(ops.getTotalPages());
		pCat.setTotalCategories((int)ops.getTotalElements());
		return pCat; 
	}

	@Override
	public Categorie getCategorie(Long id) {
		return categorieRepository.findOne(id);
	}

	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

}
