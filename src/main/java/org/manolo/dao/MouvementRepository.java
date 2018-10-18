package org.manolo.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Defectueuse;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;
import org.manolo.metier.PageMouvement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MouvementRepository extends JpaRepository<Mouvement, Long>{
	@Query("select m from Mouvement m where m.article.idArticle=:x ")
		public Page<Mouvement> getMouvements(@Param("x") Long idArticle,Pageable pageable);
	//la quantite  des entrees d'un article
	@Query("select COALESCE(sum(m.quantite),0) from Mouvement m where m.article.idArticle=:x and type_mouvement='entree'")
		public int getTotalQuantite(@Param("x") Long idArticle);
	//la quantite  des sorties d'un article
	@Query("select COALESCE(sum(m.quantite),0) from Mouvement m where m.article.idArticle=:x and type_mouvement='sortie' ")
			public int getTotalQuantiteSortie(@Param("x") Long idArticle);
	//la quantite  des cadeau d'un article
		@Query("select COALESCE(sum(m.quantite),0) from Mouvement m where m.article.idArticle=:x and type_mouvement='cadeau'  ")
			public int getTotalQuantiteCadeau(@Param("x") Long idArticle);
		
	//la quantite  des sorties d'un article
	@Query("select COALESCE(sum(m.quantite),0) from Mouvement m where m.article.idArticle=:x and type_mouvement='defectueuse' ")
				public int getTotalQuantiteDefect(@Param("x") Long idArticle);
	//la liste des sorties d'un article
	@Query("select m  from Mouvement m where m.article.idArticle=:x and type_mouvement='sortie'")
		public Page<Mouvement> getListSortie(@Param("x") Long idArticle,Pageable pageable);
	//la liste defectueuse d'un article
	@Query("select m  from Mouvement m where m.article.idArticle=:x and type_mouvement='defectueuse'")
		public Page<Mouvement> getListDefectueuse(@Param("x") Long idArticle,Pageable pageable);
	//la liste des cadeaux d'un article
		@Query("select p  from Mouvement p where  p.article.idArticle=:x and type_mouvement='cadeau'")
			public Page<Mouvement> getListCadeau(@Param("x") Long idArticle,Pageable pageable);
	//la liste des sorties d'un article
		@Query("select m  from Mouvement m where m.article.idArticle=:x and type_mouvement='entree'")
			public Page<Mouvement> getListEntree(@Param("x") Long idArticle,Pageable pageable);
	//la liste des sorties d'un article
		@Query("select m  from Mouvement m where m.dateExpedition between NOW() AND :x and type_mouvement='entree'")
		public Page<Mouvement> getListPerime(@Param("x") String date,Pageable pageable);	
		@Query("select m  from Mouvement m where m.dateExpedition between NOW() AND :x and type_mouvement='entree'")
		public List<Mouvement> getListPerimes(@Param("x") String date);	
	
		//la liste des sorties d'un article
	@Query("select m  from Mouvement m where m.dateExpedition <= NOW() AND	 type_mouvement='entree'")
		public List<Defectueuse> getEntree();
	//la liste sortie non valide d'un article
		@Query("select m  from Mouvement m where m.valide='false' and type_mouvement='sortie'")
		public List<Sortie> getSortieInvalide();
	//la liste de sorties d'un demande
	@Query("select m from Mouvement m where m.commande.idCommande=:x ")
		public List<Mouvement> getMouvementsByCommande(@Param("x") String idCommande);
	//la liste de sorties d'un demande page
		@Query("select m from Mouvement m where m.commande.idCommande=:x ")
			public Page<Mouvement> getMouvementsByCommandes(@Param("x") String idCommande,Pageable pageable);
	@Query("select m from Mouvement m where m.commande.idCommande=:x ")
	public Page<Mouvement> getListCadeau(@Param("x") String idCommande,Pageable pageable);
	
	@Query("select m from Mouvement m where m.commande.idCommande=:x ")
	public List<Mouvement> ListCadeau(@Param("x") String idCommande);

}
