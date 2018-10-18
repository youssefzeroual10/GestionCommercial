package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;

public interface TaxeMetier {
	public Taxe saveTaxe(Taxe t);
	public Taxe updateTaxe(Taxe t);
	public void deleteTaxe(Long id);
	public PageTaxe getAllTaxes(int size,int page);
	public Taxe getTaxe(Long id);
	public List<Taxe> getAllTaxes();
}
