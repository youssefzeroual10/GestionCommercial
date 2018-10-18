package org.manolo.metier;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.manolo.dao.ActionRepository;
import org.manolo.dao.TypeActionRepository;
import org.manolo.dao.UserRepository;
import org.manolo.dao.VehiculeRepository;
import org.manolo.entities.TypeAction;
import org.manolo.entities.User;
import org.manolo.entities.Vehicule;
import org.manolo.entities.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
@Transactional
public class ActionMetierImpl  implements ActionMetier{
	@Autowired 
	private ActionRepository actionRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private TypeActionRepository typeActionRepository;
	@Autowired 
	private VehiculeRepository vehiculeRepository;
	@Value("${imagesDir}")
	private String  imagesDir ;
	

	@Override
	public Action updateAction(Long idAction,MultipartFile facture,String description,double montant,String dateAction,String dateAlert,boolean paye,boolean alert,String immatriculation,Long idTypeAction) {
		Action action=null;
		//boolean isEmpty = facture == null || reference.trim().length() == 0;
		//facture =null;
		if(actionRepository.getOne(idAction)==null) throw new RuntimeException("Cette action n'exsiste pas !!!");
		else{
			action = actionRepository.getOne(idAction);
			Vehicule vehicule = vehiculeRepository.findOne(immatriculation);
			TypeAction typeAction = typeActionRepository.findOne(idTypeAction);
			String dossier =  imagesDir+"/"+"Action"+"/"+action.getIdAction();
			File directory = new File(dossier);
			if(facture != null && !facture.isEmpty()){
				String photo = dossier+"/"+facture.getOriginalFilename();
					try {
						if(directory.exists()){
							
							File[] f = directory.listFiles();
							for(int i=0;i<f.length;i++){
								System.out.println(" hello hi every body");
								f[i].deleteOnExit();
								f[i].delete();
							}
						}else{
							//creation d'un repertoire qui contient le nom comme reference
							File dir = new File (dossier);
							dir.mkdirs();	
						}
						facture.transferTo(new File(photo));
						action.setFacture(facture.getOriginalFilename());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				}
				action.setAlert(alert);
				action.setDateAction(dateAction);
				action.setDateAlert(dateAlert);
				action.setDescription(description);
				action.setMontant(montant);
				action.setPaye(paye);
				action.setTypeAction(typeAction);
				action.setVehicule(vehicule);

		}

		return actionRepository.save(action);
	}

	@Override
	public void deleteAction(Long idAction) {
			Action action = actionRepository.findOne(idAction);
			String rep = imagesDir+"/"+"Action"+"/"+actionRepository.getOne(idAction).getIdAction();
			File file = new File(rep);
			File[] files = file.listFiles();
		    if(files!=null) { //some JVMs return null for empty dirs
		        for(File f: files) {
		            if(f.isDirectory()) {
		            	File[] fs = f.listFiles();
		            	if(fs!=null){
		            		for(File ff : fs){
		            			ff.delete();
		            		}
		            	}
		            	f.delete();
		            } else {
		                f.delete();
		            }
		        }
		    }
			file.delete();
			
		actionRepository.delete(action);
	}

	@Override
	public PageAction getAllActions(int size, int page) {
		Page<Action> ops = actionRepository.getAllActions(new PageRequest(page, size));
		PageAction ptx = new PageAction();
		ptx.setActions(ops.getContent());
		ptx.setNombreActions(ops.getNumberOfElements());
		ptx.setPage(ops.getNumber());
		ptx.setTotalPages(ops.getTotalPages());
		ptx.setTotalActions((int)ops.getTotalElements());
		return ptx;
	}

	@Override
	public Action getAction(Long id) {
		return actionRepository.findOne(id);
	}

	@Override
	public List<Action> getAllActions() {
		return actionRepository.findAll();
	}

	@Override
	public PageAction getActionsByVehicule(String immatriculation, int size, int page) {
	
		Page<Action> ops = actionRepository.getActionsByVehicule(immatriculation,(new PageRequest(page, size)));
		PageAction ptx = new PageAction();
		ptx.setActions(ops.getContent());
		ptx.setNombreActions(ops.getNumberOfElements());
		ptx.setPage(ops.getNumber());
		ptx.setTotalPages(ops.getTotalPages());
		ptx.setTotalActions((int)ops.getTotalElements());
		return ptx;
	}

	@Override
	public Action saveAction(MultipartFile facture, String description, double montant, String dateAction,String dateAlert, boolean paye,
			boolean alert, String immatriculation, Long idTypeAction) {
		Vehicule vehicule = vehiculeRepository.findOne(immatriculation);
		TypeAction typeAction = typeActionRepository.findOne(idTypeAction);
		String fileName = null;
		Action action = new Action();
    	String repertoire = imagesDir+"/"+"Action"+"/"+actionRepository.getNextAutoIncrement();
		if (facture != null && facture.getSize() >0) {
	       try {
	    	
	    	  fileName = facture.getOriginalFilename();
	    	  File dir = new File (repertoire);
	    	  dir.mkdirs();
	          byte[] bytes = facture.getBytes();
	          BufferedOutputStream buffStream = 
	              new BufferedOutputStream(new FileOutputStream(new File(repertoire+"/" + fileName)));
	          buffStream.write(bytes);
	              buffStream.close();
	              action.setAlert(alert);
	      		action.setDateAction(dateAction);
	      		action.setDateAlert(dateAlert);
	      		action.setDescription(description);
	      		action.setFacture(facture.getOriginalFilename());
	      		action.setMontant(montant);
	      		action.setPaye(paye);
	      		action.setTypeAction(typeAction);
	      		action.setVehicule(vehicule);
	            } catch (Exception e) {
	            	System.out.println( "You failed to upload " + fileName + ": " + e.getMessage());
	            }
	       
        }
		if(facture==null || facture.equals("null")){
			action.setAlert(alert);
			action.setDateAction(dateAction);
			action.setDescription(description);
			action.setMontant(montant);
			action.setPaye(paye);
			action.setTypeAction(typeAction);
			action.setVehicule(vehicule);
		}
		
		return actionRepository.save(action);
		
	}

	@Override
	public List<Action> getAlertActions(int moisCourant, int moisProchain) {
		return actionRepository.getAlertActions(moisCourant, moisProchain);
	}

	@Override
	public double getBenificeByUser(String idUser, int mois, int annee) {
		List<User> users = userRepository.findAll();
		for(User chauffeurs:users){
			double commandesUser = actionRepository.getCmdByUsers(chauffeurs.getIdUser()+"", mois, annee);
			double actionsUser = actionRepository.getActionByUser(chauffeurs.getIdUser()+"", mois, annee);
			System.out.println(commandesUser-actionsUser);
		}
		double commandesUser = actionRepository.getCmdByUsers(idUser, mois, annee);
		double actionsUser = actionRepository.getActionByUser(idUser, mois, annee);
		return  commandesUser - actionsUser;
	}

	@Override
	public List<User> getBenifice(int mois, int annee) {
		List<User> users = userRepository.findAll();
		
		User chauffeur = null;
		double montantCommandes;
		double montantActions;//actionRepository.getActionByUser("n344235", mois, annee);
		for(User chauffeurs:users){
			String idUser= chauffeurs.getIdUser();
			chauffeur = userRepository.findOne(chauffeurs.getIdUser());
			//List<Commande> commandes = actionRepository.getListCommandesByUser(chauffeurs.getIdUser(), mois, annee);
			//List<Action> actions = actionRepository.getListActionByUser(chauffeurs.getIdUser(), mois, annee);
			System.out.println("chauffeur"+idUser);
			montantCommandes = actionRepository.getCmdByUsers(idUser, mois, annee);
			//montantActions = actionRepository.getActionByUser(chauffeurs.getIdUser().toString(), mois, annee);
			//chauffeur.setBenifice(montantCommandes-montantActions);
			//chauffeur.setCommande(commandes);
			//chauffeur.setAction(actions);
			userRepository.save(chauffeurs);
			
		}
		for(User chauffeurs:users){
			System.out.println("chauffeur"+chauffeurs.getNom());
			System.out.println("chauffeur"+chauffeurs.getBenifice());
			/*for(Commande commandes:chauffeurs.getCommande()){
				System.out.println("commandes"+commandes.getIdCommande());
			}
			for(Action actions:chauffeurs.getAction()){
				System.out.println("commandes"+actions.getIdAction());
			}*/
		}
		
		return users;
	}
}
