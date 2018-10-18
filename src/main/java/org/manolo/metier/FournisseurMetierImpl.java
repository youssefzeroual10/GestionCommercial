package org.manolo.metier;

import java.util.List;

import org.manolo.dao.EtatRepository;
import org.manolo.dao.FournisseurRepository;
import org.manolo.entities.Article;
import org.manolo.entities.Categorie;
import org.manolo.entities.Commande;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class FournisseurMetierImpl  implements FournisseurMetier{
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Override
	public List<Fournisseur> getAllFournisseurs() {
		return fournisseurRepository.findAll() ;
	}
	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}
	@Override
	public void deleteFournisseur(Long idFournisseur) {
		fournisseurRepository.delete(fournisseurRepository.findOne(idFournisseur));
		
	}
	@Override
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}
	@Override
	public Fournisseur getFournisseur(Long id) {
		return fournisseurRepository.findOne(id);
	}
	@Override
	public PageArticle ArticlesByFournisseur(Long idFournisseur,int size, int page) {
		Page<Article> arts = fournisseurRepository.ArticlesByFournisseur(idFournisseur,new PageRequest(page, size));
		PageArticle pArt = new PageArticle();
		pArt.setArticles(arts.getContent());
		pArt.setNombreArticles(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalArticles((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public PageCommande CommandesByFournisseur(Long idFournisseur,int size, int page) {
		Page<Commande> cmd = fournisseurRepository.CommandesByFournisseur(idFournisseur,new PageRequest(page, size));
		PageCommande pArt = new PageCommande();
		pArt.setCommande(cmd.getContent());
		pArt.setNombreCommandes(cmd.getNumberOfElements());
		pArt.setPage(cmd.getNumber());
		pArt.setTotalPages(cmd.getTotalPages());
		pArt.setTotalCommandes((int)cmd.getTotalElements());
		return pArt; 
	}
	@Override
	public PageFournisseur getAllFournisseur(int size, int page) {
		Page<Fournisseur> ops = fournisseurRepository.getAllFournisseurs(new PageRequest(page, size));
		PageFournisseur pEt = new PageFournisseur();
		pEt.setFournisseur(ops.getContent());
		pEt.setNombreFournisseurs(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalFournisseurs((int)ops.getTotalElements());
		return pEt; 
	}
	
}
