package org.manolo.metier;

import java.util.List;

import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.springframework.data.domain.Page;

public interface GenerateurIdCommandeMetier {
	public Long getNextAutoIncrement();
	
	
}
