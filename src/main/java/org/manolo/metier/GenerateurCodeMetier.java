package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.springframework.data.domain.Page;

public interface GenerateurCodeMetier {
	public List<GenerateurCode> saveCode(GenerateurCode code);
	public List<GenerateurCode> getCodes();
	public void deleteCode(Long id);
	public PageGenerateurCode getAllCode(int size,int page);
	
}
