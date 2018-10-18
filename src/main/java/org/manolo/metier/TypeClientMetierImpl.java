package org.manolo.metier;

import java.util.List;

import org.manolo.dao.TypeClientRepository;
import org.manolo.entities.TypeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TypeClientMetierImpl  implements TypeClientMetier{
	@Autowired 
	private TypeClientRepository typeClientRepository;
	@Override
	public TypeClient saveTypeClient(TypeClient cat) {
		return typeClientRepository.save(cat);
	}

	@Override
	public TypeClient updateTypeClient(TypeClient cat) {
		return typeClientRepository.save(cat);
	}

	@Override
	public void deleteTypeClient(Long id) {
		typeClientRepository.delete(getTypeClient(id));
	}	

	@Override
	public TypeClient getTypeClient(Long id) {
		return typeClientRepository.findOne(id);
	}

	@Override
	public List<TypeClient> getAllTypeClients() {
		return typeClientRepository.findAll();
	}

	@Override
	public PageTypeClient getAllTypeClient(int size, int page) {
		Page<TypeClient> ops = typeClientRepository.getAllTypesClient(new PageRequest(page, size));
		PageTypeClient pEt = new PageTypeClient();
		pEt.setTypes(ops.getContent());
		pEt.setNombreTypeClients(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalTypeClients((int)ops.getTotalElements());
		return pEt; 
	}

	@Override
	public PageTypeClient getTypeByClientsMotCle(String motCle, int size, int page) {
		Page<TypeClient> ops = typeClientRepository.getTypesClientByMotCle(motCle,new PageRequest(page, size));
		PageTypeClient pEt = new PageTypeClient();
		pEt.setTypes(ops.getContent());
		pEt.setNombreTypeClients(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalTypeClients((int)ops.getTotalElements());
		return pEt; 	
	}
}
