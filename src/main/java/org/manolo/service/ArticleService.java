package org.manolo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.PageArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class ArticleService {
	@Autowired
	private ArticleMetier articleMetier;
	
	@RequestMapping(value = "/getArticles", method = RequestMethod.GET)
	public PageArticle getAllArticles(
			@RequestParam int size, 
			@RequestParam int page) {
		return articleMetier.getAllArticles(size, page);
	}

	public PageArticle getByArticlesMotCle(
			@RequestParam String motCle, 
			@RequestParam int size, 
			@RequestParam int page) {
		return articleMetier.getByArticlesMotCle(motCle, size, page);
	}

	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public Article saveArticle(
					@RequestParam String designation,
					@RequestParam Long fournisseur,
					@RequestParam Long sousCategorie,
					@RequestParam String Commande,
					@RequestParam double prixAchat,
					@RequestParam String dateExpedition,
			int quantite , int seuilAlert) {
		return articleMetier.saveArticle(designation, fournisseur, sousCategorie, Commande, prixAchat, dateExpedition, quantite, seuilAlert);
	}

	@RequestMapping(value = "/articles", method = RequestMethod.PUT)
	public Article updateArticle( @RequestParam String designation,
			@RequestParam Long fournisseur,
			@RequestParam Long sousCategorie,
			@RequestParam Long idArticle,
			@RequestParam int seuilAlert) {
		return articleMetier.updateArticle(designation, fournisseur, sousCategorie, idArticle,seuilAlert);
	}

	@RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable Long id) {
		articleMetier.deleteArticle(id);
	}
	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public Article getArticle(@PathVariable Long id) {
		return articleMetier.getArticle(id);
	}
	//@Secured(value={"SUPER_ADMIN"})
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public List<Article> getAllArticles() {
		return articleMetier.getAllArticles();
	}
	@RequestMapping(value = "/getcountarticle", method = RequestMethod.GET)
	public int getcountarticle() {
		return articleMetier.getcountarticle();
	}
	@RequestMapping(value = "/articlesnopromo", method = RequestMethod.GET)
	public List<Article> getArticlesNoPromo() {
		return articleMetier.getArticlesNoPromo();
	}
	@RequestMapping(value = "/alertes", method = RequestMethod.GET)
	public List<Article> getListArticlesAlerte() {
		return articleMetier.getListArticlesAlert();
	}
	
	
}
