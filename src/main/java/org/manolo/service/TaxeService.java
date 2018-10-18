package org.manolo.service;

import java.util.List;

import org.manolo.entities.Taxe;
import org.manolo.metier.PageTaxe;
import org.manolo.metier.TaxeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TaxeService {
	@Autowired
	private TaxeMetier taxeMetier;
	@RequestMapping(value = "/taxes", method = RequestMethod.POST)
	public Taxe saveTaxe(Taxe t) {
		return taxeMetier.saveTaxe(t);
	}
	@RequestMapping(value = "/taxes", method = RequestMethod.PUT)
	public Taxe updateTaxe(Taxe t) {
		return taxeMetier.updateTaxe(t);
	}
	@RequestMapping(value = "/taxes/{id}", method = RequestMethod.DELETE)
	public void deleteTaxe(@PathVariable Long id) {
		taxeMetier.deleteTaxe(id);
	}
	@RequestMapping(value = "/gettaxes", method = RequestMethod.GET)
	public PageTaxe getAllTaxes(int size, int page) {
		return taxeMetier.getAllTaxes(size, page);
	}
	@RequestMapping(value = "/taxes/{id}", method = RequestMethod.GET)
	public Taxe getTaxe(@PathVariable Long id) {
		return taxeMetier.getTaxe(id);
	}
	@RequestMapping(value = "/taxes", method = RequestMethod.GET)
	public List<Taxe> getAllTaxes() {
		return taxeMetier.getAllTaxes();
	}

}
