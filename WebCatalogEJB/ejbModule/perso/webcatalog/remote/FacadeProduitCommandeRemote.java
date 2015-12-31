package perso.webcatalog.remote;

import java.util.List;

import javax.ejb.Remote;

import perso.webcatalog.bean.ProduitCommande;

@Remote
public interface FacadeProduitCommandeRemote<T> {
	public ProduitCommande findByName(String name);
	public T create(T cat);
	public T update(T cat);
	public boolean delete(T cat);
	public T findById(long id);
	public List<T> findAll();
}
