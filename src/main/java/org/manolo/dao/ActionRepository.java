package org.manolo.dao;


import java.util.List;

import org.manolo.entities.Action;
import org.manolo.entities.Commande;
import org.manolo.entities.Taxe;
import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActionRepository  extends JpaRepository<Action, Long>{
	@Query("select a from Action a ")
	public Page <Action> getAllActions(Pageable pageable);
	@Query("select a from Action a where a.vehicule.immatriculation =:x")
	public Page <Action> getActionsByVehicule(@Param("x") String immatriculation,Pageable pageable);
	@Query(value=" SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'action' AND table_schema = 'manolo'",nativeQuery=true)
	public Long  getNextAutoIncrement();
	@Query("select a from Action a where MONTH(a.dateAlert) between :moisCourant and :moisProchain")
	public List <Action> getAlertActions(@Param("moisCourant") int moisCourant,@Param("moisProchain") int moisProchain);
	//benifice by user
	@Query("SELECT sum(c.montant) FROM Commande c  WHERE c.user.IdUser=:x and MONTH(c.dateCommande)=:mois and YEAR(c.dateCommande)=:annee and c.typeCommande=1")
	public double getCmdByUsers(@Param("x") String idUser,@Param("mois") int mois,@Param("annee") int annee);
	@Query("SELECT sum(a.montant) FROM Action a  WHERE a.vehicule.user.IdUser=:x and MONTH(a.dateAction)=:mois and YEAR(a.dateAction)=:annee")
	public double getActionByUser(@Param("x") String idUser,@Param("mois") int mois,@Param("annee") int annee);
	@Query("SELECT c FROM Commande c  WHERE c.user.IdUser=:x and MONTH(c.dateCommande)=:mois and YEAR(c.dateCommande)=:annee and c.typeCommande=1")
	public List<Commande> getListCommandesByUser(@Param("x") String IdUser,@Param("mois") int mois,@Param("annee") int annee);
	@Query("SELECT a FROM Action a  WHERE a.vehicule.user.IdUser=:x and MONTH(a.dateAction)=:mois and YEAR(a.dateAction)=:annee")
	public List<Action> getListActionByUser(@Param("x") String IdUser,@Param("mois") int mois,@Param("annee") int annee);
	
	//benifice global
	@Query("SELECT sum(c.montant) FROM Commande c  WHERE  MONTH(c.dateCommande)=:mois and YEAR(c.dateCommande)=:annee and c.typeCommande=1")
	public double getCommandesEntree(@Param("mois") int mois,@Param("annee") int annee);
	@Query("SELECT sum(c.montant) FROM Commande c  WHERE  MONTH(c.dateCommande)=:mois and YEAR(c.dateCommande)=:annee and c.typeCommande=0")
	public double getCommandesSortie(@Param("mois") int mois,@Param("annee") int annee);
	@Query("SELECT sum(a.montant) FROM Action a  WHERE  MONTH(a.dateAction)=:mois and YEAR(a.dateAction)=:annee")
	public double getActions(@Param("mois") int mois,@Param("annee") int annee);
	
	
}
