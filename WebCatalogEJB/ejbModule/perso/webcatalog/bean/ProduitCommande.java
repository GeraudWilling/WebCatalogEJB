package perso.webcatalog.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
//@IdClass(ProduitCommandeId.class)
public class ProduitCommande implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	/*@Id
	private long commande_client_id;
	@Id
	private long produit_id;*/
	
	private int quantite;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    //@PrimaryKeyJoinColumn(name = "COMMANDEID", referencedColumnName = "ID")
	private CommandeClient commandeClient;
	
	@ManyToOne
    //@PrimaryKeyJoinColumn(name = "PRODUITID", referencedColumnName = "ID")
	private Produit produit;
	
	
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}
	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/*public long getCommande_client_id() {
		return commande_client_id;
	}
	public void setCommande_client_id(long commande_client_id) {
		this.commande_client_id = commande_client_id;
	}
	public long getProduit_id() {
		return produit_id;
	}
	public void setProduit_id(long produit_id) {
		this.produit_id = produit_id;
	}*/
	

}


/*Id Class, necessaire pour les clés primaires composés*/
class ProduitCommandeId implements Serializable {
	private static final long serialVersionUID = 1L;
	private long commande_client_id;
	private long produit_id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (commande_client_id ^ (commande_client_id >>> 32));
		result = prime * result + (int) (produit_id ^ (produit_id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduitCommandeId other = (ProduitCommandeId) obj;
		if (commande_client_id != other.commande_client_id)
			return false;
		if (produit_id != other.produit_id)
			return false;
		return true;
	}
	
	
	
}
