package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.springframework.data.domain.Page;

public interface FournisseurMetier {
	public List<Fournisseur> getAllFournisseurs();
	public Fournisseur updateFournisseur(Fournisseur fournisseur);
	public Fournisseur getFournisseur(Long id);
	public void deleteFournisseur(Long idFournisseur);
	public Fournisseur addFournisseur(Fournisseur fournisseur);
	public PageArticle ArticlesByFournisseur(Long idFournisseur,int size,int page);
	public PageCommande CommandesByFournisseur(Long idFournisseur,int size,int page);
	public PageFournisseur getAllFournisseur(int size,int page);
}
