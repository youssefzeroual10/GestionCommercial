package org.manolo.metier;

import java.util.List;

import org.manolo.entities.TypeClient;
import org.springframework.data.domain.Page;

public interface TypeClientMetier {
	public TypeClient saveTypeClient(TypeClient typeClient);
	public TypeClient updateTypeClient(TypeClient typeClient);
	public void deleteTypeClient(Long id);
	public PageTypeClient getAllTypeClient(int size,int page);
	public PageTypeClient getTypeByClientsMotCle(String motCle,int size,int page);
	public TypeClient getTypeClient(Long id);
	public List<TypeClient> getAllTypeClients();
}
