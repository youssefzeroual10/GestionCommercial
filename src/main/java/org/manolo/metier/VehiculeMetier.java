package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Vehicule;
import org.springframework.data.domain.Page;

public interface VehiculeMetier {
	public Vehicule saveVehicule(Vehicule Vehicule);
	public Vehicule updateVehicule(String immatriculation,String carteGrise,String idUser);
	public void deleteVehicule(String immatriculation);
	public PageVehicule getAllVehicule(int size,int page);
	public Vehicule getVehicule(String immatriculation);
	public List<Vehicule> getAllVehicules();
}
