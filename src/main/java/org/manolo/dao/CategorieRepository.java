package org.manolo.dao;

import org.manolo.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository  extends JpaRepository<Categorie, Long>{
	@Query("select c from Categorie c where c.libelle like :x")
	public Page <Categorie> getCategoriesByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select c from Categorie c ")
	public Page <Categorie> getAllCategories(Pageable pageable);
}
