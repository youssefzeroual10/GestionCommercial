package org.manolo.metier;

import java.util.Date;
import java.util.List;

import org.manolo.entities.Article;
import org.manolo.entities.Inventaire;
import org.manolo.entities.Mouvement;

public interface InventaireMetier {
	
	public List<Mouvement> getInventaireEntree(Date dateStart,Date dateEnd,Long idArticle);
	public List<Mouvement> getInventaireSortie(Date dateStart,Date dateEnd,Long idArticle);
	public List<Mouvement> getInventaireCadeau(Date dateStart,Date dateEnd,Long idArticle);
	public List<Mouvement> getInventaireDef(Date dateStart,Date dateEnd,Long idArticle);
	public List<Article> getInventaireArticle();
	public Inventaire saveInventaire(Date dateStart,Date dateEnd);
	public PageInventaire getAllInventaire(int size,int page);




	
}
