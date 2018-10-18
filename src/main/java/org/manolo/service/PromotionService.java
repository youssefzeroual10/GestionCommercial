package org.manolo.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.manolo.entities.Etat;
import org.manolo.entities.Promotion;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.entities.Quartier;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.PageArticle;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.ClientMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PagePromotion;
import org.manolo.metier.PageClient;
import org.manolo.metier.PageCommande;
import org.manolo.metier.PageQuartier;
import org.manolo.metier.PromotionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.lowagie.text.pdf.codec.Base64.OutputStream;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@RestController
public class PromotionService {
	@Autowired
	private PromotionMetier promotionMetier;
	@Autowired
	private ArticleMetier articleMetier;
	@Autowired
	private ClientMetier clientMetier;
	@RequestMapping(value = "/promotions", method = RequestMethod.POST)
	public Promotion addPromotion(Promotion promotion) {
		return promotionMetier.addPromotion(promotion);
	}
	@RequestMapping(value = "/promotions", method = RequestMethod.PUT)
	public Promotion updatePromotion(Promotion promotion) {
		return promotionMetier.updatePromotion(promotion);
	}
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.DELETE)
	public void deletePromotion(@PathVariable Long id) {
		promotionMetier.deletePromotion(id);
	}
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.GET)
	public Promotion getPromotion(@PathVariable Long id) {
		return promotionMetier.getPromotion(id);
	}
	@RequestMapping(value = "/articlesallpromo", method = RequestMethod.GET)
	public PagePromotion getAllPromotions(@RequestParam int size, 
			@RequestParam int page) {
		return promotionMetier.getAllPromotions( size, page);
	}
	@RequestMapping(value = "/articlesallpromoclient", method = RequestMethod.GET)
	public PagePromotion getPromotionsWithClient(@RequestParam int size, 
			@RequestParam int page) {
		return promotionMetier.getPromotionsWithClient( size, page);
	}
	@RequestMapping(value = "/promotionsSpecial", method = RequestMethod.POST)
	public Promotion addPromotion2(Promotion promotion) {
		return promotionMetier.addPromotion2(promotion);
	}
	@RequestMapping(value = "/promotionsSpecial/{id}", method = RequestMethod.DELETE)
	public void deletePromotion2(Long idPromotion) {
		promotionMetier.deletePromotion2(idPromotion);
	}
		
}
