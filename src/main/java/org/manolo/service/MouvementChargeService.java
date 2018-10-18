package org.manolo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.manolo.entities.Commande;
import org.manolo.entities.Entree;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;
import org.manolo.metier.MouvementChargeMetier;
import org.manolo.metier.MouvementMetier;
import org.manolo.metier.PageMouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MouvementChargeService {
	@Autowired
	private MouvementChargeMetier mouvementchargeMetier;
	
	@RequestMapping(value = "/charger", method = RequestMethod.PUT)
	public boolean chargerMouvement(
			@RequestParam Long article,
			@RequestParam Long idChargeCamion,
			@RequestParam String IdUser,
			@RequestParam int quantite,
			HttpServletRequest httpServletRequest) {
		return mouvementchargeMetier.charger(httpServletRequest,IdUser,quantite,article,idChargeCamion);
		}
	/*
	@RequestMapping(value = "/sortir", method = RequestMethod.PUT)
	public boolean sortirMouvement(@RequestParam Long idMouvement ,@RequestParam String idCommande) {
		
		return mouvementMetier.sortir(idMouvement,idCommande);
	}
	@RequestMapping(value = "/sortir", method = RequestMethod.POST)
	public Mouvement addSortie( 
			@RequestParam Long article,
			@RequestParam Long prixVente,
			@RequestParam int quantite,
			@RequestParam String idCommande
			) {
		if(article.toString().equals("null") ) throw new RuntimeException("vous devez choisir un article");	
		if(prixVente.toString().equals("null") ) throw new RuntimeException("vous devez choisir le prix de vente");
		if(idCommande == "0" )  throw new RuntimeException("code commande est incorrecte");
		if(quantite<=0) throw new RuntimeException("la quantite doit supperieur a zero");

		return mouvementMetier.addSortie(article,prixVente,quantite,idCommande);
	}
	@RequestMapping(value = "/defectueuses", method = RequestMethod.POST)
	public boolean defectuerMouvement( @RequestParam String libelle,@RequestParam Long article,@RequestParam int quantite) {
		return mouvementMetier.defectuer(libelle,article,quantite);
	}

	@RequestMapping(value = "/Mouvements/{id}", method = RequestMethod.DELETE)
	public void deleteMouvement(@PathVariable Long id) {
		mouvementMetier.deleteMouvement(id);
		
	}
	@RequestMapping(value = "/entrees", method = RequestMethod.GET)
	public PageMouvement getListEntree( @RequestParam Long id,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getListEntree(id, size, page);
	}
	@RequestMapping(value = "/sorties", method = RequestMethod.GET)
	public PageMouvement getListSortie(  @RequestParam Long id,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getListSortie(id, size, page);
	}
	@RequestMapping(value = "/sortiesCommande", method = RequestMethod.GET)
	public PageMouvement sortiesCommande(@RequestParam String idCommande,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getMouvementsByCommandes(idCommande, size, page);
	}
	@RequestMapping(value = "/entreesCommande", method = RequestMethod.GET)
	public PageMouvement entreesCommande(@RequestParam String idCommande,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getMouvementsByCommandes(idCommande, size, page);
	}
	@RequestMapping(value = "/defectueuses", method = RequestMethod.GET)
	public PageMouvement getListDefectueuse( @RequestParam Long id,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getListDefectueuse(id, size, page);
	}
	@RequestMapping(value = "/cadeau", method = RequestMethod.GET)
	public PageMouvement getListCadeau( @RequestParam Long id,@RequestParam int size,@RequestParam int page) {
		return mouvementMetier.getListCadeau(id, size, page);
	}
	@RequestMapping(value = "/perime", method = RequestMethod.GET)
	public PageMouvement getListPerime(@RequestParam String date , @RequestParam int size, @RequestParam int page) {
		return mouvementMetier.getListPerime(date, size, page);
	}
	@RequestMapping(value = "/perimes", method = RequestMethod.GET)
	public List<Mouvement> getListPerimes(@RequestParam String date ) {
		return mouvementMetier.getListPerimes(date);
	}
	/*@RequestMapping(value = "/perDef", method = RequestMethod.GET)
	public void setPerimeAuxDefect() {
		mouvementMetier.setPerimeAuxDefect();
	}*/
	/*
	@RequestMapping(value = "/sortiesinvalide", method = RequestMethod.GET)
	public List<Sortie> getSortieInvalide() {
		return mouvementMetier.getSortieInvalide();
	}
	@RequestMapping(value = "/mouvements/{idMouvement}", method = RequestMethod.GET)
	public Mouvement getMouvement(@PathVariable Long idMouvement) {
		return mouvementMetier.getMouvement(idMouvement);
	}
	@RequestMapping(value = "/mouvements", method = RequestMethod.PUT)
	public Mouvement updateMouvement(
			@RequestParam Long idMouvement,
			@RequestParam Long idArticle, 
			@RequestParam Long prixVente,
			@RequestParam int quantite
			) {
		return mouvementMetier.updateMouvement(idMouvement,idArticle,prixVente,quantite);
	}
	
	@RequestMapping(value = "/getcadeau", method = RequestMethod.GET)
	public List<Promotion> ListCadeau(@RequestParam String idCommande) {
		return mouvementMetier.ListCadeau(idCommande);
		
	}
	@RequestMapping(value = "/promo", method = RequestMethod.GET)
	public List<Promotion> getPromotions(Long idArticle) {
		return mouvementMetier.getPromotions((long) 1);
	}
	*/
	
	
}
