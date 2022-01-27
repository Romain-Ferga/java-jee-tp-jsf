package eu.fr.esic.formation.jpa.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import eu.fr.esic.formation.jpa.dao.IUtilisateurDAO;
import eu.fr.esic.formation.jpa.entity.Utilisateur;

public class UtilisateurDAOImpl extends AbstractEntityImpl<Utilisateur> implements IUtilisateurDAO{

	
	public UtilisateurDAOImpl() {
		super(Utilisateur.class); 
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findUtiliateurParSexe(int sexe) {
				String namedQuery = "Utilisateur.findUtilisateurParSexe";
				Query query = this.getEntityManager().createNamedQuery(namedQuery);
				query.setParameter("paramSexe", sexe);
				List<Utilisateur> listeUserParGenre = query.getResultList();
				return listeUserParGenre;
	}

	public Utilisateur getUserByEmailAndPassword(String email, String password) {
		try {
						String namedQuery = "Utilisateur.findByEmailAndPassword";
						Query query = this.getEntityManager().createNamedQuery(namedQuery);
						query.setParameter("paramEmail", email);
						query.setParameter("paramPassword", password);
						Utilisateur userTrouve = (Utilisateur)query.getSingleResult();
						return userTrouve;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Boolean verifSiEmailExiste(Integer idUser, String email) {
				String namedQuery = idUser != null ? "Utilisateur.findEmailEnDoublon":"Utilisateur.findEmailSiExiste" ;
				Query query = this.getEntityManager().createNamedQuery(namedQuery);
				if (idUser != null)
				query.setParameter("paramIdUtilisateur", idUser);
				query.setParameter("paramEmail", email);
				return  query.getResultList().size() > 0;
	}

	@Override
	public String getAttributeIdName(){
		return Utilisateur.ID_NAME;
	}
}
