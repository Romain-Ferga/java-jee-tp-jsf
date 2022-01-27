package eu.fr.esic.formation.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import eu.fr.esic.formation.jpa.dao.IAbstractEntityDAO;

public class AbstractEntityImpl<E> implements IAbstractEntityDAO<E>{

	private EntityManager entityManager;
	// Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("tps-jpa");
    final Class<E> typeParameterClass;

    
	public AbstractEntityImpl(Class<E> typeParameterClass){
		this.entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		this.typeParameterClass = typeParameterClass;
	} 
	
	public E createUpdateEntity(E entity) {
		// Get a transaction
		EntityTransaction transaction = null;
		try {
			transaction = this.entityManager.getTransaction(); 
            // Begin the transaction
            transaction.begin();
            this.entityManager.persist(entity);
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } 
		return entity;
	}

	public E getEntityById(Integer idEntity) {
		return this.entityManager.find(this.typeParameterClass, idEntity);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		//On vide le cache avant tout 
		this.entityManager.clear();
		String namedQuery = this.typeParameterClass.getSimpleName().toString()+".findAll"; 
		return this.entityManager.createNamedQuery(namedQuery).getResultList(); 
	}

	public void deleteById(Integer idToDelete) {
		// Get a transaction
				EntityTransaction transaction = null;
				try {
					transaction = this.entityManager.getTransaction();
		            // Begin the transaction
		            transaction.begin();
		            String reqDeleteSql = "delete from "+this.typeParameterClass.getSimpleName().toString() + " ent where ent."+this.getAttributeIdName() +" =:paramId";
		            Query query = this.entityManager.createQuery(reqDeleteSql);
		            query.setParameter("paramId", idToDelete);
		            query.executeUpdate();
		            // Commit the transaction
		            transaction.commit();
		        } catch (Exception ex) {
		            // If there are any exceptions, roll back the changes
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            // Print the Exception
		            ex.printStackTrace();
		        } 
	}

	/**
	 * Cet accesseur sera redefini par les classes dérivées afin de donner le nom de l'attribut coté Java representant la clé primaire
	 * @return
	 */
	public String getAttributeIdName(){
		return "";
	}
	/**
	 * Accesseur permettant aux classes dérivées d'avoir accès à l'entité manager
	 * @return
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
