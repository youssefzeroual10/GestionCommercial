package org.manolo.metier;

import java.util.List;

import org.manolo.entities.TypeAction;
import org.springframework.data.domain.Page;

public interface TypeActionMetier {
	public TypeAction saveTypeAction(TypeAction typeAction);
	public TypeAction updateTypeAction(TypeAction typeAction);
	public void deleteTypeAction(Long id);
	public PageTypeAction getAllTypeAction(int size,int page);
	public TypeAction getTypeAction(Long id);
	public List<TypeAction> getAllTypeActions();

}
