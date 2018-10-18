package org.manolo.metier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.manolo.entities.ChargeCamion;
import org.manolo.entities.User;

public interface ChargeCamionMetier {
	public List<ChargeCamion> getAllChargesCamion();
	public List<ChargeCamion> getAllChargesCamionEntree();
	//public List<ChargeCamion> getAllChargesCamionEntree();
	public ChargeCamion getCharge(Long idCharge);
	public PageChargeCamion getAllChargesCamionEntree(int size,int page);
	public PageChargeCamion getAllchargesSortie(int size,int page);
	public ChargeCamion addChargeCamionSortie(Long idCharge,String idClient,User user);
	public ChargeCamion addChargeCamionEntree(HttpServletRequest httpServletRequest,User user);
	
/*	public String [] getDateCommandes();
	public PageCommande CommandesByClientCredit(String idClient,int size,int page);
	public PageCommande CommandesByUserCredit(String idUser,int size,int page);
	public PagePaiement CommandesByUser(String date,String idUser,int size,int page);
	public List<Paiement> CommandesByUsers(String date,String idUser);
	public PageCommande CommandesCredit(int size,int page);
	public Commande addCommandeSortie(String idCommande,String idClient,User user);
	public Commande addCommandeEntree(String idCommande,String dateCommande,Long idFournisseur,double montant,MultipartFile bonCommande);
	public String [] NbrCommandeYear();
	public String [] NbrCommandeMois();
	public String[] bestSalesMonth();
	public String[] bestClient();
	public String[] bestFournisseur();
	public String[] bestVendeur();
	public PageCommande getCommandesNow(int size, int page);
	public PageCommande getCommandesDay(int mois, int jour,int size, int page);
	public PageCommande getCommandesJour(int annee,int mois, int jour,int size, int page);
	public PageCommande getCommandesJourMnt(int jour,int size, int page);

	public PageCommande getCommandesMonth(int annee, int mois,int size, int page);
	public PageCommande getCommandesMois(int mois,int size, int page);
	public PageCommande getCommandesYear(int annee,int size, int page);
	
	public PageCommande getCommandesNowVente(int size, int page);
	public PageCommande getCommandesDayVente(int mois, int jour,int size, int page);
	public PageCommande getCommandesJourVente(int annee,int mois, int jour,int size, int page);
	public PageCommande getCommandesJourMntVente(int jour,int size, int page);

	public PageCommande getCommandesMonthVente(int annee, int mois,int size, int page);
	public PageCommande getCommandesMoisVente(int mois,int size, int page);
	public PageCommande getCommandesYearVente(int annee,int size, int page);
	
	public PageClient CommandesCreditClient(String idClient,int size,int page);
	public PageUser CommandesCreditUser(String idUser,int size,int page);
	public PagePaiement getFinJournee(String date,int size,int page);
	public List<Paiement> getFinJournees(String date);
	public List<Paiement> getFinJourneesEspece(String date);
	public List<Paiement> getFinJourneesCredit(String date);
	public List<Paiement> getFinJourneesCheque(String date);

	public List<Paiement> getFinSemaineEspece(String date);
	public List<Paiement> getFinSemaineCredit(String date);
	public List<Paiement> getFinSemaineCheque(String date);
	
	public PagePaiement getFinSemaine(String date,int size,int page);
	public List<Paiement> getFinSemaines(String date);
	public PagePaiement getFinMois(String date,int size,int page);
	public List<Paiement> getFinsMois(String date);
	public PagePaiement getFinAnnee(String date,int size,int page);
	public List<Paiement> getFinAnnees(String date);
	public double getMontantByUser(String IdUser);
	*/
}
