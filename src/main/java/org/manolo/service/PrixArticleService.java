package org.manolo.service;

import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.PrixArticle;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PrixArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PrixArticleService {
	@Autowired
	private PrixArticleMetier prixArticleMetier;
	@RequestMapping(value = "/prix", method = RequestMethod.POST)
	public PrixArticle savePrix(@RequestParam Long idArticle,@RequestParam String libelle,@RequestParam double prixVente) {
		return prixArticleMetier.savePrix(idArticle,libelle,prixVente);
	}
	@RequestMapping(value = "/prix", method = RequestMethod.PUT)
	public PrixArticle updatePrix(PrixArticle prixArticle) {
		return prixArticleMetier.updatePrix(prixArticle);
	}
	@RequestMapping(value = "/prix", method = RequestMethod.DELETE)
	public void deletePrixArticle(Long id) {
		prixArticleMetier.deletePrixArticle(id);
	}
	@RequestMapping(value = "/prixarticles", method = RequestMethod.GET)
	public List<PrixArticle> getPrices(@RequestParam Long idArticle) {
		return prixArticleMetier.getPrices(idArticle);
	}
	
	
}
