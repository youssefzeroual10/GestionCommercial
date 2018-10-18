//package org.manolo.service;
//
//import java.util.List;
//
//import org.manolo.entities.Etat;
//import org.manolo.entities.Fournisseur;
//import org.manolo.entities.Quartier;
//import org.manolo.metier.EtatMetier;
//import org.manolo.metier.FournisseurMetier;
//import org.manolo.metier.PageEtat;
//import org.manolo.metier.PageFournisseur;
//import org.manolo.metier.PageQuartier;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class ChauffeurService {
//	@Autowired
//	private FournisseurMetier fournisseurMetier;
//
//	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
//	public List<Fournisseur> getAllFournisseurs() {
//		return fournisseurMetier.getAllFournisseurs();
//	}
//	@RequestMapping(value = "/fournisseurs", method = RequestMethod.PUT)
//	public Fournisseur updateFournisseur( Fournisseur fournisseur ) {
//		return fournisseurMetier.updateFournisseur(fournisseur);
//	}
//	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.DELETE)
//	public void deleteFournisseur(@PathVariable Long id) {
//		fournisseurMetier.deleteFournisseur(id);
//	}
///*	@RequestMapping(value = "/quartiers/{id}", method = RequestMethod.GET)
//	public Fournisseur getFournisseur(@PathVariable Long id) {
//		return fournisseurMetier.getFournisseur(id);
//	}*/
//
//	@RequestMapping(value = "/getFournisseurs", method = RequestMethod.GET)
//	public PageFournisseur getAllFournisseurs(@RequestParam int size,@RequestParam int page) {
//		return fournisseurMetier.getAllFournisseur(size, page);
//	}
//	
//	/*public PageQuartier getByQuartiersMotCle(String motCle, int size, int page) {
//		return fournisseurMetier.getByQuartiersMotCle(motCle, size, page);
//	}*/
//	
//}
