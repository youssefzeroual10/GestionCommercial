package org.manolo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.manolo.entities.Client;
import org.manolo.entities.GenerateurCode;
import org.manolo.metier.GenerateurCodeMetier;
import org.manolo.metier.GenerateurIdCommandeMetier;
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
public class GenerateurIdCommandeService {
	@Autowired
	private GenerateurIdCommandeMetier generateurIdCommandeMetier;

	
	@RequestMapping(value = "/getNextAutoIncrement", method = RequestMethod.GET)
	public Long getNextAutoIncrement() {
		return generateurIdCommandeMetier.getNextAutoIncrement();
	}
		
}
