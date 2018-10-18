package org.manolo.metier;

import java.util.List;
import org.manolo.entities.Client;

public interface ClientMetier {
	public List<Client> getAllClients();
	public Client updateClient(String cin,String nom,String adresse,String telephone,Long idQuartier,Long idTypeClient,String idUser);
	public void deleteClient(String idClient);
	public  Client addClient(Long  cin,String nom,String adresse,String telephone,Long idQuartier,Long idTypeClient,String idUser);
	public  Client getClient(String cin);
	public PageCommande CommandesByClient(String idClient,int size,int page);
	public PageClient getAllClient(int size,int page);
	public PageClient getClientsCredit(int size,int page);
	public PageClient getByClientsMotCle(String motCle,int size,int page);
	public List<Client> getClientbalaye(Long idQuartier,String idUser,String dateCommande);
	public List<Client> getClientNonbalaye(Long idQuartier,String idUser,String dateCommande);
	public  int getCountClient();



}
