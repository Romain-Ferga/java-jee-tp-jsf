package eu.fr.esic.formation.jpa.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import eu.fr.esic.formation.jpa.dao.IUtilisateurDAO;
import eu.fr.esic.formation.jpa.dao.impl.UtilisateurDAOImpl;
import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.exception.GestaBusinessException;
import eu.fr.esic.formation.jpa.service.IUtilisateurService;

/**
 * 
 * @author CHZOME
 *
 */
public class UtilisateurServiceImpl extends AbstractServiceImpl<Utilisateur, IUtilisateurDAO> implements IUtilisateurService{

	private IUtilisateurDAO userDAO = null;

	public UtilisateurServiceImpl(){
		this.userDAO = new UtilisateurDAOImpl();
		//DAO requis par l'Abstract DAO
		this.setMyDAO(userDAO);
	}
	public List<Utilisateur> findUtiliateurParSexe(int sexe) {
		// TODO Auto-generated method stub
		return this.userDAO.findUtiliateurParSexe(sexe);
	}

	public Utilisateur getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserByEmailAndPassword(email, password);
	}

	public Boolean verifSiEmailExiste(Integer idUser, String email) {
		// TODO Auto-generated method stub
		return this.userDAO.verifSiEmailExiste(idUser, email);
	}

	public Utilisateur creerOuMetAJourUtilisateur(Utilisateur userACreerOuModifier) throws GestaBusinessException {
		if (userACreerOuModifier != null){
			String email = userACreerOuModifier.getEmail();
			if (StringUtils.isNotBlank(email)){
				Boolean isEmailExiste = this.userDAO.verifSiEmailExiste(userACreerOuModifier.getIdUtilisateur(), email);
				if (isEmailExiste){
					String messsagErreur = String.format("L'email que vous avez renseigné [%s] semble etre deja pris...", email);
					throw new GestaBusinessException(messsagErreur);
				}
			}
			userACreerOuModifier = this.userDAO.createUpdateEntity(userACreerOuModifier);
		}
		return userACreerOuModifier;
	}

	public void setUserDAO(IUtilisateurDAO userDAO) {
		this.userDAO = userDAO;
	}
}
