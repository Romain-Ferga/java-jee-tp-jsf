package eu.fr.esic.formation.jpa.dao;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Tache;
import eu.fr.esic.formation.jpa.util.StatutTacheEnum;
/**
 * Interface exposant les services d'acces aux donn�es li�es � la tache
 * @author CHZOME
 *
 */
public interface ITacheDAO extends IAbstractEntityDAO<Tache>{

	/**
	 * Renvoie la liste des t�ches par son statut
	 * @param statut : statut des t�ches qu'on recherche
	 * @return
	 */
	public List<Tache> getListeTacheParStatut(StatutTacheEnum statut);
	/**
	 * Renvoie la liste des t�ches par utilisateur
	 * @param idUser : Identifiant de l'utilisateur pour lequel on recherche les t�ches
	 * @return
	 */
	public List<Tache> getListeTacheParUser(Integer idUser);
	
	/**
	 * Recup�re les taches allou�es aux utilisateurs d'un departement geographique
	 * @param codeP :Code postal des utilisateurs en charge des taches � remonter
	 * @return
	 */
	public List<Tache> getTacheAllouesParCodePostalUtilisateur(Integer codeP);
}
