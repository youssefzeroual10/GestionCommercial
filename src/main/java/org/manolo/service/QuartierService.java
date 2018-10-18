package org.manolo.service;

import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.metier.PageQuartier;
import org.manolo.metier.PageVille;
import org.manolo.metier.QuartierMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class QuartierService {
	@Autowired
	private QuartierMetier quartierMetier;
	@RequestMapping(value = "/quartiers", method = RequestMethod.POST)
	public Quartier saveQuartier(Quartier quartier) {
		return quartierMetier.saveQuartier(quartier);
	}
	@RequestMapping(value = "/quartiers", method = RequestMethod.PUT)
	public Quartier updateQuartier( @RequestParam Long idVille,
									@RequestParam Long idQuartier,
									@RequestParam String idUser,
									@RequestParam String libelle) {
		return quartierMetier.updateQuartier(idQuartier,idVille,idUser,libelle);
	}
	@RequestMapping(value = "/quartiers/{id}", method = RequestMethod.DELETE)
	public void deleteQuartier(@PathVariable Long id) {
		quartierMetier.deleteQuartier(id);
	}
	@RequestMapping(value = "/quartiers/{id}", method = RequestMethod.GET)
	public Quartier getQuartier(@PathVariable Long id) {
		return quartierMetier.getQuartier(id);
	}
	@RequestMapping(value = "/quartiers", method = RequestMethod.GET)
	public List<Quartier> getAllQuartiers() {
		return quartierMetier.getAllQuartiers();
	}
	@RequestMapping(value = "/getquartiers", method = RequestMethod.GET)
	public PageQuartier getAllQuartier(@RequestParam int size,@RequestParam int page) {
		return quartierMetier.getAllQuartier(size, page);
	}
	
	public PageQuartier getByQuartiersMotCle(String motCle, int size, int page) {
		return quartierMetier.getByQuartiersMotCle(motCle, size, page);
	}
	@RequestMapping(value = "/getquartier", method = RequestMethod.GET)
	public List<Quartier> getQuartiersByClient(@RequestParam String id) {
		return quartierMetier.getQuartiersByClient(id);
	}
	

}
