package org.manolo.service;

import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.PageEtat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EtatService {
	@Autowired
	private EtatMetier etatMetier;
	@RequestMapping(value = "/etats", method = RequestMethod.POST)
	public Etat saveEtat(Etat etat) {
		return etatMetier.saveEtat(etat);
	}
	@RequestMapping(value = "/etats", method = RequestMethod.PUT)
	public Etat updateEtat(Etat etat) {
		return etatMetier.updateEtat(etat);
	}
	@RequestMapping(value = "/etats/{id}", method = RequestMethod.DELETE)
	public void deleteEtat(@PathVariable Long id) {
		etatMetier.deleteEtat(id);
	}
	@RequestMapping(value = "/etats/{id}", method = RequestMethod.GET)
	public Etat getEtat(@PathVariable Long id) {
		return etatMetier.getEtat(id);
	}
	@RequestMapping(value = "/etats", method = RequestMethod.GET)
	public List<Etat> getAllEtats() {
		return etatMetier.getAllEtats();
	}
	@RequestMapping(value = "/getetats", method = RequestMethod.GET)
	public PageEtat getAllEtat(int size, int page) {
		return etatMetier.getAllEtat(size, page);
	}

	public PageEtat getByEtatsMotCle(String motCle, int size, int page) {
		return etatMetier.getByEtatsMotCle(motCle, size, page);
	}
	
}
