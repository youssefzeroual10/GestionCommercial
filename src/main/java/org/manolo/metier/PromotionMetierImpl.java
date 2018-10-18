package org.manolo.metier;

import java.util.List;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.ClientRepository;
import org.manolo.dao.CommandeRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PrixArticleRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.PrixArticle;
import org.manolo.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@Transactional
public class PromotionMetierImpl  implements PromotionMetier{
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ArticleRepository 	articleRepository;
	@Autowired
	MouvementRepository mouvementRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	private ClientRepository 	clientRepository;
	@Override
	public Promotion addPromotion(Promotion promotion) {
		promotionRepository.save(promotion);
		Article article = promotion.getArticle();
		articleRepository.save(article);
	return promotion;
		
	}
	@Override
	public Promotion addPromotion2(Promotion promotion) {
		promotionRepository.save(promotion);
		Article article = promotion.getArticle();
		Client client = promotion.getClient();
		articleRepository.save(article);
		clientRepository.save(client);
	return promotion;
		
	}
	@Override
	public Promotion updatePromotion(Promotion promotion) {
		return promotionRepository.save(promotion);

	}

	@Override
	public void deletePromotion(Long idPromotion) {
		promotionRepository.delete(idPromotion);	
	}
	@Override
	public void deletePromotion2(Long idPromotion) {
		promotionRepository.delete(idPromotion);	
	}
	
	@Override
	public PagePromotion getAllPromotions(int size, int page) {
		Page<Promotion> arts = promotionRepository.getAllPromotions( new PageRequest(page, size));
		PagePromotion pArt = new PagePromotion();
		pArt.setPromotions(arts.getContent());
		pArt.setNombrePromotions(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalPromotions((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public PagePromotion getPromotionsWithClient(int size, int page) {
		Page<Promotion> arts = promotionRepository.getPromotionsWithClient( new PageRequest(page, size));
		PagePromotion pArt = new PagePromotion();
		pArt.setPromotions(arts.getContent());
		pArt.setNombrePromotions(arts.getNumberOfElements());
		pArt.setPage(arts.getNumber());
		pArt.setTotalPages(arts.getTotalPages());
		pArt.setTotalPromotions((int)arts.getTotalElements());
		return pArt; 
	}
	@Override
	public Promotion getPromotion(Long idPromotion) {
		return promotionRepository.findOne(idPromotion) ;
	}
}
