package org.manolo.metier;

import java.util.List;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.PrixArticleRepository;
import org.manolo.entities.Article;
import org.manolo.entities.PrixArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@Transactional
public class PrixArticleMetierImpl  implements PrixArticleMetier{
	@Autowired
	private PrixArticleRepository prixArticleRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public PrixArticle savePrix( Long idArticle, String libelle, double prixVente) {
		Article article = articleRepository.findOne(idArticle);
		PrixArticle prixArticle = new PrixArticle();
		prixArticle.setPrixVente(prixVente);
		prixArticle.setArticle(article);
		prixArticle.setLibelle(libelle);
		return prixArticleRepository.save(prixArticle);
	}

	@Override
	public PrixArticle updatePrix(PrixArticle prixArticle) {
		return prixArticleRepository.save(prixArticle);
	}

	@Override
	public void deletePrixArticle(Long id) {
		prixArticleRepository.delete(id);		
	}

	@Override
	public List<PrixArticle> getPrices(Long idArticle) {
		return prixArticleRepository.getPrices(idArticle);
	}
	
}
