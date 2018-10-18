package org.manolo.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PaiementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class PaiementService {
	@Autowired
	private PaiementMetier paiementMetier;

	@RequestMapping(value = "/credit", method = RequestMethod.POST)
	public Paiement credit(
			@RequestParam String idCommande, 
			@RequestParam double montant,
			@RequestParam double avance) {
		System.out.println("test avance"+avance);
		return paiementMetier.credit(idCommande, montant, avance);
	}
	@RequestMapping(value = "/creditP", method = RequestMethod.POST)
	public Paiement creditP(
			@RequestParam String idCommande, 
			@RequestParam double montant,
			@RequestParam double avance) {
		System.out.println("test avance"+avance);
		return paiementMetier.creditP(idCommande, montant, avance);
	}
	@RequestMapping(value = "/credits", method = RequestMethod.POST)
	public Paiement credits(
			@RequestParam String idCommande, 
			@RequestParam double montant
			//@RequestParam double avance
			) {
		
		return paiementMetier.credits(idCommande, montant);
	}
	@RequestMapping(value = "/espece", method = RequestMethod.POST)
	public Paiement espece(
			@RequestParam String idCommande, 
			@RequestParam double montant) {
		return paiementMetier.espece(idCommande, montant);
	}
	@RequestMapping(value = "/especeP", method = RequestMethod.POST)
	public Paiement especeP(
			@RequestParam String idCommande, 
			@RequestParam double montant) {
		return paiementMetier.especeP(idCommande, montant);
	}
	@RequestMapping(value = "/cheque", method = RequestMethod.POST)
	public Paiement cheque(
			@RequestParam String idCommande,
			@RequestParam String datePaiement,
			@RequestParam double montant,
			@RequestParam MultipartFile cheque
			) {
		
		
		return paiementMetier.cheque(idCommande,datePaiement ,montant,cheque);
	}
	@RequestMapping(value = "/chequeP", method = RequestMethod.POST)
	public Paiement chequeP(
			@RequestParam String idCommande,
			@RequestParam String datePaiement,
			@RequestParam double montant,
			@RequestParam MultipartFile cheque
			) {
		
		
		return paiementMetier.chequeP(idCommande,datePaiement ,montant,cheque);
	}
	@RequestMapping(value = "/getpaiements", method = RequestMethod.GET)
	public List<Paiement> getPaiements(@RequestParam String idCommande) {
		return paiementMetier.getPaiements(idCommande);
	}
	@RequestMapping(value = "/alerteCheque", method = RequestMethod.GET)
	public List<Paiement> getAlerteCheque(@RequestParam String date ) {
		return paiementMetier.getAlerteCheque(date);
	}
}
