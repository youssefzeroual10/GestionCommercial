package org.manolo.dao;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;

import java.util.Date;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository  extends JpaRepository<Client, String>{
	 
	@Query("select c from Commande c where c.client.cin=:x ")
	public Page<Commande> CommandesByClient(@Param("x") String cin,Pageable pageable);
	@Query("select count(*) from Client ")
	public int getCountClient();
	@Query("select c from Client c ")
	public Page <Client> getAllClient(Pageable pageable);
	@Query("select c from Client c where c.nom like :x")
	public Page <Client> getClientsByMotCle(@Param("x")String motCle,Pageable pageable);
	@Query("select c from Client c where c.cin=:x")
	public Client getClient(@Param("x")String cin);
	@Query("select c from Client c where c.quartier.idQuartier=:idQuartier and c.cin in(select co.client.cin from Commande co where co.dateCommande=:dateCommande AND co.user.IdUser in ( select u.IdUser from User u where u.IdUser=:idUser ))")
	public List<Client> getClientbalaye(@Param("idQuartier")Long idQuartier,@Param("idUser")String idUser,@Param("dateCommande")String dateCommande);
	/*
	 select * from client where cin in ( select code_fk_client from commande where date_commande='2016-12-01 00:00:00' AND code_fk_user in (select code_fk_user from user a where id_user =1 and code_fk_quartier IN (select id_quartier from quartier where id_quartier=1) ))

	  */
	@Query("select c from Client c where c.quartier.idQuartier=:idQuartier and c.cin in(select co.client.cin from Commande co where co.dateCommande!=:dateCommande AND co.user.IdUser in ( select u.IdUser from User u where u.IdUser=:idUser ))")
	public List<Client> getClientNonbalaye(@Param("idQuartier")Long idQuartier,@Param("idUser")String idUser,@Param("dateCommande")String dateCommande);
	
	@Query("select c from Client c where  c.cin in(select co.client.cin from Commande co where co.statuts=0 ))")
	public Page<Client> getClientsCredit(Pageable pageable);
	
	
	//SELECT * FROM `client` where cin in( select code_fk_client from commande where  statuts=0)
	
}
