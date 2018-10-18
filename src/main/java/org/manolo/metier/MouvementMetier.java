package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Mouvement;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;


public interface MouvementMetier {
	public boolean  entree(Long article, double prixAchat,String commande,String dateExpedition,int quantite);
	public boolean  sortir(Long idMouvement,String idCommande);
	public boolean  defectuer(String libelle,Long article,int quantite);
	public PageMouvement getMouvementsByArticle(Long idArticle,int page, int size);
	public Mouvement addSortie(Long article, Long prixVente,int quantite,String idCommande);
	public Mouvement getMouvement(Long idMouvement);
	public Mouvement updateMouvement(Long idMouvement,Long idArticle, Long prixVente,int quantite);
	public void deleteMouvement(Long id);
	public int getTotalQuantite(Long id);
	public int getTotalQuantiteSortie(Long id); 
	public int getTotalQuantiteCadeau(Long id); 
	public int getTotalQuantiteDefect(Long id);
	public PageMouvement getListEntree(Long idArticle,int size,int page);
	public PageMouvement getListCadeau(String idCommande,int size,int page);
	public List<Promotion> ListCadeau(String idCommande);

	public PageMouvement getListSortie(Long idArticle,int size,int page);
	public PageMouvement getListDefectueuse(Long idArticle,int size,int page);
	public PageMouvement getListCadeau(Long idArticle,int size,int page);

	public PageMouvement getListPerime(String date,int size,int page);
	public List<Mouvement> getListPerimes(String date);

	//public void setPerimeAuxDefect();
	public List<Sortie> getSortieInvalide();
	public List<Promotion> getPromotions(Long idArticle);
	public List<Mouvement> getMouvementsByCommande( String idCommande);
	public PageMouvement   getMouvementsByCommandes( String idCommande,int size,int page);


}
