package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import java.util.List;
import org.manolo.entities.Article;
import org.manolo.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long>{
	 
	@Query("select a from Article a where a.fournisseur.idFournisseur=:x ")
	public Page<Article> ArticlesByFournisseur(@Param("x") Long idFournisseur,Pageable pageable);
	@Query("select c from Commande c where c.fournisseur.idFournisseur=:x ")
	public Page<Commande> CommandesByFournisseur(@Param("x") Long idFournisseur,Pageable pageable);
	@Query("select e from Fournisseur e ")
	public Page <Fournisseur> getAllFournisseurs(Pageable pageable);
}
