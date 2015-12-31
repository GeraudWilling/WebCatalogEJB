package perso.webcatalog.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import perso.webcatalog.bean.CommandeClient;
import perso.webcatalog.remote.FacadeCommandeClientLocal;
import perso.webcatalog.remote.FacadeCommandeClientRemote;

/**
 * Session Bean implementation class FacadeCommandeClient
 */
@Stateless
public class FacadeCommandeClient extends FacadeAbstraite<CommandeClient> implements FacadeCommandeClientRemote<CommandeClient>, FacadeCommandeClientLocal {

	@PersistenceContext(name="toto")
    EntityManager em;
	
    public FacadeCommandeClient() {
        super(CommandeClient.class);
    }

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	

	
}
