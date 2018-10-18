package org.manolo.dao;
import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.Ville;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuartierRepository  extends JpaRepository<Quartier, Long>{
	@Query("select q from Quartier q where q.libelle like :x")
	public Page <Quartier> getQuartiersByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select q from Quartier q")
	public Page<Quartier> getAllQuartier(Pageable pageable);
	@Query("select q from Quartier q where q.ville.idVille =:x")
	public List<Quartier> getQuartiersByVille(@Param("x") Long idVille );
	@Query("select q from Quartier q where q.user.IdUser =:x")
	public List<Quartier> getQuartiersByClient(@Param("x") String id );

}
