package org.manolo.dao;
import org.manolo.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VilleRepository  extends JpaRepository<Ville, Long>{
	@Query("select c from Ville c where c.libelle like :x")
	public Page <Ville> getVillesByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select c from Ville c ")
	public Page <Ville> getAllVille(Pageable pageable);
}
