package org.manolo.dao;

import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository  extends JpaRepository<Article, Long>{
	@Query("select a from Article a where a.designation like :x")
	public Page <Article> getArticlesByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select a from Article a ")
	public Page <Article> getAllArticles(Pageable pageable);
	@Query("select count(*) from Article ")
	public int getcountarticle();
	@Query("select p from Promotion p where p.article.idArticle != null")
	public List <Promotion> getArticlesNoPromo();
	@Query("select p from Promotion p where p.article.idArticle = null")
	public Page <Article> getAllArticlesPromo(Pageable pageable);
	@Query("select a from Article a where a.quantite <= a.seuilAlert")
	public Page <Article> getAllArticlesAlert(Pageable pageable);
	@Query("select a from Article a where a.quantite <= a.seuilAlert")
	public List <Article> getListArticlesAlert();
	
}
