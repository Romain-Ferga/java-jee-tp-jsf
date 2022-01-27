package eu.fr.esic.formation.jpa.service.impl;

import java.util.List;

import eu.fr.esic.formation.jpa.dao.IAbstractEntityDAO;
import eu.fr.esic.formation.jpa.service.IAbstractService;

public abstract class AbstractServiceImpl<E, IDAO extends IAbstractEntityDAO<E>> implements IAbstractService<E> {

	private IDAO myDAO = null;
	
	public E createUpdateEntity(E entity) {
		// TODO Auto-generated method stub
		return this.myDAO.createUpdateEntity(entity);
	}

	public E getEntityById(Integer idEntity) {
		// TODO Auto-generated method stub
		return this.myDAO.getEntityById(idEntity);
	}

	public List<E> findAll() {
		// TODO Auto-generated method stub
		return this.myDAO.findAll();
	}

	public void deleteById(Integer idToDelete) {
		// TODO Auto-generated method stub
		this.myDAO.deleteById(idToDelete);
	}

	public void setMyDAO(IDAO myDAO) {
		this.myDAO = myDAO;
	}

}
