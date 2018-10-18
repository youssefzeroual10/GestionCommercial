package org.manolo.metier;

import java.util.List;
import org.manolo.entities.Avance;
import org.manolo.entities.Paiement;
import org.springframework.web.multipart.MultipartFile;


public interface PaiementMetier {
	public Paiement  credit(String idCommande, double montant,double avance);
	public Paiement  creditP(String idCommande, double montant,double avance);
	public Paiement  credits(String idCommande, double montant);
	public Paiement  espece(String idCommande, double montant);
	public Paiement  cheque(String idCommande,String datePaiement ,double montant,MultipartFile cheque);
	public Paiement  especeP(String idCommande, double montant);
	public Paiement  chequeP(String idCommande, String datePaiement,double montant,MultipartFile cheque);
	public List<Paiement> getPaiements(String idCommande);
	public List<Avance> getAvanceCommande(String idCommande);
	public boolean addCadeau(String idCommande);
	public boolean addCadeau2(String idCommande,String cin);
	public Long getSumAvance(String idCommande);
	public Long getReste(String idCommande);
	public List<Paiement> getAlerteCheque(String date);





	
}
