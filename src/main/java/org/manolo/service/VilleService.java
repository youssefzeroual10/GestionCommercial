package org.manolo.service;

import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.Ville;
import org.manolo.metier.PageVille;
import org.manolo.metier.QuartierMetier;
import org.manolo.metier.VilleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class VilleService {
	@Autowired
	private VilleMetier villeMetier;
	@Autowired
	private QuartierMetier quartierMetier;
	@RequestMapping(value = "/villes", method = RequestMethod.POST)
	public Ville saveVille(Ville ville) {
		return villeMetier.saveVille(ville);
	}
	@RequestMapping(value = "/villes", method = RequestMethod.PUT)
	public Ville updateVille(Ville ville) {
		return villeMetier.updateVille(ville);
	}
	@RequestMapping(value = "/villes/{id}", method = RequestMethod.DELETE)
	public void deleteVille(@PathVariable Long id)  {
		List<Quartier> quartier= quartierMetier.getQuartiersByVille(id);
		if(quartier.size() > 0) throw new RuntimeException("vous devez d'abord supprimer des quartiers");
		villeMetier.deleteVille(id);
		
	}
	@RequestMapping(value = "/getvilles", method = RequestMethod.GET)	
	public PageVille getAllVille(@RequestParam int size,@RequestParam int page) {
		return villeMetier.getAllVille(size, page);
	}
	public PageVille getByVillesMotCle(String motCle, int size, int page) {
		return villeMetier.getByVillesMotCle(motCle, size, page);
	}
	@RequestMapping(value = "/villes/{id}", method = RequestMethod.GET)
	public Ville getVille(@PathVariable Long id) {
		return villeMetier.getVille(id);
	}
	@RequestMapping(value = "/villes", method = RequestMethod.GET)
	public List<Ville> getAllVilles() {
		return villeMetier.getAllVilles();
	}
	
}
