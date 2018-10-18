package org.manolo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.manolo.entities.Vehicule;
import org.manolo.entities.Article;
import org.manolo.entities.Vehicule;
import org.manolo.metier.VehiculeMetier;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.PageVehicule;
import org.manolo.metier.PageArticle;
import org.manolo.metier.VehiculeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class VehiculeService {
	@Autowired
	private VehiculeMetier vehiculeMetier;
	@RequestMapping(value = "/vehicules", method = RequestMethod.POST)
	public Vehicule saveVehicule(Vehicule vehicule) {
		return vehiculeMetier.saveVehicule(vehicule);
	}
	@RequestMapping(value = "/vehicules", method = RequestMethod.PUT)
	public Vehicule updateVehicule(@RequestParam String immatriculation,@RequestParam String carteGrise,@RequestParam String idUser) {
		return vehiculeMetier.updateVehicule( immatriculation, carteGrise, idUser);
	}
	@RequestMapping(value = "/vehicules/{immatriculation}", method = RequestMethod.DELETE)
	public void deleteVehicule(@PathVariable String  immatriculation) {
		vehiculeMetier.deleteVehicule(immatriculation);
	}
	@RequestMapping(value = "/vehicules", method = RequestMethod.GET)
	public PageVehicule getAllVehicules(@RequestParam int size,@RequestParam int page) {
		return vehiculeMetier.getAllVehicule(size, page);
	}
	
	@RequestMapping(value = "/vehicules/{immatriculation}", method = RequestMethod.GET)
	public Vehicule getVehicule(@PathVariable String immatriculation) {
		return vehiculeMetier.getVehicule(immatriculation);
	}
	@RequestMapping(value = "/getVehicules", method = RequestMethod.GET)
	public List<Vehicule> getAllVehicules() {
		return vehiculeMetier.getAllVehicules();
	}
	
	
	
	
		
}
