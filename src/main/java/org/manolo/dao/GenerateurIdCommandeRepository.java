package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.manolo.entities.GenerateurIdCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenerateurIdCommandeRepository  extends JpaRepository<GenerateurIdCommande, Long>{
	@Query(value=" SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'generateur_id_commande' AND table_schema = 'manolo'",nativeQuery=true)
	public Long  getNextAutoIncrement();
	
}
