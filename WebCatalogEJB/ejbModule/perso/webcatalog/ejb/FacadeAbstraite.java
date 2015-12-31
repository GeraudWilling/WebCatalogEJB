package perso.webcatalog.ejb;

import java.util.List;

/**
 * 
 */

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author admin
 *
 */
public abstract class FacadeAbstraite<T> {
	
	private  Class<T> entityClass;
	
	public FacadeAbstraite(Class<T> entityClass){
		this.entityClass=entityClass;
	}
	
	public abstract EntityManager getEntityManager();
	
	public T create(T entity){
		try {
			getEntityManager().persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return entity;
	}
	
	
	public T update(T entity) {
		try {
            getEntityManager().merge(entity);
            getEntityManager().flush();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
	}
	

	
	public boolean delete(T entity) {
		try {
			getEntityManager().remove(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public T findById(long id) {
		try {
			T entity= (T)getEntityManager().find(entityClass, id);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public List<T> findAll() {
		try {
			Query query= getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
			List<T>cat= (List<T>)query.getResultList();
			return cat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
