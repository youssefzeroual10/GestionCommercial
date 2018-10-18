package org.manolo.dao;


import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.Promotion;
import org.manolo.entities.Taxe;
import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromotionRepository  extends JpaRepository<Promotion, Long>{
	@Query("select p from Promotion p where p.article.idArticle =:x and p.client.cin = null  ")
	public Promotion  getPromotionByArticleCadeau(@Param("x")Long idArticle);
	//@Query(value="select *  from promotion  where (code_fk_article = :x and code_fk_client is null) in (select code_fk_article from Mouvement m where code_fk_commande=:y)",nativeQuery=true)
	//public List<Promotion>  getPromotionByArticle(@Param("y")Long idArticle,@Param("y")String idCommane);
	@Query(value="select *  from promotion  where (code_fk_client = :z or code_fk_client is null ) and code_fk_article in (select code_fk_article from Mouvement m where code_fk_article=:x and  code_fk_commande=:y) limit 1",nativeQuery=true)
	public Promotion  getPromotionByArticleClt(@Param("z")String cin,@Param("x")Long idArticle,@Param("y")String idCommane);
	@Query("select p from Promotion p where p.article.idArticle =:x and p.client.cin =:y  ")
	public Promotion  getPromotionByArticleClient(@Param("x")Long idArticle,@Param("y")String cin);
	/*@Query("select a from Article a where a.promotion.idPromotion =:x  ")
	public Article  getArticleByPromotion(@Param("x")Long idPromotion);*/
	/*@Query("select a from Client a where a.promotion.idPromotion =:x  ")
	public Client  getClientByPromotion(@Param("x")Long idPromotion);
	*/
	@Query("select p from Promotion p where p.client.cin= null")
	public List<Promotion>  getPromotionsWithOutClient();
	@Query("select p from Promotion p where p.client.cin != null and p.article.idArticle != null  ")
	public Page<Promotion>  getPromotionsWithClient(Pageable pageable);
	
	@Query("select p from Promotion p where p.article.idArticle in ( select a.idArticle from Article a where a.idArticle =:x ) ")
	public List<Promotion>  getPromotions(@Param("x")Long idArticle);
	
	//@Query("select p from Promotion p where p.article.idArticle in ( select a.idArticle from Article a where a.idArticle =a.idArticle ) ")
	@Query("select p from Promotion p where p.client.cin = null")
	public Page<Promotion>  getAllPromotions(Pageable pageable);
	
	

}
