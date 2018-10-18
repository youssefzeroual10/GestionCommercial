package org.manolo.metier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.CommandeRepository;
import org.manolo.dao.FournisseurRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PrixArticleRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.dao.SousCategorieRepository;
import org.manolo.dao.TaxeRepository;
import org.manolo.entities.Article;
import org.manolo.entities.Entree;
import org.manolo.entities.Mouvement;
import org.manolo.entities.PrixArticle;
import org.manolo.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@Transactional
public class ArticleMetierImpl implements ArticleMetier {
	@Autowired 
	private ArticleRepository articleRepository;
	@Autowired 
	private PromotionRepository promotionRepository;
	@Autowired 
	private FournisseurRepository fournisseurRepository;
	@Autowired 
	private TaxeRepository taxeRepository;
	@Autowired 
	private MouvementRepository mouvementRepository;
	@Autowired 
	private CommandeRepository commandeRepository;
	@Autowired 
	private SousCategorieRepository sousCategorieRepository;
	@Autowired 
	private PrixArticleRepository prixArticleRepository;
	@Override
	public Article saveArticle(String designation,Long fournisseur,Long sousCategorie,
			String Commande,double prixAchat,String dateExpedition,
			int quantite , int seuilAlert) {
		Article article = new Article();
		article.setDesignation(designation);
		article.setQuantite(quantite);
		article.setFournisseur(fournisseurRepository.findOne(fournisseur));
		article.setSeuilAlert(seuilAlert);
		article.setSousCategorie(sousCategorieRepository.findOne(sousCategorie));
		Mouvement mouvement = new Entree();
		mouvement.setArticle(article);
		mouvement.setCommande(commandeRepository.findOne(Commande));
		mouvement.setDateExpedition(dateExpedition);
		mouvement.setDateMouvement(new Date());
		mouvement.setPrixAchat(prixAchat);
		mouvement.setQuantite(quantite);
		mouvementRepository.save(mouvement);
		articleRepository.save(article);
		return article;
	}
	@Transactional
	@Override
	public Article updateArticle( String designation, Long fournisseur, Long sousCategorie, Long idArticle,int seuilAlert) {
		Article article = articleRepository.findOne(idArticle);
		article.setDesignation(designation);
		article.setQuantite(article.getQuantite());
		article.setFournisseur(fournisseurRepository.findOne(fournisseur));
		article.setSeuilAlert(seuilAlert);
		article.setSousCategorie(sousCategorieRepository.findOne(sousCategorie));
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		//if(sousArticles.size() > 0) throw new RuntimeException("Vous devez supprimer les sous Articles");

		articleRepository.delete(getArticle(id));
	}

	@Override
	public PageArticle getAllArticles(int size, int page) {
		Page<Article> arts = articleRepository.getAllArticles(new PageRequest(page, size));
		PageArticle pArt = new PageArticle();
		pArt.setArticles(arts.getContent());
		pArt.setNombreArticles(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalArticles((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public PageArticle getByArticlesMotCle(String motCle, int size, int page) {
		Page<Article> arts = articleRepository.getArticlesByMotCle(motCle, new PageRequest(page, size));
		PageArticle pArt = new PageArticle();
		pArt.setArticles(arts.getContent());
		pArt.setNombreArticles(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalArticles((int)arts.getTotalElements());
		return pArt; 
	}

	@Override
	public Article getArticle(Long id) {
		return articleRepository.findOne(id);
	}

	@Override
	public List<Article> getAllArticles() {
		List<Article> articles =   articleRepository.findAll();
		int compteur = 0;		
		for (Article article : articles) { 
			//articles.get(compteur).setPrixArticles(prixArticleRepository.getPrices(article.getIdArticle()));
			//Article art = articleRepository.findOne(articles.get(compteur).getIdArticle());
			List<PrixArticle> pA = prixArticleRepository.getPrices(article.getIdArticle());
			//article.setPrix(compteur);//(pA);
			//article.setPrixArticles(pA);
			articleRepository.saveAndFlush(article);
			compteur ++;
		}
		return articles;
	}
	@Override
	public int getcountarticle() {
		return articleRepository.getcountarticle();
	}
	@Override
	public List<Article> getArticlesNoPromo() {
		List<Article> articles = articleRepository.findAll();
		List<Promotion> promotions = promotionRepository.getPromotionsWithOutClient();
		for (Promotion pro : promotions) {
			System.out.println("*"+pro.getArticle().getDesignation());
		}
		List<Article> articlesNoPromo=new ArrayList<Article>();
		for (Promotion pro : promotions) {
			articles.remove(pro.getArticle());
		}
		return articles;
	}
	
	@Override
	public PageArticle getAllArticlesPromo(int size, int page) {
		Page<Article> arts = articleRepository.getAllArticlesPromo( new PageRequest(page, size));
		PageArticle pArt = new PageArticle();
		pArt.setArticles(arts.getContent());
		pArt.setNombreArticles(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalArticles((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public PageArticle getAllArticlesAlert(int size, int page) {
		Page<Article> arts = articleRepository.getAllArticlesAlert( new PageRequest(page, size));
		PageArticle pArt = new PageArticle();
		pArt.setArticles(arts.getContent());
		pArt.setNombreArticles(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalArticles((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public List<Article> getListArticlesAlert() {
		return articleRepository.getListArticlesAlert();
	}
}
