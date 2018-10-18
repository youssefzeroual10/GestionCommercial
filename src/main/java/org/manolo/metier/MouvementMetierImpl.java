package org.manolo.metier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.CommandeRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PrixArticleRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.entities.Article;
import org.manolo.entities.Commande;
import org.manolo.entities.Defectueuse;
import org.manolo.entities.Entree;
import org.manolo.entities.Mouvement;
import org.manolo.entities.PrixArticle;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional 
public class MouvementMetierImpl  implements MouvementMetier{
	@PersistenceContext
    private EntityManager em;
	@Autowired
	private MouvementRepository mouvementRepository;
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private PrixArticleRepository prixArticleRepository;
	@Override
	public boolean entree(Long article, double prixAchat,String commande,String dateExpedition,int quantite) {
		Mouvement mouvement = new Entree();
		LocalDate today = LocalDate.now();
		Article art = articleRepository.findOne(article);
		Commande cmd = commandeRepository.findOne(commande);
		mouvement.setPrixAchat(prixAchat);
		mouvement.setArticle(art);
		mouvement.setCommande(cmd);
		mouvement.setDateExpedition(dateExpedition);
		mouvement.setDateMouvement(new Date());
		mouvement.setQuantite(quantite);
		mouvementRepository.save(mouvement);
		int sortie =  getTotalQuantiteSortie(art.getIdArticle());
		int total =  getTotalQuantite(article);
		int defectueuse =  getTotalQuantiteDefect(art.getIdArticle());
		art.setQuantite(total-sortie-defectueuse-getTotalQuantiteCadeau(art.getIdArticle()));
		
		articleRepository.save(art);
		return true;
	}

	@Override
	public boolean sortir(Long idMouvemment,String idCommande) {
		Mouvement mouvement = mouvementRepository.findOne(idMouvemment);
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
		articleRepository.save(article);
		return true;
	}
	@Override
	public Mouvement addSortie(Long article, Long prixVente,int quantite,String idCommande) {
		Mouvement mouvement = new Sortie();
		LocalDate today = LocalDate.now();
		Article art = articleRepository.findOne(article);
		Commande commande = commandeRepository.findOne(idCommande);
		PrixArticle prix = prixArticleRepository.findOne(prixVente);
		mouvement.setPrixVente(prix.getPrixVente());
		mouvement.setArticle(art);
		mouvement.setCommande(commande);
		mouvement.setDateMouvement(new Date());
		mouvement.setQuantite(quantite);
		mouvement.setValide(false);
		mouvementRepository.save(mouvement);
		int total =  getTotalQuantiteSortie(article);
		//art.setQuantite(Integer.parseInt(total[1]));
		//articleRepository.save(art);
		return mouvement;
	}
	@Override
	public boolean defectuer(String libelle,Long article,int quantite) {
		Article art = articleRepository.findOne(article) ;
		//System.out.println("la quantite defect"+quantite);
		//System.out.println("la quantite de l article"+art.getQuantite());
		art.setQuantite(art.getQuantite() - quantite);
		Mouvement mouvement = new Defectueuse() ;
		mouvement.setArticle(art);
		mouvement.setLibelle(libelle);
		mouvement.setQuantite(quantite);
		mouvement.setDateMouvement(new Date());
		mouvementRepository.save(mouvement);
		articleRepository.save(art);
		return true;
	}

	@Override
	public PageMouvement getMouvementsByArticle(Long idArticle,int page, int size) {
		Page<Mouvement> mvs = mouvementRepository.getMouvements(idArticle, new PageRequest(page, size));
		PageMouvement pmv = new PageMouvement();
		pmv.setMouvements(mvs.getContent());
		pmv.setNombreMouvements(mvs.getNumberOfElements());
		pmv.setPage(mvs.getNumber());
		pmv.setTotalPages(mvs.getTotalPages());
		pmv.setTotalMouvements((int)mvs.getTotalElements());
		
		return pmv;

	}

	@Override
	public void deleteMouvement(Long id) {
		mouvementRepository.delete(id);
		
	}

	@Override
	public int getTotalQuantite(Long id) {
		return mouvementRepository.getTotalQuantite(id);
	}
	@Override
	public int getTotalQuantiteCadeau(Long id) {
		return mouvementRepository.getTotalQuantiteCadeau(id);
	}
	@Override
	public int getTotalQuantiteSortie(Long id) {
		return mouvementRepository.getTotalQuantiteSortie(id);
	}
	@Override
	public int getTotalQuantiteDefect(Long id) {
		return mouvementRepository.getTotalQuantiteDefect(id);
	}
	@Override
	public PageMouvement getListEntree(Long idArticle,int size,int page) {
		Page<Mouvement> opc = mouvementRepository.getListEntree(idArticle, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageMouvement getListSortie(Long idArticle,int size,int page) {
		Page<Mouvement> opc = mouvementRepository.getListSortie(idArticle, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageMouvement getListDefectueuse(Long idArticle,int size,int page) {
		Page<Mouvement> opc = mouvementRepository.getListDefectueuse(idArticle, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageMouvement getListCadeau(Long idArticle,int size,int page) {
		Page<Mouvement> opc = mouvementRepository.getListCadeau(idArticle, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
	@Override
	public PageMouvement getListPerime(String date,int size,int page) {
		//LocalDate dt = LocalDate.now();
		//LocalDate mois = dt.plus(1,ChronoUnit.MONTHS);
		Page<Mouvement> opc = mouvementRepository.getListPerime(date ,new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
/*
	@Override
	public void setPerimeAuxDefect() {
		
		List<Defectueuse> entree = mouvementRepository.getEntree();
		
		for (Mouvement mouvement : entree) {
			Mouvement def =  mouvementRepository.findOne(mouvement.getIdMouvement());
			Article art = mouvement.getArticle();
			art.setQuantite(art.getQuantite() - mouvement.getQuantite());
			def = new Defectueuse();
			def.setLibelle("perime");
			def.setArticle(mouvement.getArticle());
			def.setDateExpedition(mouvement.getDateExpedition());
			def.setQuantite(mouvement.getQuantite());
			def.setCommande(mouvement.getCommande());
			def.setDateMouvement(new Date());
			def.setPrixAchat(mouvement.getPrixAchat());
			mouvementRepository.save(def);
			articleRepository.save(art);
			mouvementRepository.delete(mouvement.getIdMouvement());

		}
	}

*/	@Override
	public List<Sortie> getSortieInvalide() {
		return mouvementRepository.getSortieInvalide();
	}

	@Override
	public Mouvement getMouvement(Long idMouvement) {
		
		return mouvementRepository.findOne(idMouvement);
	}

	@Override
	public Mouvement updateMouvement(Long idMouvement,Long idArticle, Long prixVente,int quantite) {
		Mouvement mvt = mouvementRepository.findOne(idMouvement);
		Article article = articleRepository.findOne(idArticle);
		mvt.setArticle(article);
		mvt.setDateMouvement(new Date());
		mvt.setPrixVente(prixVente);
		mvt.setQuantite(quantite);
		return mouvementRepository.save(mvt);
	}

	@Override
	public List<Mouvement> getMouvementsByCommande(String idCommande) {
		return mouvementRepository.getMouvementsByCommande(idCommande);
	}
	@Override
	public PageMouvement getMouvementsByCommandes(String idCommande, int size, int page) {
		Page<Mouvement> opc = mouvementRepository.getMouvementsByCommandes(idCommande, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}
	

	@Override
	public PageMouvement getListCadeau(String idCommande, int size, int page) {
		Page<Mouvement> opc = mouvementRepository.getListCadeau(idCommande, new PageRequest(page, size));
		PageMouvement pCo = new PageMouvement();
		pCo.setMouvements(opc.getContent());
		pCo.setNombreMouvements(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalMouvements((int)opc.getTotalElements());
		return pCo; 
	}

	@Override
	public List<Promotion> ListCadeau(String idCommande) {
		List<Mouvement> mouvements = mouvementRepository.getMouvementsByCommande(idCommande);
		List<Promotion> promotions = Collections.emptyList();
		Commande commande = commandeRepository.findOne(idCommande);
		Promotion promo = null;
		int i=0;
		System.out.println("salut 1");
		for (Mouvement mouvement : mouvements) {
			
			//if( mouvement.getArticle().getPromotion() != null)
			//{
				//if(mouvement.getQuantite() >= promotionRepository.getPromotionByArticle(mouvement.getArticle().getIdArticle()).getQteMin()){
			System.out.println("2----");
			System.out.println(commande.getClient().getCin());
			System.out.println(mouvement.getArticle().getIdArticle());
			System.out.println(idCommande);
			
			promo = promotionRepository.getPromotionByArticleClt(commande.getClient().getCin(),mouvement.getArticle().getIdArticle(),idCommande);
			
			if(promo != null){
				System.out.println("salut 3");
			 if(promo.getClient() ==null){
				 System.out.println("salut 4");
				promo = promotionRepository.getPromotionByArticleClt(commande.getClient().getCin(),mouvement.getArticle().getIdArticle(),idCommande);
				promotions.add(promo);
							
			}
			else if (promo.getClient()!=null){
				System.out.println("good bye 5");
				promo = promotionRepository.getPromotionByArticleClt(commande.getClient().getCin(),mouvement.getArticle().getIdArticle(),idCommande);
				promotions.add(promo);
				
			}else{
				System.out.println("good bye");
			}
			}	
				//}
			//}
		}
		for(Promotion pro :promotions){
			System.out.println("3"+pro.getArticle().getDesignation()+"quantite"+pro.getQteCadeau());
		}
		
		return promotions;
	}

	@Override
	public List<Promotion> getPromotions(Long idArticle) {
		
		return promotionRepository.getPromotions(idArticle);
	}
	@Override
	public List<Mouvement> getListPerimes(String date) {
		return mouvementRepository.getListPerimes(date);
	}
	

	
//	@Autowired
//	private OperationRepository operationRepository;
//	@Autowired
//	private CompteRepository compteRepository;
//	@Autowired
//	private EmployeRepository employeRepository;
//	@Override
//	public boolean verser(String code, double montant, Long CodeEmpl) {
//		Compte cp = compteRepository.findOne(code);
//		Employe emp = employeRepository.findOne(CodeEmpl);
//		Operation o= new Versement();
//		o.setDateOperation(new Date());
//		o.setMontantOperation(montant);
//		o.setCompte(cp);
//		o.setEmploye(emp);
//		operationRepository.save(o);
//		cp.setSolde(cp.getSolde() + montant);
//		return true;
//	}
//
//	@Override
//	public boolean retirer(String code, double montant, Long CodeEmpl) {
//		Compte cp = compteRepository.findOne(code);
//		Employe emp = employeRepository.findOne(CodeEmpl);
//		Operation o= new Retrait();
//		if(cp.getSolde() < montant) throw new RuntimeException("solde insufisant");
//		o.setDateOperation(new Date());
//		o.setMontantOperation(montant);
//		o.setCompte(cp);
//		o.setEmploye(emp);
//		operationRepository.save(o);
//		cp.setSolde(cp.getSolde() - montant);
//		return true;
//	}
//
//	@Override
//	public boolean virement(String code1, String code2, double montant, Long CodeEmpl) {
//		this.retirer(code1, montant, CodeEmpl);
//		this.verser(code2, montant, CodeEmpl);
//		return true;
//	}
//
//	@Override
//	public PageOperation getOperation(String codeCompte, int page, int size) {
//		Page<Operation> ops = operationRepository.getOperations(codeCompte, 
//							  new PageRequest(page, size));
//		PageOperation pOp = new PageOperation();
//		pOp.setOpers(ops.getContent());
//		pOp.setNombreOperations(ops.getNumberOfElements());
//		pOp.setPage(ops.getNumber());
//		pOp.setTotalPages(ops.getTotalPages());
//		pOp.setTotalOperations((int)ops.getTotalElements());
//		
//		return pOp;
//	}

	

	

}
