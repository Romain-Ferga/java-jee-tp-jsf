package eu.fr.esic.formation.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import eu.fr.esic.formation.jpa.dao.ITacheDAO;
import eu.fr.esic.formation.jpa.entity.Tache;
import eu.fr.esic.formation.jpa.util.StatutTacheEnum;

public class TacheDAOImpl extends AbstractEntityImpl<Tache> implements ITacheDAO{

	public TacheDAOImpl() {
		super(Tache.class);
	}

	@SuppressWarnings("unchecked")
	public List<Tache> getListeTacheParStatut(StatutTacheEnum statut) {
		String namedQuery = "Tache.findTacheParStatut";
		Query query = this.getEntityManager().createNamedQuery(namedQuery);
		query.setParameter("paramStatut", statut.getStatutTache());
		List<Tache> listeTachePourStatut = query.getResultList();
		return listeTachePourStatut;
	}
	@SuppressWarnings("unchecked")
	public List<Tache> getListeTacheParUser(Integer idUser) {
		String namedQuery = "Tache.findTacheParIdUer";
		Query query = this.getEntityManager().createNamedQuery(namedQuery);
		query.setParameter("paramIdUtilisateur", idUser);
		List<Tache> listeTachePourUserId = query.getResultList();
		return listeTachePourUserId;
	}
	
	@Override
	public String getAttributeIdName(){
		return Tache.ID_NAME;
	}

	@SuppressWarnings("unchecked")
	public List<Tache> getTacheAllouesParCodePostalUtilisateur(Integer codeP) {
		String namedQuery = "Tache.findTacheParCodePostal";
		Query query = this.getEntityManager().createNamedQuery(namedQuery);
		query.setParameter("paramCodePostal", codeP+"%");
		List<Tache> listeTachePourHabitantDuCodeP = query.getResultList();
		return listeTachePourHabitantDuCodeP;
	}
}
