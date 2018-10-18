package org.manolo.metier;

import java.util.List;

import org.manolo.dao.QuartierRepository;
import org.manolo.dao.UserRepository;
import org.manolo.dao.VilleRepository;
import org.manolo.entities.Etat;
import org.manolo.entities.Quartier;
import org.manolo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QuartierMetierImpl  implements QuartierMetier{
	@Autowired 
	private QuartierRepository quartierRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private VilleRepository villeRepository;
	@Override
	public Quartier saveQuartier(Quartier cat) {
		return quartierRepository.save(cat);
	}

	@Override
	public Quartier updateQuartier(Long idQuartier,Long idVille,String idUser,String libelle) {
		Quartier cat = quartierRepository.findOne(idQuartier);
		User user = userRepository.findOne(idUser);
		cat.setVille(villeRepository.findOne(idVille));
		cat.setLibelle(libelle);
		cat.setUser(user);
		return quartierRepository.save(cat);
	}

	@Override
	public void deleteQuartier(Long id) {
		quartierRepository.delete(getQuartier(id));
	}

	@Override
	public PageQuartier getAllQuartier(int size, int page) {
		Page<Quartier> ops = quartierRepository.getAllQuartier(new PageRequest(page, size));
		PageQuartier pQ = new PageQuartier();
		pQ.setQuartiers(ops.getContent());
		pQ.setNombreQuartiers(ops.getNumberOfElements());
		pQ.setPage(ops.getNumber());
		pQ.setTotalPages(ops.getTotalPages());
		pQ.setTotalQuartiers((int)ops.getTotalElements());
		return pQ;
	}

	@Override
	public PageQuartier getByQuartiersMotCle(String motCle, int size, int page) {
		Page<Quartier> ops = quartierRepository.getQuartiersByMotCle(motCle ,new PageRequest(size, page));
		PageQuartier pQ = new PageQuartier();
		pQ.setQuartiers(ops.getContent());
		pQ.setNombreQuartiers(ops.getNumberOfElements());
		pQ.setPage(ops.getNumber());
		pQ.setTotalPages(ops.getTotalPages());
		pQ.setTotalQuartiers((int)ops.getTotalElements());
		return pQ;
	}

	@Override
	public Quartier getQuartier(Long id) {
		return quartierRepository.findOne(id);
	}

	@Override
	public List<Quartier> getAllQuartiers() {
		return quartierRepository.findAll();
	}

	@Override
	public List<Quartier> getQuartiersByVille(Long idVille) {
		return quartierRepository.getQuartiersByVille(idVille);
	}

	@Override
	public List<Quartier> getQuartiersByClient(String id) {
		return quartierRepository.getQuartiersByClient(id);
	}
}
