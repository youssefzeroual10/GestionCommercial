package org.manolo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manolo.entities.Etat;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.entities.User;
import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.MouvementMetier;
import org.manolo.metier.PageClient;
import org.manolo.metier.PageCommande;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.CommandeMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PagePaiement;
import org.manolo.metier.PageUser;
import org.manolo.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@RestController
public class CommandeService {
	@Autowired
	private CommandeMetier commandeMetier;
	@Autowired
	private UserMetier userMetier;
	@Autowired
	private MouvementMetier mouvementMetier;

	@RequestMapping(value = "/commandes", method = RequestMethod.GET)
	public List<Commande> getAllCommandes() {
		return commandeMetier.getAllCommandes();
	}
	@RequestMapping(value = "/commandesventes", method = RequestMethod.GET)
	public List<Commande> getAllCommandesVentes() {
		return commandeMetier.getAllCommandesVentes();
	}
	@RequestMapping(value = "/getdatecommandes", method = RequestMethod.GET)
	public String [] getDateCommandes() {
		return commandeMetier.getDateCommandes();
		
	}
	@RequestMapping(value = "/getcommande", method = RequestMethod.GET)
	public Commande getCommande(@RequestParam String idCommande) {
		return commandeMetier.getCommande(idCommande);
	}
	@RequestMapping(value = "/getcommandes", method = RequestMethod.GET)
	public PageCommande getAllCommande(@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getAllCommande(size, page);
	}
	@RequestMapping(value = "/getcommandesVente", method = RequestMethod.GET)
	public PageCommande getAllCommandeVente(@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getAllCommandeVente(size, page);
	}
	//Achat
	@RequestMapping(value = "/commandesnow", method = RequestMethod.GET)
	public PageCommande getCommandesNow(@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesNow(size, page);
	}
	@RequestMapping(value = "/commandesdm", method = RequestMethod.GET)
	public PageCommande getCommandeDay(@RequestParam int mois,@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesDay(mois,jour,size, page);
	}
	@RequestMapping(value = "/commandesdmy", method = RequestMethod.GET)
	public PageCommande getCommandeJour(@RequestParam int annee,@RequestParam int mois,@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesJour(annee,mois,jour,size, page);
	}
	@RequestMapping(value = "/commandesjour", method = RequestMethod.GET)
	public PageCommande getCommandeJourMnt(@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesJourMnt(jour,size, page);
	}
	@RequestMapping(value = "/commandesmois", method = RequestMethod.GET)
	public PageCommande getCommandesMois(@RequestParam int mois,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesMois(mois,size, page);
	}
	@RequestMapping(value = "/commandesmonth", method = RequestMethod.GET)
	public PageCommande getCommandesMonth(@RequestParam int annee,@RequestParam int mois,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesMonth(annee,mois,size, page);
	}
	@RequestMapping(value = "/commandesyear", method = RequestMethod.GET)
	public PageCommande getCommandesYear(@RequestParam int annee,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesYear(annee,size, page);
	}
	//end achat
	//Ventes
	@RequestMapping(value = "/commandesnowvente", method = RequestMethod.GET)
	public PageCommande getCommandesNowVente(@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesNowVente(size, page);
	}
	@RequestMapping(value = "/commandesdmvente", method = RequestMethod.GET)
	public PageCommande getCommandeDayVente(@RequestParam int mois,@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesDayVente(mois,jour,size, page);
	}
	@RequestMapping(value = "/commandesdmyvente", method = RequestMethod.GET)
	public PageCommande getCommandeJourVente(@RequestParam int annee,@RequestParam int mois,@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesJourVente(annee,mois,jour,size, page);
	}
	@RequestMapping(value = "/commandesjourvente", method = RequestMethod.GET)
	public PageCommande getCommandeJourMntVente(@RequestParam int jour,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesJourMntVente(jour,size, page);
	}
	@RequestMapping(value = "/commandesmoisvente", method = RequestMethod.GET)
	public PageCommande getCommandesMoisVente(@RequestParam int mois,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesMoisVente(mois,size, page);
	}
	@RequestMapping(value = "/commandesmonthvente", method = RequestMethod.GET)
	public PageCommande getCommandesMonthVente(@RequestParam int annee,@RequestParam int mois,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesMonthVente(annee,mois,size, page);
	}
	@RequestMapping(value = "/commandesyearvente", method = RequestMethod.GET)
	public PageCommande getCommandesYearVente(@RequestParam int annee,@RequestParam int size, @RequestParam int page) {
		return commandeMetier.getCommandesYearVente(annee,size, page);
	}
	// end ventes
	@RequestMapping(value = "/commandesbyclientcredit", method = RequestMethod.GET)
	public PageCommande CommandesByClientCredit(@RequestParam String idClient,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesByClientCredit(idClient, size, page);
	}
	@RequestMapping(value = "/commandesbyclientuser", method = RequestMethod.GET)
	public PageCommande CommandesByClientUser(@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		
		return commandeMetier.CommandesByUserCredit(idUser, size, page);
	}
	@RequestMapping(value = "/commandesuser", method = RequestMethod.GET)
	public PagePaiement CommandesUser(@RequestParam String date,@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesUser(date,idUser, size, page);
	}
	@RequestMapping(value = "/commandesusersemaine", method = RequestMethod.GET)
	public PagePaiement CommandesUserSemaine(@RequestParam String date1,@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		String input = date1;
		Integer week=0;
		Integer month=0;
		Integer year=0;
		String format = "yyyyMMdd";
		String mois = "yyyyMMdd";
		String annee = "yyyy";
		Integer imois=0;
		Integer iannee=0;
		SimpleDateFormat df = new SimpleDateFormat(format);
		SimpleDateFormat dfMois = new SimpleDateFormat(mois);
		SimpleDateFormat dfAnnee = new SimpleDateFormat(annee);
		Date date;
		Date dmois = new Date();
		Date dannee =new Date();
		try {
			date = df.parse(input);
			dmois = dfMois.parse(input);
			dannee = dfAnnee.parse(input);
			Calendar cal = Calendar.getInstance();
			Calendar calMois = Calendar.getInstance();
			Calendar calYear = Calendar.getInstance();
			cal.setTime(date);
			calMois.setTime(dmois);
			calYear.setTime(dannee);
			month = calMois.get(Calendar.MONTH)+1;
			year = calYear.get(Calendar.YEAR);
			 week = cal.get(Calendar.WEEK_OF_YEAR);
			 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandeMetier.CommandesUserSemaine(week,date1,idUser, size, page);
	}
	@RequestMapping(value = "/commandesusermois", method = RequestMethod.GET)
	public PagePaiement CommandesUserMois(@RequestParam String date,@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesUserMois(date,idUser, size, page);
	}
	@RequestMapping(value = "/commandesuserannee", method = RequestMethod.GET)
	public PagePaiement CommandesUserAnnee(@RequestParam String date,@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesUserAnnee(date,idUser, size, page);
	}
	@RequestMapping(value = "/commandescredit", method = RequestMethod.GET)
	public PageCommande CommandesCredit(@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesCredit(size, page);
	}
	@RequestMapping(value = "/commandeentree", method = RequestMethod.POST)
	public Commande addCommandeEntree(
			@RequestParam String idCommande, 
			@RequestParam String dateCommande,
			@RequestParam Long idFournisseur,
			@RequestParam double montant,
			@RequestParam MultipartFile bonCommande) {
		return commandeMetier.addCommandeEntree(idCommande, dateCommande, idFournisseur, montant,bonCommande);
	}
	@RequestMapping(value = "/commandesortie", method = RequestMethod.POST)
	public Commande addCommandeSortie(HttpServletRequest httpServletRequest,String idCommande,  String idClient) {
		HttpSession  httpSession= httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		User user  = userMetier.getUser(username);
		
		return commandeMetier.addCommandeSortie(idCommande, idClient,user);
	}
	
	@RequestMapping(value = "/commande.pdf", method = RequestMethod.GET)
	public @ResponseBody void commandePdf (@RequestParam String idCommande , HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/commande.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Commande> commandes = new ArrayList<Commande>();
			/*List<Mouvement> mouvements = mouvementMetier.getMouvementsByCommande(idCommande);
			for (Mouvement mouvement : mouvements) {
				System.out.println("id"+mouvement.getCommande().getIdCommande());
			}
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(mouvements);
			*/
			Commande commande = commandeMetier.getCommande(idCommande);
			commandes.add(commande);
			JRDataSource datasource = new JRBeanCollectionDataSource(commandes);
			//parametreMap.put("datasource",JRDataSource);
			parametreMap.put("datasource", datasource);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, datasource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=commande.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/nbrcommandeyear", method = RequestMethod.GET)
	public String[] NbrCommandeYear() {
		return commandeMetier.NbrCommandeYear();
	}
	@RequestMapping(value = "/nbrcommandemois", method = RequestMethod.GET)
	public String[] NbrCommandeMois() {
		return commandeMetier.NbrCommandeMois();
	}
	@RequestMapping(value = "/bestSalesMonth", method = RequestMethod.GET)
	public String [] bestSalesMonth() {
		return commandeMetier.bestSalesMonth();
	}
	@RequestMapping(value = "/bestClient", method = RequestMethod.GET)
	public String [] bestClient() {
		return commandeMetier.bestClient();
	}
	@RequestMapping(value = "/bestVendeur", method = RequestMethod.GET)
	public String [] bestVendeur() {
		return commandeMetier.bestVendeur();
	}
	@RequestMapping(value = "/bestFournisseur", method = RequestMethod.GET)
	public String [] bestFournisseur() {
		return commandeMetier.bestFournisseur();
	}
	@RequestMapping(value = "/CommandesByUserCredit", method = RequestMethod.GET)
	public PageUser CommandesByUserCredit(@RequestParam String idUser,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesCreditUser(idUser, size, page);
	}
	@RequestMapping(value = "/CommandesCreditClient", method = RequestMethod.GET)
	public PageClient CommandesCreditClient( @RequestParam String idClient,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.CommandesCreditClient(idClient, size, page);
	}
	@RequestMapping(value = "/getFinJournee", method = RequestMethod.GET)
	public PagePaiement getFinJournee( @RequestParam String date,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.getFinJournee(date, size, page);
	}
	@RequestMapping(value = "/getFinSemaine", method = RequestMethod.GET)
	public PagePaiement getFinSemaine( @RequestParam String date,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.getFinSemaine(date, size, page);
	}
	@RequestMapping(value = "/getFinMois", method = RequestMethod.GET)
	public PagePaiement getFinMois( @RequestParam String date,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.getFinMois(date, size, page);
	}
	@RequestMapping(value = "/getFinAnnee", method = RequestMethod.GET)
	public PagePaiement getFinAnnee( @RequestParam String date,@RequestParam int size,@RequestParam int page) {
		return commandeMetier.getFinAnnee(date, size, page);
	}
	@RequestMapping(value = "/finJournee.pdf", method = RequestMethod.GET)
	public @ResponseBody void finPdf (@RequestParam String date,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FJournee.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			System.out.println(date);
			List<Paiement> paiements = commandeMetier.getFinJournees(date);
			List<Paiement> paiementsEscpece = commandeMetier.getFinJourneesEspece(date);
			List<Paiement> paiementsCredit = commandeMetier.getFinJourneesCredit(date);
			List<Paiement> paiementsCheque = commandeMetier.getFinJourneesCheque(date);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap,JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findejournee.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finJourneeUser.pdf", method = RequestMethod.GET)
	public @ResponseBody void finUserPdf (@RequestParam String date,@RequestParam String idUser,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FjUser.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.CommandesByUsers(date,idUser);
			List<Paiement> paiementsEscpece = commandeMetier.getFinJourneesEspeceUser(date,idUser);
			List<Paiement> paiementsCredit = commandeMetier.getFinJourneesCreditUser(date,idUser);
			List<Paiement> paiementsCheque = commandeMetier.getFinJourneesChequeUser(date,idUser);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("user",userMetier.getUser(idUser).getNom()+" "+userMetier.getUser(idUser).getPrenom());
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap,JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findejourneeUser.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finSemaineUser.pdf", method = RequestMethod.GET)
	public @ResponseBody void finSemaineUserPdf (@RequestParam String date,@RequestParam String idUser,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FSemaineUser.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			System.out.println(date);
			List<Paiement> paiements = commandeMetier.finUserSemaine(date, idUser);
			List<Paiement> paiementsEscpece = commandeMetier.getFinSemaineEspeceUser(date, idUser);
			List<Paiement> paiementsCredit = commandeMetier.getFinSemaineCreditUser(date, idUser);
			List<Paiement> paiementsCheque = commandeMetier.getFinSemaineChequeUser(date, idUser);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findesemaineuser.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finSemaine.pdf", method = RequestMethod.GET)
	public @ResponseBody void finSemainePdf (@RequestParam String date,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FSemaine.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.getFinSemaines(date);
			List<Paiement> paiementsEscpece = commandeMetier.getFinSemaineEspece(date);
			List<Paiement> paiementsCredit = commandeMetier.getFinSemaineCredit(date);
			List<Paiement> paiementsCheque = commandeMetier.getFinSemaineCheque(date);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findesemaine.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finMoisUser.pdf", method = RequestMethod.GET)
	public @ResponseBody void finMoisUserPdf (@RequestParam String date,@RequestParam String idUser,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FMoisUser.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.finUserSemaine(date, idUser);
			List<Paiement> paiementsEscpece = commandeMetier.getFinSemaineEspeceUser(date, idUser);
			List<Paiement> paiementsCredit = commandeMetier.getFinSemaineCreditUser(date, idUser);
			List<Paiement> paiementsCheque = commandeMetier.getFinSemaineChequeUser(date, idUser);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findemoisuser.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finMois.pdf", method = RequestMethod.GET)
	public @ResponseBody void finMoisPdf (@RequestParam String date,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FMois.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.getFinsMois(date);
			List<Paiement> paiementsEscpece = commandeMetier.getFinMoisEspece(date);
			List<Paiement> paiementsCredit = commandeMetier.getFinMoisCredit(date);
			List<Paiement> paiementsCheque = commandeMetier.getFinMoisCheque(date);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=findemois.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finAnnee.pdf", method = RequestMethod.GET)
	public @ResponseBody void finAnneePdf (@RequestParam String date,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FJournee.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.getFinAnnees(date);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			List<Paiement> paiementsEscpece = commandeMetier.getFinAnneeEspece(date);
			List<Paiement> paiementsCredit = commandeMetier.getFinAnneeCredit(date);
			List<Paiement> paiementsCheque = commandeMetier.getFinAnneeCheque(date);
			
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=finAnnee.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/finAnneeUser.pdf", method = RequestMethod.GET)
	public @ResponseBody void finAnneeUserPdf (@RequestParam String date,@RequestParam String idUser,HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/FJourneeUser.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Paiement> paiements = commandeMetier.finUserAnnee(date, idUser);
			List<Paiement> paiementsEscpece = commandeMetier.getFinAnneeEspeceUser(date, idUser);
			List<Paiement> paiementsCredit = commandeMetier.getFinAnneeCreditUser(date, idUser);
			List<Paiement> paiementsCheque = commandeMetier.getFinAnneeChequeUser(date, idUser);
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(paiements);
			double sumEspece=0;
			double sumCheque=0;
			double sumCredit=0;
			for (Paiement espece : paiementsEscpece) {
				sumEspece = sumEspece+ espece.getCommande().getMontant();
			}
			for (Paiement cheque : paiementsCheque) {
				sumCheque = sumCheque+ cheque.getCommande().getMontant();
			}
			for (Paiement credit : paiementsCredit) {
				sumCredit = sumCredit+ credit.getCommande().getMontant();
			}
			parametreMap.put("paiements",paiements);
			parametreMap.put("date",date);
			parametreMap.put("credit",sumCredit);
			parametreMap.put("cheque",sumCheque);
			parametreMap.put("espece",sumEspece);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=finAnneeUser.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
