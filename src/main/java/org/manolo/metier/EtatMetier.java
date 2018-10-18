package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Etat;

public interface EtatMetier {
	public Etat saveEtat(Etat etat);
	public Etat updateEtat(Etat etat);
	public void deleteEtat(Long id);
	public PageEtat getAllEtat(int size,int page);
	public PageEtat getByEtatsMotCle(String motCle,int size,int page);
	public Etat getEtat(Long id);
	public List<Etat> getAllEtats();
}
