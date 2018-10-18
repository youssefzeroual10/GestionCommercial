package org.manolo.metier;

import java.util.List;

import org.manolo.dao.TypeActionRepository;
import org.manolo.entities.TypeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TypeActionMetierImpl  implements TypeActionMetier{
	@Autowired 
	private TypeActionRepository typeActionRepository;
	@Override
	public TypeAction saveTypeAction(TypeAction cat) {
		return typeActionRepository.save(cat);
	}

	@Override
	public TypeAction updateTypeAction(TypeAction cat) {
		return typeActionRepository.save(cat);
	}

	@Override
	public void deleteTypeAction(Long id) {
		typeActionRepository.delete(getTypeAction(id));
	}	

	@Override
	public TypeAction getTypeAction(Long id) {
		return typeActionRepository.findOne(id);
	}

	@Override
	public List<TypeAction> getAllTypeActions() {
		return typeActionRepository.findAll();
	}

	@Override
	public PageTypeAction getAllTypeAction(int size, int page) {
		Page<TypeAction> ops = typeActionRepository.getAllTypesAction(new PageRequest(page, size));
		PageTypeAction pEt = new PageTypeAction();
		pEt.setTypes(ops.getContent());
		pEt.setNombreTypeActions(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalTypeActions((int)ops.getTotalElements());
		return pEt; 
	}

	
}
