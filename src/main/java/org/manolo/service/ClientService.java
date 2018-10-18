package org.manolo.service;
import org.manolo.entities.Client;
import org.manolo.metier.ClientMetier;
import org.manolo.metier.PageClient;
import org.manolo.metier.PageCommande;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

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
public class ClientService {
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientMetier.getAllClients();
	}
	@RequestMapping(value = "/clients", method = RequestMethod.PUT)
	public Client updateClient( 
			@RequestParam String cin,@RequestParam String nom,@RequestParam String adresse,
			@RequestParam String telephone,@RequestParam Long idQuartier,
			@RequestParam Long idTypeClient,@RequestParam String idUser ) {
		return clientMetier.updateClient(cin, nom,  adresse, telephone, idQuartier, idTypeClient, idUser);
	}
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client addClient( 
			@RequestParam String nom,@RequestParam Long cin,@RequestParam String adresse,
			@RequestParam String telephone,@RequestParam Long idQuartier,
			@RequestParam Long idTypeClient,@RequestParam String idUser ) {
			Code128Bean code128 = new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
			code128.generateBarcode(canvas, "999999999");
			try {
				canvas.finish();
			
			String image_name="barcode.png";
			//write to png file

			FileOutputStream fos = new FileOutputStream("C:\\Users\\zeroual youssef\\workspace\\GestionCommercial\\src\\main\\resources\\static\\report\\"+image_name);
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			createPDF(nom+".pdf",nom);
		return clientMetier.addClient(cin, nom,  adresse, telephone, idQuartier, idTypeClient, idUser);
	}
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable String id) {
		clientMetier.deleteClient(id);
	}
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable String id) {
		return clientMetier.getClient(id);
	}

	@RequestMapping(value = "/getclients", method = RequestMethod.GET)
	public PageClient getAllClients(@RequestParam int size,@RequestParam int page) {
		return clientMetier.getAllClient(size, page);
	}
	@RequestMapping(value = "/clientscredit", method = RequestMethod.GET)
	public PageClient getClientsCredit(@RequestParam int size,@RequestParam int page) {
		return clientMetier.getClientsCredit(size, page);
	}
	public PageClient getByClientsMotCle(String motCle, int size, int page) {
		return clientMetier.getByClientsMotCle(motCle, size, page);
	}
	@RequestMapping(value = "/getclientsbalaye", method = RequestMethod.GET)
	public List<Client> getClientbalaye(@RequestParam Long idQuartier, @RequestParam String idUser,@RequestParam String dateCommande) {
		return clientMetier.getClientbalaye(idQuartier, idUser, dateCommande);
	}
	@RequestMapping(value = "/getclientsnonbalaye", method = RequestMethod.GET)
	public List<Client> getClientNonbalaye(@RequestParam Long idQuartier, @RequestParam String idUser,@RequestParam String dateCommande) {
		return clientMetier.getClientNonbalaye(idQuartier, idUser, dateCommande);
	}
	@RequestMapping(value = "/getcountclient", method = RequestMethod.GET)
	public int getCountClient() {
		return clientMetier.getCountClient();
	}
	@RequestMapping(value = "/commandesbyclient", method = RequestMethod.GET)
	public PageCommande CommandesByClient(@RequestParam String idClient,@RequestParam int size,@RequestParam int page) {
		return clientMetier.CommandesByClient(idClient, size, page);
	}
	@RequestMapping(value = "/clients.pdf", method = RequestMethod.GET)
	public @ResponseBody void clientPdf (HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/CLIENT.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<Client> clients = clientMetier.getAllClients();
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(clients);
			parametreMap.put("datasource",JRDataSource);			
			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametreMap, JRDataSource);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Diposition", "inline; filename=clients.pdf");
			final java.io.OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void createPDF(String pdfFilename,String myString) {
	    Document doc = new Document();
	    PdfWriter docWriter = null;
	    try {
	        docWriter = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\zeroual youssef\\workspace\\GestionCommercial\\src\\main\\resources\\static\\report\\"+pdfFilename));
	        doc.addAuthor("jinujawad");
	        doc.addCreationDate();
	        doc.addProducer();
	        doc.addCreator("chillyfacts.com");
	        doc.addTitle("chillyfacts Barcode test");
	        doc.setPageSize(PageSize.LETTER);
	        doc.open();
	        PdfContentByte cb = docWriter.getDirectContent();

	        Barcode128 code128 = new Barcode128();
	        code128.setCode(myString.trim());
	        code128.setCodeType(Barcode128.CODE128);
	        Image code128Image = code128.createImageWithBarcode(cb, null, null);
	        code128Image.setAbsolutePosition(10, 700);
	        code128Image.scalePercent(125);
	        doc.add(code128Image);

	        BarcodeEAN codeEAN = new BarcodeEAN();
	        codeEAN.setCode(myString.trim());
	        codeEAN.setCodeType(BarcodeEAN.EAN13);      
	        Image codeEANImage = code128.createImageWithBarcode(cb, null, null);
	        codeEANImage.setAbsolutePosition(10, 600);
	        codeEANImage.scalePercent(125);
	        doc.add(codeEANImage);
	    } catch (DocumentException ex) {
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (doc != null) {
	            doc.close();
	        }
	        if (docWriter != null) {
	            docWriter.close();
	        }
	    }
	}
	
	
}
