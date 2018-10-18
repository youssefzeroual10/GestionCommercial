package org.manolo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manolo.entities.Etat;
import org.manolo.entities.Fournisseur;
import org.manolo.entities.User;
import org.manolo.entities.Quartier;
import org.manolo.entities.Role;
import org.manolo.metier.EtatMetier;
import org.manolo.metier.PageClient;
import org.manolo.metier.UserMetier;
import org.manolo.metier.PageEtat;
import org.manolo.metier.PageUser;
import org.manolo.metier.PageQuartier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.ui.Model;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;*/
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
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
@RestController
public class UserService {
	@Autowired
	private UserMetier userMetier;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userMetier.getAllUsers();
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUserAuth(@RequestParam String idUser,@RequestParam String password) {
		return userMetier.getUserAuth(idUser,password);
	}
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestParam String idUser,@RequestParam String nom,
			@RequestParam String prenom,@RequestParam String email,@RequestParam String adresse,
			@RequestParam String telephone,
			@RequestParam Collection<Role> role,@RequestParam String dateEmbauche ) {
			
		return userMetier.updateUser(idUser, nom, prenom, email, adresse, telephone, role, dateEmbauche);
	}
	@RequestMapping(value = "/users2", method = RequestMethod.PUT
			,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public User updateUser2(@RequestParam String idUser,@RequestParam String nom,
			@RequestParam String prenom,@RequestParam String email,@RequestParam String adresse,
			@RequestParam String telephone,@RequestParam String pwd1,
			@RequestParam Collection<Role> role,@RequestParam String dateEmbauche,@RequestParam 	String pwdAncien ) {
			
		return userMetier.updateUser2(idUser, nom, prenom, email, adresse, telephone, role, dateEmbauche,pwdAncien,pwd1);
	}
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(@RequestParam String idUser,@RequestParam String password,@RequestParam String nom,
			@RequestParam String prenom,@RequestParam String email,@RequestParam String adresse,
			@RequestParam String telephone,
			@RequestParam Collection<Role> role,@RequestParam String dateEmbauche ) {
		return userMetier.addUser(idUser, password, nom, prenom, email, adresse, telephone, role, dateEmbauche);
	}
	@RequestMapping(value = "/users/{id:.*}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String id) {
		System.out.println(id);
		userMetier.deleteUser(id);
	}
	
	@RequestMapping(value = "/users/{id:.*}", method = RequestMethod.GET)
	public User getUser(@PathVariable String id,HttpServletRequest httpServletRequest) {
		HttpSession  httpSession= httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		System.out.println(id);
		User user  = userMetier.getUser(username);
		User user2 = userMetier.getUser(id);
		User user3 = null;
		if(user.getIdUser().equals(user2.getIdUser())){
				user3 = user;
		}
		else{throw new RuntimeException("Vous n'avez pas le droit ");}
		return user3;
	}

	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public PageUser getAllUsers(@RequestParam int size,@RequestParam int page) {
		return userMetier.getAllUser(size, page);
	}
	
	public PageUser getByUsersMotCle(String motCle, int size, int page) {
		return userMetier.getByUsersMotCle(motCle, size, page);
	}
	@RequestMapping(value = "/getcountuser", method = RequestMethod.GET)

	public int getCountUser() {
		return userMetier.getCountUser();
	}
	@RequestMapping(value = "/users.pdf", method = RequestMethod.GET)
	public @ResponseBody void clientPdf (HttpServletResponse response) {
		try {
			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/static/report/USER.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			Map<String,Object> parametreMap = new HashMap();
			List<User> users = userMetier.getAllUsers();
			JRDataSource JRDataSource = new JRBeanCollectionDataSource(users);
			String title ="youssef";
			User user =userMetier.getUser("n344235");
			parametreMap.put("datasource",JRDataSource);
			parametreMap.put("user", user);
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
	@RequestMapping(value = "/userscredit", method = RequestMethod.GET)
	public PageUser getUsersCredit(@RequestParam int size,@RequestParam int page) {
		return userMetier.getUsersCredit(size, page);
	}
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public User getUser(HttpServletRequest httpServletRequest) {
		HttpSession  httpSession= httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		User user = userMetier.getUser(username);
		return user;		
	}
	
}
