package perso.webcatalog.ejb;

import javax.ejb.EJB;

public class AccessCatalogueBean {
	
	@EJB
	private FacadeCategorie facadeCategorie;
	
	@EJB
	private FacadeProduit facadeProduitRemote;

}
