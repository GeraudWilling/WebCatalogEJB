package perso.webcatalog.remote;

import java.util.List;

import javax.ejb.Remote;

import perso.webcatalog.bean.CommandeClient;

@Remote
public interface FacadeCommandeClientRemote<T> {
	public T create(T cat);
	public T update(T cat);
	public boolean delete(T cat);
	public T findById(long id);
	public List<T> findAll();

}
