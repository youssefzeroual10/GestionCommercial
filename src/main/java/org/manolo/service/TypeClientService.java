package org.manolo.service;

import java.util.List;

import org.manolo.entities.TypeClient;
import org.manolo.metier.TypeClientMetier;
import org.manolo.metier.PageTypeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TypeClientService {
	@Autowired
	private TypeClientMetier TypeClientMetier;
	@RequestMapping(value = "/typeclients", method = RequestMethod.POST)
	public TypeClient saveTypeClient(TypeClient TypeClient) {
		return TypeClientMetier.saveTypeClient(TypeClient);
	}
	@RequestMapping(value = "/typeclients", method = RequestMethod.PUT)
	public TypeClient updateTypeClient(TypeClient TypeClient) {
		return TypeClientMetier.updateTypeClient(TypeClient);
	}
	@RequestMapping(value = "/typeclients/{id}", method = RequestMethod.DELETE)
	public void deleteTypeClient(@PathVariable Long id) {
		TypeClientMetier.deleteTypeClient(id);
	}
	@RequestMapping(value = "/typeclients/{id}", method = RequestMethod.GET)
	public TypeClient getTypeClient(@PathVariable Long id) {
		return TypeClientMetier.getTypeClient(id);
	}
	@RequestMapping(value = "/typeclients", method = RequestMethod.GET)
	public List<TypeClient> getAllTypeClients() {
		return TypeClientMetier.getAllTypeClients();
	}
	@RequestMapping(value = "/gettypeclients", method = RequestMethod.GET)
	public PageTypeClient getAllTypeClient(int size, int page) {
		return TypeClientMetier.getAllTypeClient(size, page);
	}

	public PageTypeClient getByTypeClientsMotCle(String motCle, int size, int page) {
		return TypeClientMetier.getTypeByClientsMotCle(motCle, size, page);
	}
	
}
