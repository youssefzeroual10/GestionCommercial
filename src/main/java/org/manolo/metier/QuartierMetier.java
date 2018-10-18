package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Quartier;
import org.springframework.data.domain.Page;

public interface QuartierMetier {
	public Quartier saveQuartier(Quartier quartier);
	public Quartier updateQuartier(Long idQuartier,Long idVille,String idUser,String libelle);
	public void deleteQuartier(Long id);
	public PageQuartier getAllQuartier(int size,int page);
	public PageQuartier getByQuartiersMotCle(String motCle,int size,int page);
	public Quartier getQuartier(Long id);
	public List<Quartier> getAllQuartiers();
	public List<Quartier> getQuartiersByVille(Long idVille);
	public List<Quartier> getQuartiersByClient(String id);


	
	
}
