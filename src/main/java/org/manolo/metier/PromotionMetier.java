package org.manolo.metier;


import org.manolo.entities.Promotion;

public interface PromotionMetier {
	public Promotion  addPromotion(Promotion promotion);
	public Promotion  addPromotion2(Promotion promotion);
	public Promotion  updatePromotion(Promotion promotion);
	public Promotion  getPromotion(Long idPromotion);
	public void  deletePromotion(Long idPromotion);
	public void  deletePromotion2(Long idPromotion);
	public PagePromotion getAllPromotions(int size,int page);
	public PagePromotion getPromotionsWithClient(int size,int page);
	




	
}
