package org.manolo.metier;

import java.util.List;

import org.manolo.dao.UserRepository;
import org.manolo.dao.VehiculeRepository;
import org.manolo.entities.Taxe;
import org.manolo.entities.User;
import org.manolo.entities.Vehicule;
import org.manolo.entities.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class VehiculeMetierImpl  implements VehiculeMetier{
	@Autowired 
	private VehiculeRepository vehiculeRepository;
	@Autowired 
	private UserRepository userRepository;
	@Override
	public Vehicule saveVehicule(Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}

	@Override
	public Vehicule updateVehicule(String immatriculation,String carteGrise,String idUser) {
		Vehicule vehicule =vehiculeRepository.findOne(immatriculation);
		User user = userRepository.findOne(idUser);
		vehicule.setCarteGrise(carteGrise);
		vehicule.setUser(user);
		return vehiculeRepository.save(vehicule);
	}

	@Override
	public void deleteVehicule(String immatriculation) {
		vehiculeRepository.delete(getVehicule(immatriculation));
	}

	@Override
	public PageVehicule getAllVehicule(int size, int page) {
		Page<Vehicule> ops = vehiculeRepository.getAllVehicule(new PageRequest(page, size));
		PageVehicule pV = new PageVehicule();
		pV.setVehicules(ops.getContent());
		pV.setNombreVehicules(ops.getNumberOfElements());
		pV.setPage(ops.getNumber());
		pV.setTotalPages(ops.getTotalPages());
		pV.setTotalVehicules((int)ops.getTotalElements());
		return pV;
	}

	
	@Override
	public Vehicule getVehicule(String immatriculation) {
		return vehiculeRepository.findOne(immatriculation);
	}

	@Override
	public List<Vehicule> getAllVehicules() {
		return vehiculeRepository.findAll();
	}
}
