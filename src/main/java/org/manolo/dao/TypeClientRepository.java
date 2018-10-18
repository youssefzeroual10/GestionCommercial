package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.TypeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeClientRepository  extends JpaRepository<TypeClient, Long>{
	@Query("select t from TypeClient t where t.libelle like :x")
	public Page <TypeClient> getTypesClientByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select t from TypeClient t ")
	public Page <TypeClient> getAllTypesClient(Pageable pageable);
	
}
