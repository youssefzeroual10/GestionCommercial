package org.manolo.dao;
import org.manolo.entities.Avance;
import org.manolo.entities.Etat;
import org.manolo.entities.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvanceRepository  extends JpaRepository<Avance, Long>{
	
}
