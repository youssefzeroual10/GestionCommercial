package org.manolo.metier;

import java.util.List;

import org.manolo.dao.EtatRepository;
import org.manolo.dao.GenerateurCodeRepository;
import org.manolo.entities.Categorie;
import org.manolo.entities.Etat;
import org.manolo.entities.GenerateurCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class GenerateurCodeMetierImpl  implements GenerateurCodeMetier{
	
	
	
	@Autowired 
	private GenerateurCodeRepository generateurCodeRepository;
	
	@Override
	public List<GenerateurCode> saveCode(GenerateurCode code)  {
		generateurCodeRepository.save(code);
		return generateurCodeRepository.findAll();
	}

	@Override
	public void deleteCode(Long id) {
		generateurCodeRepository.delete(id);
		
	}

	@Override
	public PageGenerateurCode getAllCode(int size, int page) {
		Page<GenerateurCode> ops = generateurCodeRepository.getAllCode (new PageRequest(page, size));
		PageGenerateurCode pEt = new PageGenerateurCode();
		pEt.setCodes(ops.getContent());
		pEt.setNombreCode(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalCodes((int)ops.getTotalElements());
		return pEt; 
	}

	@Override
	public List<GenerateurCode> getCodes() {
		
		return generateurCodeRepository.findAll();
	}
}
