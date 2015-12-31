package perso.webcatalog.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import perso.webcatalog.bean.Client;
import perso.webcatalog.remote.FacadeClientLocal;
import perso.webcatalog.remote.FacadeClientRemote;

/**
 * Session Bean implementation class FacadeClient
 */
@Stateless
public class FacadeClient extends FacadeAbstraite<Client> implements FacadeClientRemote<Client>, FacadeClientLocal{
	
	@PersistenceContext(name="toto")
    EntityManager em;

	public FacadeClient(){
        super(Client.class);
    }
	
	@Override
	public boolean alwaysExist(Client entity){
		try {
			Query query= em.createNamedQuery("Client.findByEmail");
			query.setParameter("mail", entity.getEmail().trim());
			Client alwaysexist= (Client)query.getSingleResult();
			if(alwaysexist== null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		//return true;
	}

	@Override
	public Client create(Client entity){
		try {
			if(!alwaysExist(entity))
				em.persist(entity);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return entity;
	}
	@Override
	public perso.webcatalog.bean.Client findByName(String name) {
		try {
			Query query= em.createNamedQuery("Client.findByName");
			query.setParameter("nom", name);
			perso.webcatalog.bean.Client client= (Client)query.getSingleResult();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Client identify(String name, String carte) {
		try {
			Query query= em.createNamedQuery("Client.identify");
			query.setParameter("mail", name);
			query.setParameter("password", carte);
			perso.webcatalog.bean.Client client= (Client)query.getSingleResult();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	

}
