package eu.fr.esic.formation.jpa.dao;

import java.util.List;
/**
 * Interface parametrique exposant les services CRUD du socle
 * @author CHZOME
 *
 * @param <E> : Type paramétrique representant la classe Métier manipulee
 */
public interface IAbstractEntityDAO<E> {

	/**
	 * Cree ou met à jour une entité
	 * @param entity : Entité à mettre à jour
	 * @return
	 */
	public E createUpdateEntity(E entity);
	/**
	 * Recupere une entité par son identifiant
	 * @param idEntity : Identifiant technique de l'entité à récuperer
	 * @return
	 */
	public E getEntityById(Integer idEntity);
	/**
	 * Recupère l'ensemble des entités en base
	 * @return
	 */
	public List<E> findAll();
	/**
	 * Supprimer une entité par son identifiant
	 * @param idToDelete : Identifiant de l'entité à supprimer
	 */
	public void deleteById(Integer idToDelete); 
}
