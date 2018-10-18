package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Action;
import org.manolo.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface ActionMetier {
	public Action saveAction(MultipartFile facture,String description,double montant,String dateAction,String dateAlert,boolean paye,boolean alert,String immatriculation,Long idTypeAction);
	public Action updateAction(Long idAction,MultipartFile facture,String description,double montant,String dateAction,String dateAlert,boolean paye,boolean alert,String immatriculation,Long idTypeAction);
	public void deleteAction(Long idAction);
	public PageAction getAllActions(int size,int page);
	public PageAction getActionsByVehicule(String immatriculation,int size,int page);
	public Action getAction(Long id);
	public List<Action> getAllActions();
	public List <Action> getAlertActions(int moisCourant,int moisProchain);
	//Bénifice par chauffeur
	public double getBenificeByUser(String idUser,int mois,int annee);
	public List<User>  getBenifice(int mois,int annee);

}
