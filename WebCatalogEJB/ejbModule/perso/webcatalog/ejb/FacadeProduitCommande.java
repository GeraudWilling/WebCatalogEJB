package perso.webcatalog.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import perso.webcatalog.bean.ProduitCommande;
import perso.webcatalog.remote.FacadeProduitCommandeLocal;
import perso.webcatalog.remote.FacadeProduitCommandeRemote;

/**
 * Session Bean implementation class FacadeProduitCommande
 */
@Stateless
public class FacadeProduitCommande extends FacadeAbstraite<ProduitCommande> implements FacadeProduitCommandeRemote<ProduitCommande>, FacadeProduitCommandeLocal {
	@PersistenceContext(name="toto")
    EntityManager em;
	
    public FacadeProduitCommande() {
        super(ProduitCommande.class);
    }

	@Override
	public ProduitCommande findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	

	

}
