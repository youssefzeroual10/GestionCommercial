package org.manolo.metier;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.manolo.entities.Entree;
import org.manolo.entities.Mouvement;
import org.manolo.entities.Promotion;
import org.manolo.entities.Sortie;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;


public interface MouvementChargeMetier {
	//public boolean  entree(HttpServletRequest httpServletRequest,String IdUser);//id du chauffeur
	public boolean charger(HttpServletRequest httpServletRequest,String IdUser,int quantite,Long idAtricle,Long idChargeCamion);
	//public boolean  sortie(String IdUser);//id du chauffeur
	public boolean sortir(HttpServletRequest httpServletRequest,int quantite,Long idAtricle,Long idChargeCamion);
	public Mouvement getMouvementCharge(Long idMouvementCharge);
	public Mouvement updateMouvementCharge(Long idMouvementCharge,Long idArticle,int quantite);
	
	


}
