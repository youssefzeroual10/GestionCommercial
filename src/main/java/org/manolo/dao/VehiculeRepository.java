package org.manolo.dao;
import org.manolo.entities.Vehicule;
import org.manolo.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehiculeRepository  extends JpaRepository<Vehicule, String>{
	@Query("select v from Vehicule v ")
	public Page <Vehicule> getAllVehicule(Pageable pageable);
}
