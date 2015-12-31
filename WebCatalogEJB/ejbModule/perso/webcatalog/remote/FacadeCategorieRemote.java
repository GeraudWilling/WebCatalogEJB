package perso.webcatalog.remote;

import java.util.List;

import javax.ejb.Remote;

import perso.webcatalog.bean.Categorie;
import perso.webcatalog.bean.Produit;


@Remote
public interface FacadeCategorieRemote<T> {
	
	public T create(T cat);
	public T update(T cat);
	public boolean delete(T cat);
	public Categorie findByName(String name);
	public T findById(long id);
	public List<T> findAll();
	public List<Produit> findAllProduct(long id);

}
