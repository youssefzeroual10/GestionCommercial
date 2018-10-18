package org.manolo.metier;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.AvanceRepository;
import org.manolo.dao.CommandeRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PaiementRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.entities.Article;
import org.manolo.entities.Avance;
import org.manolo.entities.Cadeau;
import org.manolo.entities.Cheque;
import org.manolo.entities.Commande;
import org.manolo.entities.Credit;
import org.manolo.entities.Espece;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.entities.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
@Transactional 
public class PaiementMetierImpl  implements PaiementMetier{
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private MouvementRepository mouvementRepository;
	@Autowired
	private AvanceRepository avanceRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private PaiementRepository paiementRepository;
	@Value("${imagesDir}")
	private String  imagesDir ;
	public Paiement credit(String idCommande, double montant, double avance) {
		Paiement credit = new Credit();
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy" ); 
		String date = formatter.format(new Date());
		Commande commande = commandeRepository.findOne(idCommande);
		if(getReste(idCommande) !=null){
		commande.setReste(montant - getReste(idCommande));
		
		}else{commande.setReste(montant - avance );}
		if(commande.getMontant() == avance)
			commande.setStatuts(true);
		commandeRepository.save(commande);
		credit.setDatePaiement(date);
		credit.setCommande(commande);
		credit.setLibelle("credit avec avance");
		credit.setMontant(avance);
		paiementRepository.save(credit);
		Avance avc = new Avance();
		avc.setPaiement(credit);
		avc.setMontant(avance);
		avanceRepository.save(avc);
		addCadeau(commande.getIdCommande());
		return credit;
	}
	public Paiement creditP(String idCommande, double montant, double avance) {
		Paiement credit = new Credit();
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy" ); 
		String date = formatter.format(new Date());
		Commande commande = commandeRepository.findOne(idCommande);
		commande.setReste(commande.getReste()-avance);
		credit.setDatePaiement(date);
		credit.setCommande(commande);
		credit.setLibelle("credit avec avance");
		credit.setMontant(avance);
		Avance avc = new Avance();
		avc.setPaiement(credit);
		avc.setMontant(avance);
		paiementRepository.save(credit);
		avanceRepository.save(avc);
		if((commande.getMontant() == getSumAvance(idCommande)) && getSumAvance(idCommande)!=null)
		commande.setStatuts(true);	
		
		System.out.println("reste"+commande.getReste());
		
		commandeRepository.save(commande);
		addCadeau(commande.getIdCommande());
		return credit;
	}
	public Paiement credits(String idCommande, double montant) {
		Paiement credit = new Credit();
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy" ); 
		String date = formatter.format(new Date());
		Commande commande = commandeRepository.findOne(idCommande);
		commande.setReste(montant);
		credit.setDatePaiement(date);
		credit.setCommande(commande);
		credit.setLibelle("credit sans avance");
		credit.setMontant(0);
		paiementRepository.save(credit);
		commandeRepository.save(commande);
		addCadeau(commande.getIdCommande());
		return credit;
	}
	public Paiement espece(String idCommande, double montant) {
		Paiement espece = new Espece();
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy" ); 
		String date = formatter.format(new Date());
		Commande commande = commandeRepository.findOne(idCommande);
		espece.setDatePaiement(date);
		espece.setCommande(commande);
		espece.setLibelle("espece");
		commande.setStatuts(true);
		espece.setMontant(montant);
		commande.setReste(0);
		paiementRepository.save(espece);
		commandeRepository.save(commande);
		addCadeau(commande.getIdCommande());
		return espece;
	}
	public Paiement especeP(String idCommande, double montant) {
		Paiement espece = new Espece();
		SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy" ); 
		String date = formatter.format(new Date());
		Commande commande = commandeRepository.findOne(idCommande);
		espece.setDatePaiement(date);
		espece.setCommande(commande);
		espece.setLibelle("espece");
		espece.setMontant(montant);
		commande.setReste(0);
		commande.setStatuts(true);
		paiementRepository.save(espece);
		commandeRepository.save(commande);
		return espece;
	}
	public Paiement cheque(String idCommande,String datePaiement ,double montant,MultipartFile cheque) {
		Cheque che = new Cheque();
		Commande commande = commandeRepository.findOne(idCommande);
		String fileName = null;
    	String repertoire = imagesDir+"/"+commande.getIdCommande();
		if (cheque != null && cheque.getSize() >0) {
	       try {
	    	
	    	  fileName = cheque.getOriginalFilename();
	    	  File dir = new File (repertoire);
	    	  dir.mkdirs();
	          byte[] bytes = cheque.getBytes();
	          BufferedOutputStream buffStream = 
	              new BufferedOutputStream(new FileOutputStream(new File(repertoire+"/" + fileName)));
	          buffStream.write(bytes);
	              buffStream.close();
	            } catch (Exception e) {
	            	System.out.println( "You failed to upload " + fileName + ": " + e.getMessage());
	            }
        } 
		che.setDatePaiement(datePaiement);
		che.setCommande(commande);
		che.setLibelle("cheque");
		che.setPhoto(cheque.getOriginalFilename());
		commande.setReste(0);
		che.setMontant(montant);
		paiementRepository.save(che);
		commande.setStatuts(true);
		commandeRepository.save(commande);
		addCadeau(commande.getIdCommande());
		return che;
	}
	public Paiement chequeP(String idCommande,String datePaiement ,double montant,MultipartFile cheque) {
		Cheque che = new Cheque();
		Commande commande = commandeRepository.findOne(idCommande);
		String fileName = null;
    	String repertoire = imagesDir+"/"+commande.getIdCommande();
		if (cheque != null && cheque.getSize() >0) {
	       try {
	    	
	    	  fileName = cheque.getOriginalFilename();
	    	  File dir = new File (repertoire);
	    	  dir.mkdirs();
	          byte[] bytes = cheque.getBytes();
	          BufferedOutputStream buffStream = 
	              new BufferedOutputStream(new FileOutputStream(new File(repertoire+"/" + fileName)));
	          buffStream.write(bytes);
	              buffStream.close();
	            } catch (Exception e) {
	            	System.out.println( "You failed to upload " + fileName + ": " + e.getMessage());
	            }
        } 
		che.setCommande(commande);
		che.setLibelle("cheque");
		che.setDatePaiement(datePaiement);
		che.setMontant(commande.getReste());
		commande.setReste(0);
		che.setPhoto(cheque.getOriginalFilename());
		paiementRepository.save(che);
		commande.setStatuts(true);
		commandeRepository.save(commande);
		return che;
	}
	@Override
	public List<Paiement> getPaiements(String idCommande) {
		return paiementRepository.getPaiements(idCommande);
	}
	@Override
	public List<Avance> getAvanceCommande(String idCommande) {
		return paiementRepository.getAvanceCommande(idCommande);
	}
	@Override
	public boolean addCadeau(String idCommande) {
		List<Mouvement> mouvements = mouvementRepository.getMouvementsByCommande( idCommande);
		Promotion promo = null;
		Promotion promoArticle = null;
		for (Mouvement mouvement : mouvements) {
			promo = promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin());
			promoArticle =  promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle());
			if(promo == null && promoArticle != null){
				if((mouvement.getArticle().getQuantite() >= promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteMin()) && (mouvement.getQuantite() >= promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteMin())){
					Mouvement mvtCadeau = new Cadeau() ;
					Article article = articleRepository.findOne(mouvement.getArticle().getIdArticle());
					mvtCadeau.setDateMouvement(new Date());
					article.setQuantite((article.getQuantite() -((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteMin()) ) * promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteCadeau())));
					mvtCadeau.setQuantite(((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteMin()) ) * promotionRepository.getPromotionByArticleCadeau(mouvement.getArticle().getIdArticle()).getQteCadeau()));
					mvtCadeau.setLibelle("cadeau");
					mvtCadeau.setArticle(article);
					mouvementRepository.save(mvtCadeau);
					articleRepository.save(article);
				}
			}else if(promo != null && promoArticle != null){
					if((mouvement.getArticle().getQuantite() >= promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteMin()) && (mouvement.getQuantite() >= promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteMin())){
						Mouvement mvtCadeau = new Cadeau() ;
						Article article = articleRepository.findOne(mouvement.getArticle().getIdArticle());
						mvtCadeau.setDateMouvement(new Date());
						article.setQuantite((article.getQuantite() -((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteMin()) ) * promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteCadeau())));
						mvtCadeau.setQuantite(((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteMin()) ) * promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),mouvement.getCommande().getClient().getCin()).getQteCadeau()));
						mvtCadeau.setLibelle("cadeau");
						mvtCadeau.setArticle(article);
						mouvementRepository.save(mvtCadeau);
						articleRepository.save(article);
					}
				}
		}
		return true;
	}
	public boolean addCadeau2(String idCommande,String cin) {
		List<Mouvement> mouvements = mouvementRepository.getMouvementsByCommande( idCommande);
		for (Mouvement mouvement : mouvements) {
			if((mouvement.getArticle().getQuantite() >= promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteMin()) && (mouvement.getQuantite() >= promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteMin())){
				Mouvement mvtCadeau = new Cadeau() ;
				Article article = articleRepository.findOne(mouvement.getArticle().getIdArticle());
				mvtCadeau.setDateMouvement(new Date());
				article.setQuantite((article.getQuantite() -((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteMin()) ) * promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteCadeau())));
				mvtCadeau.setQuantite(((mouvement.getQuantite() /(promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteMin()) ) * promotionRepository.getPromotionByArticleClient(mouvement.getArticle().getIdArticle(),cin).getQteCadeau()));
				mvtCadeau.setLibelle("cadeau");
				mvtCadeau.setArticle(article);
				mouvementRepository.save(mvtCadeau);
				articleRepository.save(article);
			}
		}
		return true;
	}
	@Override
	public Long getSumAvance(String idCommande) {
		
		return paiementRepository.getSumAvance(idCommande);
	}
	@Override
	public Long getReste(String idCommande) {
		
		return paiementRepository.getReste(idCommande);
	}
	@Override
	public List<Paiement> getAlerteCheque(String date) {
		return paiementRepository.getAlerteCheque(date);
	}
}
