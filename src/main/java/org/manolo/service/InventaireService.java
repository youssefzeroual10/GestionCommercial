package org.manolo.service;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.manolo.entities.Inventaire;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Article;
import org.manolo.metier.InventaireMetier;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.PageInventaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class InventaireService {
	@Value("${imagesDir}")
	private String  imagesDir ;
	@Autowired
	private InventaireMetier inventaireMetier;
	@Autowired
	private ArticleMetier articleMetier;
	@RequestMapping(value = "/inventaire.pdf", method = RequestMethod.GET)
	public @ResponseBody void inventairePdf (HttpServletResponse response,Date dateStart,Date dateEnd) {
		
		//this.entreePdf(response, dateStart, dateEnd);
		//this.sortiePdf(response, dateStart, dateEnd);
		//this.cadeauPdf(response, dateStart, dateEnd);
		//this.articlesPdf(response);
		//this.defPdf(response, dateStart, dateEnd);
	}
	@RequestMapping(value = "/entree.pdf", method = RequestMethod.GET)
	public @ResponseBody void entreePdf (HttpServletResponse response,@RequestParam String dateStart,@RequestParam String dateEnd,@RequestParam Long idArticle) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart1 = formatter.parse(dateStart);
			Date dateEnd1 = formatter.parse(dateEnd);
			List<Mouvement> entree = inventaireMetier.getInventaireEntree(dateStart1, dateEnd1,idArticle);
			if(!entree.isEmpty()){
				java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/entreeInventaire.jrxml");
				JasperDesign design = JRXmlLoader.load(jasperStream);
				JasperReport report = JasperCompileManager.compileReport(design);
				Map<String,Object> parametreMap = new HashMap();
				JRDataSource JRDataSource = new JRBeanCollectionDataSource(entree);
				parametreMap.put("entree",entree);
				parametreMap.put("designation",articleMetier.getArticle(idArticle).getDesignation());
				JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Diposition", "inline; filename=entree.pdf");
				final java.io.OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				
				String repertoire = imagesDir+reportDate;
				File dir = new File (repertoire);
				if(dir.exists()){
					String sous_rep = repertoire+"/"+"entree";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"entree_"+designation+".pdf");
			
				}else{
					dir.mkdirs();
					String sous_rep = repertoire+"/"+"entree";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"entree_"+designation+".pdf");
			
				}
				
				
				
			}
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/deffs.pdf", method = RequestMethod.GET)
	public @ResponseBody void defPdf (HttpServletResponse response,@RequestParam String dateStart,@RequestParam String dateEnd,@RequestParam Long idArticle) {
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart1 = formatter.parse(dateStart);
			Date dateEnd1 = formatter.parse(dateEnd);
			List<Mouvement> deffs = inventaireMetier.getInventaireDef(dateStart1, dateEnd1,idArticle);
			
			if(!deffs.isEmpty()){
				
				java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/deffInventaire.jrxml");
				JasperDesign design = JRXmlLoader.load(jasperStream);
				JasperReport report = JasperCompileManager.compileReport(design);
				Map<String,Object> parametreMap = new HashMap();
				JRDataSource JRDataSource = new JRBeanCollectionDataSource(deffs);
				parametreMap.put("deffs",deffs);
				JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Diposition", "inline; filename=deffectueuses.pdf");
				final java.io.OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				
				String repertoire = imagesDir+reportDate;
				File dir = new File (repertoire);
				if(dir.exists()){
					String sous_rep = repertoire+"/"+"defectueux";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"defectueux_"+designation+".pdf");
			
				}else{
					dir.mkdirs();
					String sous_rep = repertoire+"/"+"defectueux";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"defectueux_"+designation+".pdf");
			
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/sortie.pdf", method = RequestMethod.GET)
	public @ResponseBody void sortiePdf (HttpServletResponse response,@RequestParam String dateStart,@RequestParam String dateEnd,@RequestParam Long idArticle) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart1 = formatter.parse(dateStart);
			Date dateEnd1 = formatter.parse(dateEnd);
			List<Mouvement> sortie = inventaireMetier.getInventaireSortie(dateStart1, dateEnd1,idArticle);
			if(!sortie.isEmpty())
			{
				java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/sortieInventaire.jrxml");
				JasperDesign design = JRXmlLoader.load(jasperStream);
				JasperReport report = JasperCompileManager.compileReport(design);
				Map<String,Object> parametreMap = new HashMap();
				JRDataSource JRDataSource = new JRBeanCollectionDataSource(sortie);
				parametreMap.put("sortie",sortie);
				parametreMap.put("designation",articleMetier.getArticle(idArticle).getDesignation());
				JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Diposition", "inline; filename=sortie.pdf");
				final java.io.OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				
				String repertoire = imagesDir+reportDate;
				File dir = new File (repertoire);
				if(dir.exists()){
					String sous_rep = repertoire+"/"+"sortie";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"sortie_"+designation+".pdf");
			
				}else{
					dir.mkdirs();
					String sous_rep = repertoire+"/"+"sortie";
					File dir2 = new File (sous_rep);
					dir2.mkdirs();
					String designation = articleMetier.getArticle(idArticle).getDesignation();
					JasperExportManager.exportReportToPdfFile(jasperPrint, sous_rep+"/"+"sortie_"+designation+".pdf");
			
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/cadeau.pdf", method = RequestMethod.GET)
	public @ResponseBody void cadeauPdf (HttpServletResponse response,@RequestParam String dateStart,@RequestParam String dateEnd,@RequestParam Long idArticle) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart1 = formatter.parse(dateStart);
			Date dateEnd1 = formatter.parse(dateEnd);
			List<Mouvement> entree = inventaireMetier.getInventaireCadeau(dateStart1, dateEnd1,idArticle);
			if(!entree.isEmpty()){
				java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/CadeauInventaire.jrxml");
				JasperDesign design = JRXmlLoader.load(jasperStream);
				JasperReport report = JasperCompileManager.compileReport(design);
				Map<String,Object> parametreMap = new HashMap();
				
				JRDataSource JRDataSource = new JRBeanCollectionDataSource(entree);
				parametreMap.put("entree",entree);
				parametreMap.put("designation",articleMetier.getArticle(idArticle).getDesignation());
				JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Diposition", "inline; filename=cadeau.pdf");
				final java.io.OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				
				String repertoire = imagesDir+reportDate+"/"+"cadeau";
				File dir = new File (repertoire);
				dir.mkdirs();
				String designation = articleMetier.getArticle(idArticle).getDesignation();
				JasperExportManager.exportReportToPdfFile(jasperPrint, repertoire+"/"+"cadeau_"+designation+".pdf");
				System.out.println(repertoire+"/"+"cadeau.pdf");
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/articles.pdf", method = RequestMethod.GET)
	public @ResponseBody void articlesPdf (HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/inventaire.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Article> artilces = inventaireMetier.getInventaireArticle();
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(artilces);
			parametreMap.put("datasource",JRDataSource);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=articlesInventaire.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/inventaire", method = RequestMethod.POST)
	public Inventaire saveInventaire(HttpServletResponse response,@RequestParam String dateStart,@RequestParam String dateEnd) {
		Inventaire inventaire = null;
		try {
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.FRANCE);
		DateFormat format2 = new SimpleDateFormat("YYYY-MM-DD", Locale.FRANCE);
		Date dateStart1=format.parse(dateStart);
		Date dateEnd1=format2.parse(dateEnd);
		
			dateStart1 = format.parse(dateStart);
			dateEnd1 = format2.parse(dateEnd);
			inventaire = inventaireMetier.saveInventaire(dateStart1,dateEnd1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  inventaire;
	}
	@RequestMapping(value = "/getInventaires", method = RequestMethod.GET)
	public PageInventaire getAllInventaires(int size, int page) {
		return inventaireMetier.getAllInventaire(size, page);
	}
	
}
