package perso.webcatalog.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import perso.webcatalog.bean.Produit;
import perso.webcatalog.remote.FacadeProduitLocal;
import perso.webcatalog.remote.FacadeProduitRemote;

/**
 * Session Bean implementation class FacadeProduit
 */
@Stateless
public class FacadeProduit extends FacadeAbstraite<Produit>implements FacadeProduitRemote<Produit>, FacadeProduitLocal {
	@PersistenceContext(name="toto")
    EntityManager em;
    
    public FacadeProduit() {
        super(Produit.class);
    }

	@Override
	public Produit findByName(String name) {
		try {
			Query query= em.createNamedQuery("Produit.findByName");
			query.setParameter("nom", name);
			Produit cat= (Produit)query.getSingleResult();
			return cat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	
}
