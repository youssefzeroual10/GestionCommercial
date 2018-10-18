package org.manolo.dao;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository  extends JpaRepository<Commande, String>{
	
	@Query("select DISTINCT  c.dateCommande as dateCommande from Commande c ")
	public String [] getDateCommandes();
	/* commandes achat */
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) = MONTH(NOW()) AND DAY(dateCommande) = DAY(NOW()) AND c.typeCommande=0 ")
	public Page <Commande> commandesNow(Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) =:mois AND DAY(dateCommande) =:jour AND c.typeCommande=0")
	public Page <Commande> commandesDay(@Param("mois") int mois,@Param("jour") int jour,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) =:annee AND MONTH(dateCommande) =:mois AND DAY(dateCommande) =:jour AND c.typeCommande=0")
	public Page <Commande> commandesJour(@Param("annee") int annee,@Param("mois") int mois,@Param("jour") int jour,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) = MONTH(NOW()) AND DAY(dateCommande) =:jour AND c.typeCommande=0")
	public Page <Commande> commandesJourMnt(@Param("jour") int jour,Pageable pageable);
	
	
	@Query("SELECT c FROM Commande c WHERE MONTH(dateCommande) =:mois AND YEAR(dateCommande) =:annee AND c.typeCommande=0")
	public Page <Commande> commandesMonth(@Param("annee") int annee,@Param("mois") int mois,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW())  AND MONTH(dateCommande) =:mois AND c.typeCommande=0")
	public Page <Commande> commandesMois(@Param("mois") int mois,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) =:annee AND c.typeCommande=0")
	public Page <Commande> commandesYear(@Param("annee") int annee,Pageable pageable);
	@Query("select c   from Commande c where c.typeCommande=0  ")
	public Page <Commande> getAllCommande(Pageable pageable);
	@Query("select c   from Commande c where c.typeCommande=1  ")
	public Page <Commande> getAllCommandeVente(Pageable pageable);
	@Query("select c from Commande c where c.client.cin=:x and c.statuts=0  ")
	public Page<Commande> CommandesByClientCredit(@Param("x") String cin,Pageable pageable);
	@Query("select c from Commande c where c.user.IdUser=:x and c.statuts=0 AND c.typeCommande=1 ")
	public Page<Commande> CommandesByUserCredit(@Param("x") String IdUser,Pageable pageable);
	/**************fin journee user chauffeur*********************************/
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser )")
	public Page<Paiement> CommandesUser(@Param("date") String date,@Param("idUser") String idUser,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:week and MONTH(c.dateCommande) =:date1 and YEAR(c.dateCommande) =:date1 and c.user.IdUser =:idUser )")
	//@Query(value="SELECT * FROM Paiement WHERE code_fk_commande in(select id_Commande from Commande where type_Commande =1 and WEEK(date_Commande) =:week and MONTH(date_Commande) =:MONTH(date1) and YEAR(date_Commande) =:YEAR(date1) and code_fk_user=:idUser )",nativeQuery=true)
	public Page<Paiement> CommandesUserSemaine(@Param("week") Integer week,@Param("date1") String date1,@Param("idUser") String idUser,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public Page<Paiement> CommandesUserMois(@Param("date") String date,@Param("idUser") String idUser,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public Page<Paiement> CommandesUserAnnee(@Param("date") String date,@Param("idUser") String idUser,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public List<Paiement> finSemaineUser(@Param("date") String date,@Param("idUser") String idUser);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public List<Paiement> finMoisUser(@Param("date") String date,@Param("idUser") String idUser);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public List<Paiement> finAnneeUser(@Param("date") String date,@Param("idUser") String idUser);
	
	/***********************************/
	@Query("select c from Commande c where  c.statuts=0  AND c.typeCommande=1")
	public Page<Commande> CommandesCredit(Pageable pageable);
	@Query("select c from Commande c where c.idCommande=:x and c.statuts=0 AND c.typeCommande=1  ")
	public Page<Commande> CommandeCredit(@Param("x") String idCommande,Pageable pageable);
	/* end commande achat*/
	/*commande vente*/
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) = MONTH(NOW()) AND DAY(dateCommande) = DAY(NOW()) AND c.typeCommande=1 ")
	public Page <Commande> commandesNowVente(Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) =:mois AND DAY(dateCommande) =:jour AND c.typeCommande=1")
	public Page <Commande> commandesDayVente(@Param("mois") int mois,@Param("jour") int jour,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) =:annee AND MONTH(dateCommande) =:mois AND DAY(dateCommande) =:jour AND c.typeCommande=1")
	public Page <Commande> commandesJourVente(@Param("annee") int annee,@Param("mois") int mois,@Param("jour") int jour,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE YEAR(dateCommande) = YEAR(NOW()) AND MONTH(dateCommande) = MONTH(NOW()) AND DAY(dateCommande) =:jour AND c.typeCommande=1")
	public Page <Commande> commandesJourMntVente(@Param("jour") int jour,Pageable pageable);
		
	@Query("SELECT c FROM Commande c WHERE MONTH(dateCommande) =:mois AND YEAR(dateCommande) =:annee AND c.typeCommande=1")
	public Page <Commande> commandesMonthVente(@Param("annee") int annee,@Param("mois") int mois,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) = YEAR(NOW())  AND MONTH(dateCommande) =:mois AND c.typeCommande=1")
	public Page <Commande> commandesMoisVente(@Param("mois") int mois,Pageable pageable);
	
	@Query("SELECT c FROM Commande c WHERE  YEAR(dateCommande) =:annee AND c.typeCommande=1")
	public Page <Commande> commandesYearVente(@Param("annee") int annee,Pageable pageable);

	/*end commande vente*/
	// nombre des ventes d'année
	
	@Query("SELECT  YEAR(c.dateCommande) , COUNT(c.idCommande)  FROM Commande c GROUP BY YEAR(c.dateCommande)")
	public String [] NbrCommandeYear();
	
	/*SELECT YEAR(`date_commande`) AS ANNEE, COUNT(`id_commande`) AS NBR_VENTES FROM `commande` GROUP BY YEAR(`date_commande`)

*/
	@Query("SELECT  MONTH(c.dateCommande) , COUNT(c.idCommande)  FROM Commande c GROUP BY MONTH(c.dateCommande)")
	public String [] NbrCommandeMois();
	
	/*SELECT YEAR(`date_commande`) AS ANNEE, COUNT(`id_commande`) AS NBR_VENTES FROM `commande` GROUP BY YEAR(`date_commande`)

*/
	@Query("SELECT  m.article.idArticle , sum(m.quantite)  FROM Mouvement m where YEAR(m.dateMouvement)= YEAR(NOW()) and type_mouvement='sortie' GROUP by m.article.idArticle")
	public String [] bestSalesMonth();
	
	
	/* select code_fk_article,sum(quantite) from mouvement where YEAR(date_mouvement)= YEAR(NOW()) and type_mouvement='sortie' GROUP by code_fk_article

	 */
	@Query("SELECT  c.client.cin , COUNT(c.idCommande)   FROM Commande c where c.client.cin  is not null GROUP by c.client.cin")
	public String [] bestClient();
	@Query("SELECT  c.user.IdUser , COUNT(c.idCommande)   FROM Commande c where c.user.IdUser  is not null GROUP by c.user.IdUser")
	public String [] bestVendeur();
	@Query("SELECT  c.fournisseur.idFournisseur , COUNT(c.idCommande)   FROM Commande c where c.fournisseur.idFournisseur  is not null  GROUP by c.fournisseur.idFournisseur")
	public String [] bestFournisseur();
	//commandes credits d'un client 
	@Query("select c from Client  c where c.cin in (select co.client.cin from Commande co where  co.statuts=0  AND co.client.cin =:x)")
	public Page<Client> CommandesCreditClient(@Param("x") String cin ,Pageable pageable);
	//commandes credits d'un user 
	@Query("select c from Commande c where   c.user.IdUser =:x")
	public Page<User> CommandesCreditUser(@Param("x") String idUser ,Pageable pageable);
					
	// fin de la journée
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date )")
		public Page <Paiement> getFinJournee(@Param("date") String date,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser )")
	public Page <Paiement> getFinJourneeUser(@Param("date") String date,@Param("idUser") String idUser,Pageable pageable);

	// fin de la journée
		@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date )")
		public List <Paiement> getFinJournees(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser )")
		public List <Paiement> getFinJourneeUsers(@Param("date") String date,@Param("idUser") String idUser);

	//fin journee espece
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date )")
		public List <Paiement> getFinJourneesEspece(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser)")
		public List <Paiement> getFinJourneesEspeceUser(@Param("date") String date,@Param("idUser") String idUser);
	
	//fin journee credit
	@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser)")
		public List <Paiement> getFinJourneesCreditUser(@Param("date") String date,@Param("idUser") String idUser);
	@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date )")
	public List <Paiement> getFinJourneesCredit(@Param("date") String date);

	//fin journee cheque
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date )")
		public List <Paiement> getFinJourneesCheque(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and c.dateCommande =:date and c.user.IdUser =:idUser)")
	public List <Paiement> getFinJourneesChequeUser(@Param("date") String date,@Param("idUser") String idUser);
	//fin mois espece
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date )")
			public List <Paiement> getFinMoisEspece(@Param("date") String date);
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date and c.user.IdUser =:idUser)")
			public List <Paiement> getFinMoisEspeceUser(@Param("date") String date,@Param("idUser") String idUser);
		
		//fin mois credit
		@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date and c.user.IdUser =:idUser)")
			public List <Paiement> getFinMoisCreditUser(@Param("date") String date,@Param("idUser") String idUser);
		@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date )")
		public List <Paiement> getFinMoisCredit(@Param("date") String date);

		//fin journee cheque
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date )")
			public List <Paiement> getFinMoisCheque(@Param("date") String date);
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date and c.user.IdUser =:idUser)")
		public List <Paiement> getFinMoisChequeUser(@Param("date") String date,@Param("idUser") String idUser);
		//fin annee espece
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date )")
			public List <Paiement> getFinAnneeEspece(@Param("date") String date);
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date and c.user.IdUser =:idUser)")
			public List <Paiement> getFinAnneeEspeceUser(@Param("date") String date,@Param("idUser") String idUser);
				
		//fin mois credit
		@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date and c.user.IdUser =:idUser)")
			public List <Paiement> getFinAnneeCreditUser(@Param("date") String date,@Param("idUser") String idUser);
		@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date )")
			public List <Paiement> getFinAnneeCredit(@Param("date") String date);
		//fin journee cheque
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date )")
			public List <Paiement> getFinAnneeCheque(@Param("date") String date);
		@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date and c.user.IdUser =:idUser)")
			public List <Paiement> getFinAnneeChequeUser(@Param("date") String date,@Param("idUser") String idUser);
			
	//fin semaine espece
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date )")
		public List <Paiement> getFinSemaineEspece(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='espece' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public List <Paiement> getFinSemaineEspeceUser(@Param("date") String date,@Param("idUser") String idUser);

	//fin semaine credit & user
	@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date )")
		public List <Paiement> getFinSemaineCredit(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE (p.libelle='credit avec avance' or p.libelle='credit sans avance') and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date and c.user.IdUser =:idUser )")
	public List <Paiement> getFinSemaineCreditUser(@Param("date") String date,@Param("idUser") String idUser);
	//fin Semaine cheque & user
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date )")
		public List <Paiement> getFinSemaineCheque(@Param("date") String date);
	@Query("SELECT p FROM Paiement p  WHERE p.libelle='cheque' and p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date and c.user.IdUser =:idUser)")
	public List <Paiement> getFinSemaineChequeUser(@Param("date") String date,@Param("idUser") String idUser);
						
	
	
	//fin week
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date )")
		public Page <Paiement> getFinSemaine(@Param("date") String date,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and WEEK(c.dateCommande) =:date )")
	public List <Paiement> getFinSemaines(@Param("date") String date);

	//fin mois
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date )")
	public Page <Paiement> getFinMois(@Param("date") String date,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and MONTH(c.dateCommande) =:date )")
	public List <Paiement> getFinsMois(@Param("date") String date);

	//fin Annee
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date )")
	public Page <Paiement> getFinAnnee(@Param("date") String date,Pageable pageable);
	@Query("SELECT p FROM Paiement p  WHERE p.commande.idCommande in(select c.idCommande from Commande c where c.typeCommande =1 and YEAR(c.dateCommande) =:date )")
	public List <Paiement> getFinAnnees(@Param("date") String date);
	
	//sum commande by user 
	@Query("SELECT sum(c.montant) FROM Commande c  WHERE c.user.IdUser=:x")
		public double getMontantByUser(@Param("x") String IdUser);
		
	
	
}
