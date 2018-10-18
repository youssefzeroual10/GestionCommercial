package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.TypeAction;
import org.manolo.entities.TypeClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeActionRepository  extends JpaRepository<TypeAction, Long>{
	@Query("select t from TypeAction t ")
	public Page <TypeAction> getAllTypesAction(Pageable pageable);
	
}
