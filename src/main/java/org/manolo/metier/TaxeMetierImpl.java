package org.manolo.metier;

import java.util.List;

import org.manolo.dao.TaxeRepository;
import org.manolo.entities.SousCategorie;
import org.manolo.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TaxeMetierImpl  implements TaxeMetier{
	@Autowired 
	private TaxeRepository taxeRepository;
	@Override
	public Taxe saveTaxe(Taxe cat) {
		return taxeRepository.save(cat);
	}

	@Override
	public Taxe updateTaxe(Taxe cat) {
		return taxeRepository.save(cat);
	}

	@Override
	public void deleteTaxe(Long id) {
		taxeRepository.delete(getTaxe(id));
	}

	@Override
	public PageTaxe getAllTaxes(int size, int page) {
		Page<Taxe> ops = taxeRepository.getAllTaxes(new PageRequest(page, size));
		PageTaxe ptx = new PageTaxe();
		ptx.setTaxes(ops.getContent());
		ptx.setNombreTaxes(ops.getNumberOfElements());
		ptx.setPage(ops.getNumber());
		ptx.setTotalPages(ops.getTotalPages());
		ptx.setTotalTaxes((int)ops.getTotalElements());
		return ptx;
	}

	@Override
	public Taxe getTaxe(Long id) {
		return taxeRepository.findOne(id);
	}

	@Override
	public List<Taxe> getAllTaxes() {
		return taxeRepository.findAll();
	}
}
