package org.manolo.dao;


import org.manolo.entities.Taxe;
import org.manolo.entities.Taxe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxeRepository  extends JpaRepository<Taxe, Long>{
	@Query("select t from Taxe t ")
	public Page <Taxe> getAllTaxes(Pageable pageable);

}
