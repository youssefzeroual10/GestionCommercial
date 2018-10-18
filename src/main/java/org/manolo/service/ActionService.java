package org.manolo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.manolo.entities.Action;
import org.manolo.entities.Article;
import org.manolo.entities.User;
import org.manolo.metier.ActionMetier;
import org.manolo.metier.ArticleMetier;
import org.manolo.metier.PageAction;
import org.manolo.metier.PageArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController


public class ActionService {
	@Autowired
	private ActionMetier actionMetier;
	@RequestMapping(value = "/actions", method = RequestMethod.POST)
	public Action saveAction(@RequestParam(required = false) MultipartFile facture,@RequestParam String description,@RequestParam double montant,@RequestParam String dateAction,@RequestParam String dateAlert,@RequestParam boolean paye,@RequestParam boolean alert,@RequestParam String immatriculation,@RequestParam Long idTypeAction) {
		return actionMetier.saveAction( facture, description, montant, dateAction,dateAlert, paye, alert,immatriculation, idTypeAction);
	}
	@RequestMapping(value = "/actionsUpdate", method = RequestMethod.POST)
	public Action updateAction(@RequestParam Long idAction,@RequestParam(required = false) MultipartFile facture,@RequestParam String description,@RequestParam double montant,@RequestParam String dateAction,@RequestParam String dateAlert,@RequestParam boolean paye,@RequestParam boolean alert,@RequestParam String immatriculation,@RequestParam Long idTypeAction) {
		
		return actionMetier.updateAction(idAction,facture, description, montant, dateAction,dateAlert, paye, alert,immatriculation, idTypeAction);
	}
	@RequestMapping(value = "/actions/{idAction}", method = RequestMethod.DELETE)
	public void deleteAction(@PathVariable Long idAction) {
		actionMetier.deleteAction(idAction);
	}
	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public PageAction getAllActions(@RequestParam int size,@RequestParam int page) {
		return actionMetier.getAllActions(size, page);
	}
	@RequestMapping(value = "/actionsByVehicule", method = RequestMethod.GET)
	public PageAction getActionsByVehicule(@RequestParam String immatriculation,@RequestParam int size,@RequestParam int page) {
		return actionMetier.getActionsByVehicule(immatriculation, size, page);
	}
	@RequestMapping(value = "/alerteAction", method = RequestMethod.GET)
	public List<Action> getActionsAlert(@RequestParam int moisCourant,@RequestParam int moisProchain) {
		System.out.println(moisCourant);
		System.out.println(moisProchain);
		return actionMetier.getAlertActions(moisCourant, moisProchain);
	}
	@RequestMapping(value = "/actions/{idAction}", method = RequestMethod.GET)
	public Action getAction(@PathVariable Long idAction) {
		return actionMetier.getAction(idAction);
	}
	@RequestMapping(value = "/getActions", method = RequestMethod.GET)
	public List<Action> getAllActions() {
		return actionMetier.getAllActions();
	}
	@RequestMapping(value = "/getBenificeByUser", method = RequestMethod.GET)
	public double getBenificeByUser(@RequestParam String idUser,@RequestParam int mois,@RequestParam int annee) {
		return actionMetier.getBenificeByUser(idUser, mois, annee);
	}
	@RequestMapping(value = "/getBenifice", method = RequestMethod.GET)
	public List<User>  getBenifice(@RequestParam int mois,@RequestParam int annee) {
		return actionMetier.getBenifice(mois, annee);
	}
	
	
	
	
		
}
