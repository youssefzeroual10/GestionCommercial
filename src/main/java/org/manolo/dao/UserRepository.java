package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.manolo.entities.User;

import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User, String>{
	 
	@Query("select c from Commande c where c.user.IdUser=:x ")
	public List<Commande> CommandesByUser(@Param("x") String idUser);
	@Query("select u from User u ")
	public Page <User> getAllUsers(Pageable pageable);
	@Query("select u from User u where u.nom like :x")
	public Page <User> getUsersByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select u from User u where u.IdUser=:x ")
	public User getUser(@Param("x") String idUser);
	@Query("select count(*) from User ")
	public int getCountUser();
	@Query("select u from User u where  u.IdUser in(select co.user.IdUser from Commande co where co.statuts='0' ))")
	public Page<User> getUsersCredit(Pageable pageable);
	@Query("select u from User u where u.IdUser=:x AND u.password=:y ")
	public User getUserAuth(@Param("x") String idUser,@Param("y") String password);
	
}
