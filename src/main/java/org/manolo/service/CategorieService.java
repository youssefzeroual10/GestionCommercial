package org.manolo.service;

import java.util.List;

import org.manolo.entities.Categorie;
import org.manolo.entities.SousCategorie;
import org.manolo.metier.CategorieMetier;
import org.manolo.metier.PageCategorie;
import org.manolo.metier.SousCategorieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieService {
	@Autowired
	private CategorieMetier categorieMetier;
	@Autowired
	private SousCategorieMetier sousCategorieMetier;
	@RequestMapping(value = "/getcategories", method = RequestMethod.GET)
	public PageCategorie getAllCategories(
			@RequestParam int size, 
			@RequestParam int page) {
		return categorieMetier.getAllCategories(size, page);
	}

	public PageCategorie getByCategoriesMotCle(
			@RequestParam String motCle, 
			@RequestParam int size, 
			@RequestParam int page) {
		return categorieMetier.getByCategoriesMotCle(motCle, size, page);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public Categorie saveCategorie( Categorie cat) {
		return categorieMetier.saveCategorie(cat);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.PUT)
	public Categorie updateCategorie( Categorie cat) {
		return categorieMetier.updateCategorie(cat);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	public void deleteCategorie(@PathVariable Long id) {
		categorieMetier.deleteCategorie(id);
	}
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public Categorie getCategorie(@PathVariable Long id) {
		return categorieMetier.getCategorie(id);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Categorie> getAllCategories() {
		return categorieMetier.getAllCategories();
	}
}
