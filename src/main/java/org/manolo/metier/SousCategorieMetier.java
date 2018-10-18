package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Quartier;
import org.manolo.entities.SousCategorie;
import org.springframework.data.domain.Page;

public interface SousCategorieMetier {
	public SousCategorie saveSousCategorie(SousCategorie sCat);
	public SousCategorie updateSousCategorie(Long idCategorie,Long idSousCategorie,String libelle);
	public void deleteSousCategorie(Long id);
	public PageSousCategorie getAllSousCategories(int size,int page);
	public PageSousCategorie getBySousCategoriesMotCle(String motCle,int size,int page);
	public SousCategorie getSousCategorie(Long id);
	public List<SousCategorie> getAllSousCategories();
	public List<SousCategorie> getSousCatByCat(Long idCategorie);

}
