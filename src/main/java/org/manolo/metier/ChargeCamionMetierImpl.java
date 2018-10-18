package org.manolo.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.manolo.dao.ClientRepository;
import org.manolo.dao.ChargeCamionRepository;
import org.manolo.dao.MouvementRepository;
import org.manolo.dao.PromotionRepository;
import org.manolo.dao.UserRepository;
import org.manolo.entities.ChargeCamion;
import org.manolo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChargeCamionMetierImpl  implements ChargeCamionMetier{
	@Autowired
	ChargeCamionRepository chargeCamionRepository;
	@Autowired
	MouvementRepository mouvementRepository;
	@Autowired
	PromotionRepository promotionRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClientRepository clientRepository;
	@Value("${imagesDir}")
	private String  imagesDir ;
	@Override
	public List<ChargeCamion> getAllChargesCamion() {
		return chargeCamionRepository.findAll();
	}
	@Override
	public List<ChargeCamion> getAllChargesCamionEntree() {
		return chargeCamionRepository.gettListChargesCamionEntree();
	}
	@Override
	public ChargeCamion getCharge(Long idCharge) {
		return chargeCamionRepository.getOne(idCharge);
	}
	@Override
	public PageChargeCamion getAllChargesCamionEntree(int size, int page) {
		Page<ChargeCamion> opc = chargeCamionRepository.getAllChargesCamionEntree( new PageRequest(page, size));
		PageChargeCamion pCo = new PageChargeCamion();
		pCo.setChargeCamion(opc.getContent());
		pCo.setNombreChargeCamions(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalChargeCamions((int)opc.getTotalElements());
		return pCo;
	}
	@Override
	public PageChargeCamion getAllchargesSortie(int size, int page) {
		Page<ChargeCamion> opc = chargeCamionRepository.getAllChargesCamionSortie( new PageRequest(page, size));
		PageChargeCamion pCo = new PageChargeCamion();
		pCo.setChargeCamion(opc.getContent());
		pCo.setNombreChargeCamions(opc.getNumberOfElements());
		pCo.setPage(opc.getNumber());
		pCo.setTotalPages(opc.getTotalPages());
		pCo.setTotalChargeCamions((int)opc.getTotalElements());
		return pCo;
	}
	@Override
	public ChargeCamion addChargeCamionSortie(Long idCharge, String idClient, User user) {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd" ); 
		String date = formatter.format(new Date());
		ChargeCamion chargeCamion= chargeCamionRepository.findOne(idCharge);
		if(chargeCamion!=null) throw new RuntimeException("cette charge  existe deja");
		ChargeCamion chargeCam =new ChargeCamion();
		chargeCam.setChauffeur(user);
		chargeCam.setDateCharge(date);
		chargeCam.setTypeChargeCamion(false);
		chargeCamionRepository.save(chargeCam);
		return chargeCam;
	}
	@Override
	public ChargeCamion addChargeCamionEntree(HttpServletRequest httpServletRequest,User user) {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd" ); 
		String date = formatter.format(new Date());
		HttpSession  httpSession= httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		User supperieur  = userRepository.getUser(username);
		ChargeCamion chargeCamion = new ChargeCamion();
		chargeCamion.setChauffeur(user);
		chargeCamion.setDateCharge(date);
		chargeCamion.setSuperieur(supperieur);
		chargeCamion.setTypeChargeCamion(true);
		chargeCamionRepository.save(chargeCamion);
		return chargeCamion;
	}
	


}
