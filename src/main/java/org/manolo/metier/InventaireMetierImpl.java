package org.manolo.metier;

import java.util.Date;
import java.util.List;

import org.manolo.dao.ArticleRepository;
import org.manolo.dao.InventaireRepository;
import org.manolo.entities.Article;
import org.manolo.entities.GenerateurCode;
import org.manolo.entities.Inventaire;
import org.manolo.entities.Mouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class InventaireMetierImpl implements InventaireMetier{
	@Autowired 
	private InventaireRepository inventaireRepository;
	@Autowired 
	private ArticleRepository articleRepository;
	@Override
	public List<Mouvement> getInventaireEntree(Date dateStart, Date dateEnd,Long idArticle) {
		return inventaireRepository.getInventaireEntree(dateStart, dateEnd,idArticle);
	}
	@Override
	public List<Mouvement> getInventaireSortie(Date dateStart, Date dateEnd,Long idArticle) {
		return inventaireRepository.getInventaireSortie(dateStart, dateEnd,idArticle);
	}
	@Override
	public List<Mouvement> getInventaireCadeau(Date dateStart, Date dateEnd,Long idArticle) {
		return inventaireRepository.getInventaireCadeau(dateStart, dateEnd,idArticle);
	}
	@Override
	public List<Mouvement> getInventaireDef(Date dateStart, Date dateEnd,Long idArticle) {
		return inventaireRepository.getInventaireDef(dateStart, dateEnd,idArticle);
	}
	@Override
	public List<Article> getInventaireArticle() {
		return articleRepository.findAll();
	}
	@Override
	public Inventaire saveInventaire(Date dateStart, Date dateEnd) {
		return inventaireRepository.save(new Inventaire(new Date(),dateStart,dateEnd));
	}
	@Override
	public PageInventaire getAllInventaire(int size, int page) {
		Page<Inventaire> ops = inventaireRepository.getAllInventaires(new PageRequest(page, size));
		PageInventaire pEt = new PageInventaire();
		pEt.setInventaires(ops.getContent());
		pEt.setNombreInventaires(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalInventaires((int)ops.getTotalElements());
		return pEt; 
	}
}
