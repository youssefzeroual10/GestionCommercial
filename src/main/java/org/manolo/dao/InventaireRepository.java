package org.manolo.dao;


import java.util.Date;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Inventaire;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Promotion;
import org.manolo.entities.Taxe;
import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventaireRepository  extends JpaRepository<Inventaire, Long>{
	@Query("select m from Mouvement m where m.dateMouvement BETWEEN :dateStart and :dateEnd and type_mouvement ='entree' and m.article.idArticle=:x")
	public List<Mouvement> getInventaireEntree (@Param("dateStart")Date dateStart,@Param("dateEnd")Date dateEnd,@Param("x")Long IdArticle);
	@Query("select m from Mouvement m where m.dateMouvement BETWEEN :dateStart and :dateEnd and type_mouvement ='sortie' and m.article.idArticle=:x")
	public List<Mouvement> getInventaireSortie (@Param("dateStart")Date dateStart,@Param("dateEnd")Date dateEnd ,@Param("x")Long IdArticle);
	@Query("select m from Mouvement m where m.dateMouvement BETWEEN :dateStart and :dateEnd and type_mouvement ='cadeau' and m.article.idArticle=:x")
	public List<Mouvement> getInventaireCadeau (@Param("dateStart")Date dateStart,@Param("dateEnd")Date dateEnd ,@Param("x")Long IdArticle);
	@Query("select m from Mouvement m where m.dateMouvement BETWEEN :dateStart and :dateEnd and type_mouvement ='defectueuse'  and m.article.idArticle=:x")
	public List<Mouvement> getInventaireDef (@Param("dateStart")Date dateStart,@Param("dateEnd")Date dateEnd ,@Param("x")Long IdArticle);
	@Query("select i from Inventaire i ")
	public Page <Inventaire> getAllInventaires(Pageable pageable);
	
	
}
