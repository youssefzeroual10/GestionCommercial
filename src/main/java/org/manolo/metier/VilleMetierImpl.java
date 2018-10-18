package org.manolo.metier;

import java.util.List;

import org.manolo.dao.VilleRepository;
import org.manolo.entities.Taxe;
import org.manolo.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class VilleMetierImpl  implements VilleMetier{
	@Autowired 
	private VilleRepository villeRepository;
	@Override
	public Ville saveVille(Ville cat) {
		return villeRepository.save(cat);
	}

	@Override
	public Ville updateVille(Ville cat) {
		return villeRepository.save(cat);
	}

	@Override
	public void deleteVille(Long id) {
		villeRepository.delete(getVille(id));
	}

	@Override
	public PageVille getAllVille(int size, int page) {
		Page<Ville> ops = villeRepository.getAllVille(new PageRequest(page, size));
		PageVille pV = new PageVille();
		pV.setVilles(ops.getContent());
		pV.setNombreVilles(ops.getNumberOfElements());
		pV.setPage(ops.getNumber());
		pV.setTotalPages(ops.getTotalPages());
		pV.setTotalVilles((int)ops.getTotalElements());
		return pV;
	}

	@Override
	public PageVille getByVillesMotCle(String motCle, int size, int page) {
		Page<Ville> ops = villeRepository.findAll(new PageRequest(page, size));
		PageVille pV = new PageVille();
		pV.setVilles(ops.getContent());
		pV.setNombreVilles(ops.getNumberOfElements());
		pV.setPage(ops.getNumber());
		pV.setTotalPages(ops.getTotalPages());
		pV.setTotalVilles((int)ops.getTotalElements());
		return pV;
	}

	@Override
	public Ville getVille(Long id) {
		return villeRepository.findOne(id);
	}

	@Override
	public List<Ville> getAllVilles() {
		return villeRepository.findAll();
	}
}
