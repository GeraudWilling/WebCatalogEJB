/**
 * 
 */
package perso.webcatalog.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * @author admin
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name="Client.findByName", query="Select c FROM Client c WHERE c.nom= :nom"),
	@NamedQuery(name="Client.findByEmail", query="Select c FROM Client c WHERE c.email= :mail"),
	@NamedQuery(name="Client.identify", query="Select c FROM Client c WHERE c.email= :mail AND c.carte= :password")
})
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String email;
	private String tel;
	private String adresse;
	private String carte;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCarte() {
		return carte;
	}
	public void setCarte(String carte) {
		this.carte = carte;
	}
	
	
	
	
	

}
