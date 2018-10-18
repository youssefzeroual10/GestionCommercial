package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Ville;
import org.springframework.data.domain.Page;

public interface VilleMetier {
	public Ville saveVille(Ville ville);
	public Ville updateVille(Ville ville);
	public void deleteVille(Long id);
	public PageVille getAllVille(int size,int page);
	public PageVille getByVillesMotCle(String motCle,int size,int page);
	public Ville getVille(Long id);
	public List<Ville> getAllVilles();
}
