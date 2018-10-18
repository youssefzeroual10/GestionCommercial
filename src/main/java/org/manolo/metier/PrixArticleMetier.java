package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.PrixArticle;
import org.springframework.data.domain.Page;

public interface PrixArticleMetier {
	public PrixArticle savePrix(Long idArticle, String libelle, double prixVente);
	public PrixArticle updatePrix(PrixArticle prixArticle);
	public void deletePrixArticle(Long id);
	public List<PrixArticle> getPrices(Long idArticle);
}
