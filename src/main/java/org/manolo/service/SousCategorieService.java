package org.manolo.service;

import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.SousCategorie;
import org.manolo.metier.PageSousCategorie;
import org.manolo.metier.SousCategorieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SousCategorieService {
	@Autowired
	private SousCategorieMetier sousCategorieMetier;
	@RequestMapping(value = "/sousCategories", method = RequestMethod.POST)
	public SousCategorie saveSousCategorie(SousCategorie sCat) {
		return sousCategorieMetier.saveSousCategorie(sCat);
	}
	@RequestMapping(value = "/sousCategories", method = RequestMethod.PUT)
	public SousCategorie updateSousCategorie(
						@RequestParam Long idCategorie,
						@RequestParam Long idSousCategorie,
						@RequestParam String libelle) {
		return sousCategorieMetier.updateSousCategorie( idCategorie, idSousCategorie, libelle);
	}
	@RequestMapping(value = "/sousCategories/{id}", method = RequestMethod.DELETE)
	public void deleteSousCategorie(@PathVariable Long id) {
		sousCategorieMetier.deleteSousCategorie(id);
	}
	@RequestMapping(value = "/sousCategories/{id}", method = RequestMethod.GET)
	public SousCategorie getSousCategorie(@PathVariable  Long id) {
		return sousCategorieMetier.getSousCategorie(id);
	}
	@RequestMapping(value = "/sousCategories", method = RequestMethod.GET)
	public List<SousCategorie> getAllSousCategories() {
		return sousCategorieMetier.getAllSousCategories();
	}
	@RequestMapping(value = "/getsousCategories", method = RequestMethod.GET)
	public PageSousCategorie getAllSousCategories(int size, int page) {
		return sousCategorieMetier.getAllSousCategories(size, page);
	}
	public PageSousCategorie getBySousCategoriesMotCle(String motCle, int size, int page) {
		return sousCategorieMetier.getBySousCategoriesMotCle(motCle, size, page);
	}
	
}
