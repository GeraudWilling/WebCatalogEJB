/**
 * 
 */
package perso.webcatalog.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author admin
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name="Produit.findByName", query="Select p FROM Produit p WHERE p.nom= :nom")
	
})
public class Produit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	private double prix;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date Derniere_maj;
	
	@ManyToOne
	private Categorie categorie;
	
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDerniere_maj() {
		return Derniere_maj;
	}

	public void setDerniere_maj(Date derniere_maj) {
		Derniere_maj = derniere_maj;
	}
	

}
