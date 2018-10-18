package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenerateurCodeRepository  extends JpaRepository<GenerateurCode, Long>{
	@Query("select g from GenerateurCode g ")
	public Page<GenerateurCode> getAllCode(Pageable pageable);
	
}
