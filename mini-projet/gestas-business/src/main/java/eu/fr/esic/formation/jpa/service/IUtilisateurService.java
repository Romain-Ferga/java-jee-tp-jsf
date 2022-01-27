package eu.fr.esic.formation.jpa.service;

import java.util.List;

import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.exception.GestaBusinessException;

public interface IUtilisateurService extends IAbstractService<Utilisateur>{
	/**
	 * Recupère les utilisateurs par sexe
	 * @param sexe : Entier representant le sexe (1 pour Homme et 2 pour femme)
	 * @return
	 */
	public List<Utilisateur> findUtiliateurParSexe(int sexe);
	/**
	 * Recupère un utilisateur par son email et password
	 * @param email : Email pour lequel on souhaiter recuperer l'utilisateur correspondant
	 * @param password : Mot de passe de l'utilisateur recherché
	 * @return
	 */
	public Utilisateur getUserByEmailAndPassword(String email,String password);
	/**
	 * Verif qu'un email n'existe pas déjà en base
	 * @param idUser : Identifiant fourni dans le cas d'une mise à jour
	 * @param email : Email dont on cherche l'existence en base
	 * @return
	 */
	public Boolean verifSiEmailExiste(Integer idUser,String email);
	/**
	 * Methode permettant de creer ou modifier un utilisateur
	 * @param userACreerOuModifier : Utilisateur à creer ou à modifier
	 */
	public Utilisateur creerOuMetAJourUtilisateur(Utilisateur userACreerOuModifier) throws GestaBusinessException;
}
