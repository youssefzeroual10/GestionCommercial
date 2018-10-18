package org.manolo.metier;

import java.util.List;
import org.manolo.entities.Commande;

import org.manolo.entities.Paiement;
import org.manolo.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface CommandeMetier {
	public List<Commande> getAllCommandes();
	public List<Commande> getAllCommandesVentes();
	public Commande getCommande(String idCommande);
	public PageCommande getAllCommande(int size,int page);
	public PageCommande getAllCommandeVente(int size,int page);

	public String [] getDateCommandes();
	public PageCommande CommandesByClientCredit(String idClient,int size,int page);
	public PageCommande CommandesByUserCredit(String idUser,int size,int page);
	public PagePaiement CommandesUser(String date,String idUser,int size,int page);
	public PagePaiement CommandesUserSemaine(Integer week,String date1,String idUser,int size,int page);
	public PagePaiement CommandesUserMois(String date,String idUser,int size,int page);
	public PagePaiement CommandesUserAnnee(String date,String idUser,int size,int page);
	public List<Paiement> finUserSemaine(String date,String idUser);
	public List<Paiement> finUserMois(String date,String idUser);
	public List<Paiement> finUserAnnee(String date,String idUser);
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
	public List<Paiement> getFinJourneesEspeceUser(String date,String idUser);
	public List<Paiement> getFinJourneesCreditUser(String date,String idUser);
	public List<Paiement> getFinJourneesChequeUser(String date,String idUser);

	public List<Paiement> getFinSemaineEspece(String date);
	public List<Paiement> getFinSemaineEspeceUser(String date,String idUser);
	public List<Paiement> getFinSemaineCredit(String date);
	public List<Paiement> getFinSemaineCreditUser(String date,String idUser);
	public List<Paiement> getFinSemaineCheque(String date);
	public List<Paiement> getFinSemaineChequeUser(String date,String idUser);
	
	public List<Paiement> getFinMoisEspece(String date);
	public List<Paiement> getFinMoisEspeceUser(String date,String idUser);
	public List<Paiement> getFinMoisCredit(String date);
	public List<Paiement> getFinMoisCreditUser(String date,String idUser);
	public List<Paiement> getFinMoisCheque(String date);
	public List<Paiement> getFinMoisChequeUser(String date,String idUser);
	
	public List<Paiement> getFinAnneeEspece(String date);
	public List<Paiement> getFinAnneeEspeceUser(String date,String idUser);
	public List<Paiement> getFinAnneeCredit(String date);
	public List<Paiement> getFinAnneeCreditUser(String date,String idUser);
	public List<Paiement> getFinAnneeCheque(String date);
	public List<Paiement> getFinAnneeChequeUser(String date,String idUser);
	
	public PagePaiement getFinSemaine(String date,int size,int page);
	public List<Paiement> getFinSemaines(String date);
	public PagePaiement getFinMois(String date,int size,int page);
	public List<Paiement> getFinsMois(String date);
	public PagePaiement getFinAnnee(String date,int size,int page);
	public List<Paiement> getFinAnnees(String date);
	public double getMontantByUser(String IdUser);
	
}
