package eu.fr.esic.formation.jpa.dao;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Utilisateur;
/**
 * Interface exposant les services d'acces aux donn�es li�es � l'utilisateur
 * @author CHZOME
 *
 */
public interface IUtilisateurDAO extends IAbstractEntityDAO<Utilisateur>{

	/**
	 * Recup�re les utilisateurs par sexe
	 * @param sexe : Entier representant le sexe (1 pour Homme et 2 pour femme)
	 * @return
	 */
	public List<Utilisateur> findUtiliateurParSexe(int sexe);
	/**
	 * Recup�re un utilisateur par son email et password
	 * @param email : Email pour lequel on souhaiter recuperer l'utilisateur correspondant
	 * @param password : Mot de passe de l'utilisateur recherch�
	 * @return
	 */
	public Utilisateur getUserByEmailAndPassword(String email,String password);
	/**
	 * Verif qu'un email n'existe pas d�j� en base
	 * @param idUser : Identifiant fourni dans le cas d'une mise � jour
	 * @param email : Email dont on cherche l'existence en base
	 * @return
	 */
	public Boolean verifSiEmailExiste(Integer idUser,String email);
}
