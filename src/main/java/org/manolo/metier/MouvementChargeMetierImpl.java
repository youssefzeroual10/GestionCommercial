package org.manolo.metier;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;


import org.manolo.dao.ArticleRepository;
import org.manolo.dao.ChargeCamionRepository;
import org.manolo.dao.MouvementChargeRepository;
import org.manolo.dao.PrixArticleRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.dao.UserRepository;
import org.manolo.entities.Charge;
import org.manolo.entities.Mouvement;
import org.manolo.entities.MouvementCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional 
public class MouvementChargeMetierImpl  implements MouvementChargeMetier{
	
	@Autowired
	private MouvementChargeRepository mouvementChargeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ChargeCamionRepository chargeCamionRepository;
	@Autowired
	private PrixArticleRepository prixArticleRepository;
	@Override
	public boolean charger(HttpServletRequest httpServletRequest, String IdUser, int quantite, Long idAtricle,
			Long idChargeCamion) {
		MouvementCharge charge = new Charge();
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd" ); 
		String date = formatter.format(new Date());
		charge.setArticle(articleRepository.findOne(idAtricle));
		charge.setCharge(chargeCamionRepository.findOne(idChargeCamion));
		charge.setDateMouvement(date);
		charge.setQuantite(quantite);
		mouvementChargeRepository.save(charge);
		return true;
	}
	@Override
	public boolean sortir(HttpServletRequest httpServletRequest, int quantite, Long idAtricle, Long idChargeCamion) {
		/*MouvementCharge mouvement = mouvementChargeRepository.findOne(idMouvemment);
		Commande commande = commandeRepository.findOne(idCommande);
		Article article = mouvement.getArticle();
		mouvement.setValide(true);
		mouvement.setDateMouvement(new Date());
		mouvementRepository.save(mouvement);
		int sortie =  getTotalQuantiteSortie(article.getIdArticle());
		int entree =  getTotalQuantite(article.getIdArticle());
		List<Mouvement> sorties = mouvementRepository.getMouvementsByCommande(idCommande);
		if(sorties.size()==0) throw new RuntimeException("ereeur");
		double total = 0;
		for (Mouvement m : sorties) {
			total= total + (m.getPrixVente() * m.getQuantite());
		}
		
		int defectueuse =  getTotalQuantiteDefect(article.getIdArticle());
		article.setQuantite(entree-sortie-defectueuse-getTotalQuantiteCadeau(article.getIdArticle()));
		
		commande.setMontant(total);
		commande.setReste(total);
		commandeRepository.save(commande);
		articleRepository.save(article);*/
		return true;
	}
	@Override
	public Mouvement getMouvementCharge(Long idMouvementCharge) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Mouvement updateMouvementCharge(Long idMouvementCharge, Long idArticle, int quantite) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
