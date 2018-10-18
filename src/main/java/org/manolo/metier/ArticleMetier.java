package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Article;

public interface ArticleMetier {
	public Article saveArticle(String designation,Long fournisseur,Long sousCategorie,
							String Commande,double prixAchat,String dateExpedition,
							int quantite , int seuilAlert);
	public Article updateArticle(String designation, Long fournisseur, Long sousCategorie, Long idArticle, int seuilAlert);
	public void deleteArticle(Long id);
	public PageArticle getAllArticles(int size,int page);
	public PageArticle getByArticlesMotCle(String motCle,int size,int page);
	public Article getArticle(Long id);
	public List<Article>  getAllArticles();
	public  int getcountarticle();
	public List <Article> getArticlesNoPromo();
	public PageArticle getAllArticlesPromo(int size,int page);
	public PageArticle getAllArticlesAlert(int size,int page);
	public List<Article>  getListArticlesAlert();


}
