package eu.fr.esic.formation.jpa.service.impl;

import java.util.List;

import eu.fr.esic.formation.jpa.dao.ITacheDAO;
import eu.fr.esic.formation.jpa.dao.impl.TacheDAOImpl;
import eu.fr.esic.formation.jpa.entity.Tache;
import eu.fr.esic.formation.jpa.service.ITacheService;
import eu.fr.esic.formation.jpa.util.StatutTacheEnum;

/**
 * 
 * @author CHZOME
 *
 */
public class TacheServiceImpl extends AbstractServiceImpl<Tache, ITacheDAO> implements ITacheService{

	private ITacheDAO tacheDAO = null;
	public TacheServiceImpl(){
		this.tacheDAO = new TacheDAOImpl();
		this.setMyDAO(tacheDAO);
	}
	public List<Tache> getListeTacheParStatut(StatutTacheEnum statut) {
		// TODO Auto-generated method stub
		return this.tacheDAO.getListeTacheParStatut(statut);
	}

	public List<Tache> getListeTacheParUser(Integer idUser) {
		// TODO Auto-generated method stub
		return this.tacheDAO.getListeTacheParUser(idUser);
	}
	public void setTacheDAO(ITacheDAO tacheDAO) {
		this.tacheDAO = tacheDAO;
	}
	public List<Tache> getTacheAllouesParCodePostalUtilisateur(Integer codeP) {
		// TODO Auto-generated method stub
		return this.tacheDAO.getTacheAllouesParCodePostalUtilisateur(codeP);
	}

}
