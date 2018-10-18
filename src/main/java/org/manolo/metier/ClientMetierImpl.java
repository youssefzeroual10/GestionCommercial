package org.manolo.metier;

import java.util.List;

import org.manolo.dao.ClientRepository;
import org.manolo.dao.GenerateurCodeRepository;
import org.manolo.dao.QuartierRepository;
import org.manolo.dao.TypeClientRepository;
import org.manolo.dao.UserRepository;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.entities.GenerateurCode;
import org.manolo.entities.Quartier;
import org.manolo.entities.TypeClient;
import org.manolo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ClientMetierImpl  implements ClientMetier{
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	GenerateurCodeRepository generateurCodeRepository;
	@Autowired
	QuartierRepository quartierRepository;
	@Autowired
	TypeClientRepository typeClientRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	@Override
	public Client updateClient(String cin,String nom,String adresse,String telephone,Long idQuartier,Long idTypeClient,String idUser) {
		Client cl = clientRepository.getClient(cin);
		Quartier quartier = quartierRepository.findOne(idQuartier);
		TypeClient typeClient = typeClientRepository.findOne(idTypeClient);
		User user = userRepository.findOne(idUser);
		cl.setAdresse(adresse);
		cl.setNom(nom);
		cl.setTelephone(telephone);
		cl.setCin(cin);
		cl.setQuartier(quartier);
		cl.setTypeClient(typeClient);
		cl.setUser(user);
		return clientRepository.save(cl);
	}
	@Override
	public void deleteClient(String idClient) {
		clientRepository.delete(clientRepository.getClient(idClient));
	}
	@Override
	public Client addClient(Long cin,String nom,String adresse,String telephone,Long idQuartier,Long idTypeClient,String idUser) {
			GenerateurCode gCode = generateurCodeRepository.findOne(cin);
			if(gCode==null) throw new RuntimeException("ce code  n'existe pas");
			if(gCode.isUsed()== true && clientRepository.getClient(cin.toString()) != null) throw new RuntimeException("ce code  est deja utilisé");
			Client cl = new Client();
			Quartier quartier = quartierRepository.findOne(idQuartier);
			TypeClient typeClient = typeClientRepository.findOne(idTypeClient);
			User user = userRepository.findOne(idUser);
			gCode.setUsed(true);
			cl.setAdresse(adresse);
			cl.setNom(nom);
			cl.setTelephone(telephone);
			cl.setCin(gCode.getIdCode().toString());
			cl.setQuartier(quartier);
			cl.setTypeClient(typeClient);
			cl.setUser(user);
			return clientRepository.save(cl);
	}
	@Override
	public Client getClient(String cin) {
		return clientRepository.getClient(cin);
	}
	@Override
	public PageCommande CommandesByClient(String idClient,int size, int page) {
		Page<Commande> opc = clientRepository.CommandesByClient(idClient, new PageRequest(page, size));
		PageCommande pCo = new PageCommande();
		pCo.setCommande(opc.getContent());
		pCo.setNombreCommandes(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalCommandes((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageClient getAllClient(int size, int page) {
		Page<Client> ops = clientRepository.getAllClient(new PageRequest(page, size));
		PageClient pEt = new PageClient();
		pEt.setClient(ops.getContent());
		pEt.setNombreClients(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalClients((int)ops.getTotalElements());
		return pEt; 
	}
	@Override
	public PageClient getClientsCredit(int size, int page) {
		Page<Client> ops = clientRepository.getClientsCredit(new PageRequest(page, size));
		PageClient pEt = new PageClient();
		pEt.setClient(ops.getContent());
		pEt.setNombreClients(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalClients((int)ops.getTotalElements());
		return pEt; 
	}
	@Override
	public PageClient getByClientsMotCle(String motCle, int size, int page) {
		Page<Client> ops = clientRepository.getClientsByMotCle(motCle,new PageRequest(page, size));
		PageClient pEt = new PageClient();
		pEt.setClient(ops.getContent());
		pEt.setNombreClients(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalClients((int)ops.getTotalElements());
		return pEt; 	
	}
	@Override
	public List<Client> getClientbalaye(Long idQuartier, String idUser, String dateCommande) {
		return clientRepository.getClientbalaye(idQuartier, idUser, dateCommande);
	}
	@Override
	public List<Client> getClientNonbalaye(Long idQuartier, String idUser, String dateCommande) {
		return clientRepository.getClientNonbalaye(idQuartier, idUser, dateCommande);
	}
	@Override
	public int getCountClient() {
		return clientRepository.getCountClient();
	}
	
	
}
