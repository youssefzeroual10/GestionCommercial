package org.manolo.dao;
import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.SousCategorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SousCategorieRepository  extends JpaRepository<SousCategorie, Long>{
	@Query("select s from SousCategorie s where s.libelle like :x")
	public Page <SousCategorie> getSousCategoriesByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select s from SousCategorie s ")
	public Page <SousCategorie> getAllSousCategories(Pageable pageable);
	@Query("select s from SousCategorie s where s.categorie.idCategorie =:x")
	public List<SousCategorie> getSousCatByCat(@Param("x") Long idCategorie );
}
