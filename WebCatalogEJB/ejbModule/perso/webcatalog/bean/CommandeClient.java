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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author admin
 *
 */
@Entity
public class CommandeClient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double montant;
	
	@Temporal(TemporalType.TIME)
	private Date dateCreation;
		
	private long noConfirmation;

	@ManyToOne
	private Client client;
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public long getNoConfirmation() {
		return noConfirmation;
	}

	public void setNoConfirmation(long noConfirmation) {
		this.noConfirmation = noConfirmation;
	}
	
	
	
	
	

}
