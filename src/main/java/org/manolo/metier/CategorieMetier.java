package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Categorie;

public interface CategorieMetier {
	public Categorie saveCategorie(Categorie cat);
	public Categorie updateCategorie(Categorie cat);
	public void deleteCategorie(Long id);
	public PageCategorie getAllCategories(int size,int page);
	public PageCategorie getByCategoriesMotCle(String motCle,int size,int page);
	public Categorie getCategorie(Long id);
	public List<Categorie>  getAllCategories();
}
