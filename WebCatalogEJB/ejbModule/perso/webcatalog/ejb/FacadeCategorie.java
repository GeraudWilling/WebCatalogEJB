package perso.webcatalog.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import perso.webcatalog.bean.Categorie;
import perso.webcatalog.bean.Produit;
import perso.webcatalog.remote.FacadeCategorieLocal;
import perso.webcatalog.remote.FacadeCategorieRemote;

/**
 * Session Bean implementation class FacadeCategorie
 */
@Stateless
public class FacadeCategorie  extends FacadeAbstraite<Categorie> implements FacadeCategorieRemote<Categorie>, FacadeCategorieLocal {

	public FacadeCategorie() {
		super(Categorie.class); //Class<T> == T.class
	}

	@PersistenceContext(name="toto")
    EntityManager em;

	
	
	@Override
	public Categorie findByName(String name) {
		Query query= em.createNamedQuery("Categorie.findByName");
		query.setParameter("nom", name);
		return (Categorie)query.getSingleResult();
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Produit> findAllProduct(long id) {
		Categorie cat = (Categorie)em.find(Categorie.class, id);
		long s=cat.getProduits().size()>0? cat.getProduits().get(0).getId(): 0; //just to force eager loading, instead of lazy loading
		return cat.getProduits();
	}
	
	
	
	
	
	
	
	
	
	/*
	 * 
	public Categorie create(Categorie cat){
		em.persist(cat);
	}
	
	 public Categorie update(Categorie cat){
		em.merge(cat);
	}
	
	public boolean delete(Categorie cat){
		try {
			em.remove(cat);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Categorie findById(long id){
		Categorie resultat = (Categorie) em.find(Categorie.class, id);
		return resultat;
	}
	
	public Categorie findByName(String name){
		Query query= em.createNamedQuery("Categorie.findByName");
		query.setParameter("x", name);
		return (Categorie)query.getSingleResult();
	}
	
	public List<Categorie> findAll(){
		Query query= em.createNamedQuery("Categorie.findAll");
		return (List<Categorie>)query.getResultList();
	}*/
	
	
	
	

	
}
