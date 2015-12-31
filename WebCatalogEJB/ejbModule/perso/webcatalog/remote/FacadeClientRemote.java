package perso.webcatalog.remote;

import java.util.List;

import javax.ejb.Remote;

import perso.webcatalog.bean.Client;

@Remote
public interface FacadeClientRemote<T> {
	
	public Client findByName(String name);
	public Client identify(String name,String carte);
	public T create(T cat);
	public T update(T cat);
	public boolean delete(T cat);
	public T findById(long id);
	public List<T> findAll();
	public boolean alwaysExist(Client entity);
}
