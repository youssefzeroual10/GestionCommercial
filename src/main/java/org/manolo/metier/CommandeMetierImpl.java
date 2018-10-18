package org.manolo.metier;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.manolo.dao.ClientRepository;
import org.manolo.dao.CommandeRepository;

import org.manolo.dao.FournisseurRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PromotionRepository;

import org.manolo.entities.Client;
import org.manolo.entities.Commande;

import org.manolo.entities.Fournisseur;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
@Transactional
public class CommandeMetierImpl  implements CommandeMetier{
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	MouvementRepository mouvementRepository;
	@Autowired
	PromotionRepository promotionRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ClientRepository clientRepository;
	@Value("${imagesDir}")
	private String  imagesDir ;
	@Override
	public List<Commande> getAllCommandes() {
		return commandeRepository.findAll() ;
	}
	@Override
	public List<Commande> getAllCommandesVentes() {
		return commandeRepository.findAll() ;
	}
	@Override
	public String [] getDateCommandes() {
		
		return commandeRepository.getDateCommandes();

	}
	@Override
	public Commande getCommande(String idCommande) {
		 Commande commande =commandeRepository.findOne(idCommande);
		if(commande==null) throw new RuntimeException("cette commande inexistante");
		return commande;
	}
	@Override
	public PageCommande getAllCommande(int size, int page) {
		Page<Commande> ops = commandeRepository.getAllCommande(new PageRequest(page, size));
		PageCommande pEt = new PageCommande();
		pEt.setCommande(ops.getContent());
		pEt.setNombreCommandes(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalCommandes((int)ops.getTotalElements());
		return pEt; 	
	}
	@Override
	public PageCommande getAllCommandeVente(int size, int page) {
		Page<Commande> ops = commandeRepository.getAllCommandeVente(new PageRequest(page, size));
		PageCommande pEt = new PageCommande();
		pEt.setCommande(ops.getContent());
		pEt.setNombreCommandes(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalCommandes((int)ops.getTotalElements());
		return pEt; 	
	}
	@Override
	public PageCommande CommandesByClientCredit(String idClient,int size, int page) {
		Page<Commande> opc = commandeRepository.CommandesByClientCredit(idClient, new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	
	@Override
	public PageClient CommandesCreditClient(String idClient,int size, int page) {
		Page<Client> opc = commandeRepository.CommandesCreditClient(idClient, new PageRequest(page, size));
		PageClient pCo = new PageClient();
		pCo.setClient(opc.getContent());
		pCo.setNombreClients(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalClients((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageUser CommandesCreditUser(String idUser,int size, int page) {
		Page<User> opc = commandeRepository.CommandesCreditUser(idUser, new PageRequest(page, size));
		PageUser pCo = new PageUser();
		pCo.setUser(opc.getContent());
		pCo.setNombreUsers(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalUsers((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande CommandesCredit(int size, int page) {
		Page<Commande> opc = commandeRepository.CommandesCredit(new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	//Achats
	@Override
	public PageCommande getCommandesNow(int size, int page) {
		Page<Commande> opc = commandeRepository.commandesNow(new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesMonth(int annee, int mois,int size, int page) {
		Page<Commande> opc = commandeRepository.commandesMonth( annee,  mois,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesYear(int annee,int size, int page) {
		Page<Commande> opc = commandeRepository.commandesYear(annee,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public Commande addCommandeEntree(String idCommande, String dateCommande, Long idFournisseur,double montant,MultipartFile bonCommande) {
		Commande commande= commandeRepository.findOne(idCommande);
		if(commande!=null) throw new RuntimeException("ce code commande existe deja");
		String fileName = null;
    	String repertoire = imagesDir+"/"+"bon Commande"+"/"+idCommande;
		if (bonCommande != null && bonCommande.getSize() >0) {
	       try {
	    	
	    	  fileName = bonCommande.getOriginalFilename();
	    	  File dir = new File (repertoire);
	    	  dir.mkdirs();
	          byte[] bytes = bonCommande.getBytes();
	          BufferedOutputStream buffStream = 
	              new BufferedOutputStream(new FileOutputStream(new File(repertoire+"/" + fileName)));
	          buffStream.write(bytes);
	              buffStream.close();
	            } catch (Exception e) {
	            	System.out.println( "You failed to upload " + fileName + ": " + e.getMessage());
	            }
        }
		Commande comm=new Commande();
		Fournisseur four = fournisseurRepository.findOne(idFournisseur);
		comm.setDateCommande(dateCommande);
		comm.setFournisseur(four);
		comm.setIdCommande(idCommande);
		comm.setTypeCommande(false);
		comm.setMontant(montant);
		comm.setBonCommande(bonCommande.getOriginalFilename());
		return commandeRepository.save(comm);
		
	}
	@Override
	public Commande addCommandeSortie(String idCommande, String idClient,User user) {
		if(idCommande ==null || idCommande.equals("undefined")) throw new RuntimeException("le code commande ne doit pas etre vide");
		if(idClient ==null ||  idClient.equals("undefined")) throw new RuntimeException("vous devez choisir un client");
		Commande commande= commandeRepository.findOne(idCommande);
		if(commande!=null) throw new RuntimeException("ce code commande existe deja");
		Commande comm=new Commande();
		Client client = clientRepository.findOne(idClient);
		comm.setClient(client);
		comm.setIdCommande(idCommande);
		comm.setUser(user);
		comm.setDateCommande(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		comm.setTypeCommande(true);
		
		return commandeRepository.save(comm);
	}
	@Override
	public String[] NbrCommandeYear() {
		return commandeRepository.NbrCommandeYear();
	}
	@Override
	public PageCommande getCommandesDay(int mois, int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesDay(mois,jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesJour(int annee, int mois, int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesJour(annee,mois,jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesJourMnt(int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesJourMnt(jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesMois(int mois, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesMois(mois,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	//end Achat
	//Ventes
	@Override
	public PageCommande getCommandesNowVente(int size, int page) {
		Page<Commande> opc = commandeRepository.commandesNowVente(new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesMonthVente(int annee, int mois,int size, int page) {
		Page<Commande> opc = commandeRepository.commandesMonthVente( annee,  mois,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesYearVente(int annee,int size, int page) {
		Page<Commande> opc = commandeRepository.commandesYearVente(annee,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	
	@Override
	public PageCommande getCommandesDayVente(int mois, int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesDayVente(mois,jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesJourVente(int annee, int mois, int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesJourVente(annee,mois,jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesJourMntVente(int jour, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesJourMntVente(jour,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageCommande getCommandesMoisVente(int mois, int size, int page) {
		Page<Commande> opc = commandeRepository.commandesMoisVente(mois,new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	//end ventes
	
	//fin journee
	@Override
	public PagePaiement getFinJournee(String date, int size, int page) {
		Page<Paiement> opc = commandeRepository.getFinJournee(date,new PageRequest(page, size));
		PagePaiement pCo = new PagePaiement();
		pCo.setPaiements(opc.getContent());
		pCo.setNombrePaiements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalPaiements((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PagePaiement CommandesByUser(String date,String idUser, int size, int page) {
		Page<Paiement> opc = commandeRepository.getFinJourneeUser(date,idUser,new PageRequest(page, size));
		PagePaiement pCo = new PagePaiement();
		pCo.setPaiements(opc.getContent());
		pCo.setNombrePaiements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalPaiements((int)opc.getTotalElements());
		return pCo;
	}
	@Override
	public List<Paiement> CommandesByUsers(String date,String idUser) {
		return commandeRepository.getFinJourneeUsers(date, idUser);
		 
	}
	@Override
	public List<Paiement> getFinJourneesEspece(String date) {
		return commandeRepository.getFinJourneesEspece(date);
		 
	}
	@Override
	public List<Paiement> getFinJourneesEspeceUser(String date,String idUser) {
		return commandeRepository.getFinJourneesEspeceUser(date,idUser);
		 
	}
	@Override
	public List<Paiement> getFinJourneesCredit(String date) {
		return commandeRepository.getFinJourneesCredit(date);
		 
	}
	@Override
	public List<Paiement> getFinJourneesCreditUser(String date,String idUser) {
		return commandeRepository.getFinJourneesCreditUser(date,idUser);
		 
	}
	@Override
	public List<Paiement> getFinJourneesCheque(String date) {
		return commandeRepository.getFinJourneesCheque(date);
		 
	}
	@Override
	public List<Paiement> getFinJourneesChequeUser(String date,String idUser) {
		return commandeRepository.getFinJourneesChequeUser(date,idUser);
		 
	}
	@Override
	public List<Paiement> getFinJournees(String date) {
		return commandeRepository.getFinJournees(date);
		 
	}
	//fin semaine
		@Override
		public PagePaiement getFinSemaine(String date, int size, int page) {
			Page<Paiement> opc = commandeRepository.getFinSemaine(date,new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			for (Paiement paiement : opc) {
				paiement.getCommande().getUser().setTotalCommande(getMontantByUser(paiement.getCommande().getUser().getIdUser()));
			}
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo; 
		}
		@Override
		public List<Paiement> getFinSemaines(String date) {
			return commandeRepository.getFinSemaines(date);
			 
		}
		//fin mois
		@Override
		public PagePaiement getFinMois(String date, int size, int page) {
			Page<Paiement> opc = commandeRepository.getFinMois(date,new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo; 
		}
		@Override
		public List<Paiement> getFinsMois(String date) {
			return commandeRepository.getFinsMois(date);
			 
		}
		//fin annee
		@Override
		public PagePaiement getFinAnnee(String date, int size, int page) {
			Page<Paiement> opc = commandeRepository.getFinAnnee(date,new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo; 
		}
		@Override
		public List<Paiement> getFinAnnees(String date) {
			return commandeRepository.getFinAnnees(date);
			 
		}
		@Override
		public double getMontantByUser(String IdUser) {
			return commandeRepository.getMontantByUser(IdUser);
		}
		@Override
		public PageCommande CommandesByUserCredit(String idUser, int size, int page) {
			Page<Commande> opc = commandeRepository.CommandesByUserCredit(idUser, new PageRequest(page, size));
			PageCommande pCo = new PageCommande();
			pCo.setCommande(opc.getContent());
			pCo.setNombreCommandes(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalCommandes((int)opc.getTotalElements());
			return pCo;
			
			
		}
		@Override
		public PagePaiement CommandesUser(String date,String idUser, int size, int page) {
			Page<Paiement> opc = commandeRepository.CommandesUser(date,idUser, new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo;						
		}
		@Override
		public PagePaiement CommandesUserSemaine(Integer week,String date1,String idUser, int size, int page) {
			
			Page<Paiement> opc = commandeRepository.CommandesUserSemaine(week,date1,idUser, new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo;						
		}
		@Override
		public PagePaiement CommandesUserMois(String date,String idUser, int size, int page) {
			Page<Paiement> opc = commandeRepository.CommandesUserMois(date,idUser, new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo;						
		}
		@Override
		public PagePaiement CommandesUserAnnee(String date,String idUser, int size, int page) {
			Page<Paiement> opc = commandeRepository.CommandesUserAnnee(date,idUser, new PageRequest(page, size));
			PagePaiement pCo = new PagePaiement();
			pCo.setPaiements(opc.getContent());
			pCo.setNombrePaiements(opc.getNumberOfElements());
			pCo.setPage(opc.getNumber());
			pCo.setTotalPages(opc.getTotalPages());
			pCo.setTotalPaiements((int)opc.getTotalElements());
			return pCo;						
		}
		@Override
		public String[] NbrCommandeMois() {
			return commandeRepository.NbrCommandeMois();
		}
		@Override
		public String [] bestSalesMonth() {
			return commandeRepository.bestSalesMonth();
		}
		@Override
		public String [] bestClient() {
			return commandeRepository.bestClient();
		}
		@Override
		public String [] bestFournisseur() {
			return commandeRepository.bestFournisseur();
		}
		@Override
		public String [] bestVendeur() {
			return commandeRepository.bestVendeur();
		}
		@Override
		public List<Paiement> getFinSemaineEspece(String date) {
			return commandeRepository.getFinSemaineEspece(date);
		}
		@Override
		public List<Paiement> getFinSemaineEspeceUser(String date,String idUser) {
			return commandeRepository.getFinSemaineEspeceUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinSemaineCredit(String date) {
			return commandeRepository.getFinSemaineCredit(date);
		}
		@Override
		public List<Paiement> getFinSemaineCreditUser(String date,String idUser) {
			return commandeRepository.getFinSemaineCreditUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinSemaineCheque(String date) {
			return commandeRepository.getFinSemaineCheque(date);
		}
		@Override
		public List<Paiement> getFinSemaineChequeUser(String date,String idUser) {
			return commandeRepository.getFinSemaineChequeUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinMoisEspece(String date) {
			return commandeRepository.getFinMoisEspece(date);
		}
		@Override
		public List<Paiement> getFinMoisEspeceUser(String date,String idUser) {
			return commandeRepository.getFinMoisEspeceUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinMoisCredit(String date) {
			return commandeRepository.getFinMoisCredit(date);
		}
		@Override
		public List<Paiement> getFinMoisCreditUser(String date,String idUser) {
			return commandeRepository.getFinMoisCreditUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinMoisCheque(String date) {
			return commandeRepository.getFinMoisCheque(date);
		}
		@Override
		public List<Paiement> getFinMoisChequeUser(String date,String idUser) {
			return commandeRepository.getFinMoisChequeUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinAnneeEspece(String date) {
			return commandeRepository.getFinAnneeEspece(date);
		}
		@Override
		public List<Paiement> getFinAnneeEspeceUser(String date,String idUser) {
			return commandeRepository.getFinAnneeEspeceUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinAnneeCredit(String date) {
			return commandeRepository.getFinAnneeCredit(date);
		}
		@Override
		public List<Paiement> getFinAnneeCreditUser(String date,String idUser) {
			return commandeRepository.getFinAnneeCreditUser(date,idUser);
		}
		@Override
		public List<Paiement> getFinAnneeCheque(String date) {
			return commandeRepository.getFinAnneeCheque(date);
		}
		@Override
		public List<Paiement> getFinAnneeChequeUser(String date,String idUser) {
			return commandeRepository.getFinAnneeChequeUser(date,idUser);
		}
		@Override
		public List<Paiement> finUserSemaine(String date, String idUser) {
			return commandeRepository.finSemaineUser(date, idUser);
		}
		@Override
		public List<Paiement> finUserMois(String date, String idUser) {
			return commandeRepository.finMoisUser(date, idUser);
		}
		@Override
		public List<Paiement> finUserAnnee(String date, String idUser) {
			return commandeRepository.finAnneeUser(date, idUser);
		}
		
}
