package org.manolo.dao;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Avance;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.entities.Etat;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaiementRepository  extends JpaRepository<Paiement, Long>{
	@Query("select p  from Paiement p where p.commande.idCommande =:x ")
	public List<Paiement> getPaiements(@Param("x") String idCommande);
	@Query("select a from Avance a where a.idAvance=idAvance and a.paiement.idPaiement in(select p.commande.idCommande from Paiement p  where  p.commande.idCommande in ( select c.idCommande from Commande c where c.idCommande=:x  ))")
	public List<Avance> getAvanceCommande(@Param("x")String idCommande);
	/*
	 select * from Avance a where id_avance=id_avance and code_fk_paiement in(select code_fk_commande from Paiement   where  code_fk_commande in ( select id_commande from commande where id_commande=2 )) 
	 
	 */
	@Query("select SUM(a.montant) from Avance a where a.paiement.idPaiement in(select p.idPaiement from Paiement p  where  p.commande.idCommande =:x)")
	public Long getSumAvance(@Param("x")String idCommande);
	//select sum(montant) from avance where code_fk_paiement in ( select id_paiement from paiement where code_fk_commande='kk')
	
	@Query("select SUM(p.montant) from Paiement p where p.commande.idCommande in(select c.idCommande from Commande c  where  c.idCommande =:x)")
	public Long getReste(@Param("x")String idCommande);
	
	//SELECT sum(montant) FROM `paiement` WHERE code_fk_commande in ( select id_commande from commande where id_commande='kk')
	@Query("select p from Paiement p where p.datePaiement between NOW() And :x")
	public List<Paiement> getAlerteCheque(@Param("x") String date);

	//SELECT * FROM `paiement` WHERE date_paiement between NOW() AND '2018-07-31'

}
