package perso.webcatalog.remote;

import java.util.List;

import javax.ejb.Remote;

import perso.webcatalog.bean.Produit;

@Remote
public interface FacadeProduitRemote<T> {
	public Produit findByName(String name);
	public T create(T cat);
	public T update(T cat);
	public boolean delete(T cat);
	public T findById(long id);
	public List<T> findAll();
}
