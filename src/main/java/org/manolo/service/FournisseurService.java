package org.manolo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.manolo.entities.Article;
import org.manolo.entities.Client;
import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.manolo.entities.Quartier;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.FournisseurMetier;
import org.manolo.metier.PageArticle;
import org.manolo.metier.PageCommande;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PageFournisseur;
import org.manolo.metier.PageQuartier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@RestController
public class FournisseurService {
	@Autowired
	private FournisseurMetier fournisseurMetier;
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.PUT)
	public Fournisseur updateFournisseur( Fournisseur fournisseur ) {
		return fournisseurMetier.updateFournisseur(fournisseur);
	}
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.POST)
	public Fournisseur saveFournisseur( Fournisseur fournisseur ) {
		return fournisseurMetier.addFournisseur(fournisseur);
	}
	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.DELETE)
	public void deleteFournisseur(@PathVariable Long id) {
		fournisseurMetier.deleteFournisseur(id);
	}
	@RequestMapping(value = "/fournisseurs/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Long id) {
		return fournisseurMetier.getFournisseur(id);
	}
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> getAllFournisseur() {
		return fournisseurMetier.getAllFournisseurs();
	}
	@RequestMapping(value = "/getfournisseurs", method = RequestMethod.GET)
	public PageFournisseur getAllFournisseurs(@RequestParam int size,@RequestParam int page) {
		return fournisseurMetier.getAllFournisseur(size, page);
	}
	@RequestMapping(value = "/articlesbyfournisseur", method = RequestMethod.GET)
	public PageArticle ArticlesByFournisseur(@RequestParam Long idFournisseur,@RequestParam int size,@RequestParam int page) {
		return fournisseurMetier.ArticlesByFournisseur(idFournisseur,size,page);
	}
	@RequestMapping(value = "/commandesbyfournisseur", method = RequestMethod.GET)
	public PageCommande CommandesByFournisseur(@RequestParam Long idFournisseur,@RequestParam int size,@RequestParam int page) {
		return fournisseurMetier.CommandesByFournisseur(idFournisseur,size,page);
	}
	@RequestMapping(value = "/fournisseurs.pdf", method = RequestMethod.GET)
	public @ResponseBody void clientPdf (HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/Four.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Fournisseur> fournisseurs = fournisseurMetier.getAllFournisseurs();
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(fournisseurs);
			parametreMap.put("datasource",JRDataSource);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=fournisseurs.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
