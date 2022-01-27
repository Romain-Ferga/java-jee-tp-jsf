package eu.fr.esic.formation.jpa.dao;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Tache;
import eu.fr.esic.formation.jpa.util.StatutTacheEnum;
/**
 * Interface exposant les services d'acces aux données liées à la tache
 * @author CHZOME
 *
 */
public interface ITacheDAO extends IAbstractEntityDAO<Tache>{

	/**
	 * Renvoie la liste des tâches par son statut
	 * @param statut : statut des tâches qu'on recherche
	 * @return
	 */
	public List<Tache> getListeTacheParStatut(StatutTacheEnum statut);
	/**
	 * Renvoie la liste des tâches par utilisateur
	 * @param idUser : Identifiant de l'utilisateur pour lequel on recherche les tâches
	 * @return
	 */
	public List<Tache> getListeTacheParUser(Integer idUser);
	
	/**
	 * Recupère les taches allouées aux utilisateurs d'un departement geographique
	 * @param codeP :Code postal des utilisateurs en charge des taches à remonter
	 * @return
	 */
	public List<Tache> getTacheAllouesParCodePostalUtilisateur(Integer codeP);
}
