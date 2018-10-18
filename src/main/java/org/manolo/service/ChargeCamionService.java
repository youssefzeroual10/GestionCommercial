package org.manolo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manolo.entities.Etat;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Paiement;
import org.manolo.entities.User;
import org.manolo.entities.Article;
import org.manolo.entities.ChargeCamion;
import org.manolo.entities.Client;
import org.manolo.entities.Commande;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.MouvementChargeMetier;
import org.manolo.metier.MouvementMetier;
import org.manolo.metier.PageChargeCamion;
import org.manolo.metier.PageClient;
import org.manolo.metier.PageCommande;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.ChargeCamionMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PagePaiement;
import org.manolo.metier.PageUser;
import org.manolo.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@RestController
public class ChargeCamionService {
	@Autowired
	private ChargeCamionMetier chargeCamionMetier;
	@Autowired
	private UserMetier userMetier;
	@Autowired
	private MouvementChargeMetier mouvementChargeMetier;
	public List<ChargeCamion> getAllChargesCamion() {
		return chargeCamionMetier.getAllChargesCamion();
	}
	public List<ChargeCamion> getAllChargesCamionEntree() {
		return chargeCamionMetier.getAllChargesCamionEntree();
	}
	public ChargeCamion getCharge(Long idCharge) {
		return chargeCamionMetier.getCharge(idCharge);
	}
	public PageChargeCamion getAllChargesCamionEntree(int size, int page) {
		return chargeCamionMetier.getAllChargesCamionEntree(size, page);
	}
	public PageChargeCamion getAllchargesSortie(int size, int page) {
		return chargeCamionMetier.getAllchargesSortie(size, page);
	}
	@RequestMapping(value = "/chargecamionsortie", method = RequestMethod.POST)
	public ChargeCamion addChargeCamionSortie(Long idCharge, String idClient, User user) {
		return chargeCamionMetier.addChargeCamionSortie(idCharge, idClient, user);
	}
	@RequestMapping(value = "/chargecamionentree", method = RequestMethod.POST)
	public ChargeCamion addChargeCamionEntree(HttpServletRequest httpServletRequest, User user) {
		return chargeCamionMetier.addChargeCamionEntree(httpServletRequest, user);
	}

	
}
