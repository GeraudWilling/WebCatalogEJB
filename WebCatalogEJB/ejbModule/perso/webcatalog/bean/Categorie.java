/**
 * 
 */
package perso.webcatalog.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @author admin
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name="Categorie.findByName", query="Select c FROM Categorie c WHERE c.nom= :nom"),
	@NamedQuery(name="Categorie.findAll", query="Select c FROM Categorie c")
})
public class Categorie implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	@OneToMany
	private List<Produit> produits; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	

}
