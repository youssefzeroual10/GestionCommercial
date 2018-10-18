package org.manolo.dao;
import java.util.List;

import org.manolo.entities.PrixArticle;
import org.manolo.entities.Quartier;
import org.manolo.entities.SousCategorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrixArticleRepository  extends JpaRepository<PrixArticle, Long>{

	@Query("select p from PrixArticle p where p.article.idArticle =:x")
	public List<PrixArticle> getPrices(@Param("x") Long idArticle );
}
