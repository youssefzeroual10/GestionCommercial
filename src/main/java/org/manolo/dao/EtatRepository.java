package org.manolo.dao;
import org.manolo.entities.Etat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EtatRepository  extends JpaRepository<Etat, Long>{
	@Query("select e from Etat e where e.libelle like :x")
	public Page <Etat> getEtatsByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select e from Etat e ")
	public Page <Etat> getAllEtats(Pageable pageable);
	@Query("select e from Etat e ")
	public Page <Etat> getAllEtat(Pageable pageable);
}
