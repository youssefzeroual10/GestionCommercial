package org.manolo.service;

import java.util.List;

import org.manolo.entities.TypeAction;
import org.manolo.metier.TypeActionMetier;
import org.manolo.metier.PageTypeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TypeActionService {
	@Autowired
	private TypeActionMetier typeActionMetier;
	@RequestMapping(value = "/typeActions", method = RequestMethod.POST)
	public TypeAction saveTypeAction(TypeAction typeAction) {
		return typeActionMetier.saveTypeAction(typeAction);
	}
	@RequestMapping(value = "/typeActions", method = RequestMethod.PUT)
	public TypeAction updateTypeAction(TypeAction typeAction) {
		return typeActionMetier.updateTypeAction(typeAction);
	}
	@RequestMapping(value = "/typeActions/{id}", method = RequestMethod.DELETE)
	public void deleteTypeAction(@PathVariable Long id) {
		typeActionMetier.deleteTypeAction(id);
	}
	@RequestMapping(value = "/typeActions/{id}", method = RequestMethod.GET)
	public TypeAction getTypeAction(@PathVariable Long id) {
		return typeActionMetier.getTypeAction(id);
	}
	@RequestMapping(value = "/typeActions", method = RequestMethod.GET)
	public List<TypeAction> getAllTypeActions() {
		return typeActionMetier.getAllTypeActions();
	}
	@RequestMapping(value = "/getTypeActions", method = RequestMethod.GET)
	public PageTypeAction getAllTypeAction(@RequestParam int size,@RequestParam int page) {
		return typeActionMetier.getAllTypeAction(size, page);
	}

	
	
}
