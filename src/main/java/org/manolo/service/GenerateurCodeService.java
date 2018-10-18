package org.manolo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.manolo.entities.Client;
import org.manolo.entities.GenerateurCode;
import org.manolo.metier.GenerateurCodeMetier;
import org.manolo.metier.GenerateurCodeMetier;
import org.manolo.metier.PageGenerateurCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class GenerateurCodeService {
	@Autowired
	private GenerateurCodeMetier generateurCodeMetier;
	@RequestMapping(value = "/codes", method = RequestMethod.POST)
	public List<GenerateurCode> save(GenerateurCode code) {
		for(int i=0;i<10;i++){
			GenerateurCode gCode = new GenerateurCode();
			 generateurCodeMetier.saveCode(gCode);
		}
		return generateurCodeMetier.getCodes();
	}
	@RequestMapping(value = "/codes/{id}", method = RequestMethod.DELETE)
	public void deleteGenerateurCode(@PathVariable Long id) {
		generateurCodeMetier.deleteCode(id);
	}
	
	@RequestMapping(value = "/codes", method = RequestMethod.GET)
	public List<GenerateurCode> getCodes() {
		return generateurCodeMetier.getCodes();
	}
	@RequestMapping(value = "/getCodes", method = RequestMethod.GET)
	public PageGenerateurCode getAllCode(int size, int page) {
		return generateurCodeMetier.getAllCode(size, page);
	}

	@RequestMapping(value = "/codes.pdf", method = RequestMethod.GET)
	public @ResponseBody void clientPdf (HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/codes.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<GenerateurCode> codes = generateurCodeMetier.getCodes();
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(codes);
			parametreMap.put("datasource",JRDataSource);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=codes.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
