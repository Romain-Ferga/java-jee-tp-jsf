package eu.fr.esic.formation.jpa.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eu.fr.esic.formation.jpa.dao.ITacheDAO;
import eu.fr.esic.formation.jpa.dao.impl.TacheDAOImpl;
import eu.fr.esic.formation.jpa.entity.Tache;
import eu.fr.esic.formation.jpa.util.StatutTacheEnum;

public class TacheDAOTest {
	
	
	private ITacheDAO tacheDAO = new TacheDAOImpl();
	
	@Test
	public void testRecupAll(){
		List<Tache> listeTache = this.tacheDAO.findAll();
		for (Tache tacheCourant : listeTache) {
			System.out.println(tacheCourant);
		}
		Assert.assertTrue(listeTache.size() == 3);
	}
	
	@Test
	public void testRecupTacheParStatut(){
		List<Tache> listeTache = this.tacheDAO.getListeTacheParStatut(StatutTacheEnum.A_FAIRE);
		for (Tache tacheCourant : listeTache) {
			System.out.println(tacheCourant);
		}
		Assert.assertTrue(listeTache.size() >0);
	}
	
	@Test
	public void testTacheParIdUser(){
		List<Tache> listeTache = this.tacheDAO.getListeTacheParUser(1);
		for (Tache tacheCourant : listeTache) {
			System.out.println(tacheCourant);
		}
		Assert.assertTrue(listeTache.size() >0);
	}
	
	@Test
	public void testRecupListeTacheParCodePostalUser(){
		List<Tache> listeTache = this.tacheDAO.getTacheAllouesParCodePostalUtilisateur(35);
		for (Tache tacheCourant : listeTache) {
			System.out.println(tacheCourant);
		}
		Assert.assertTrue(listeTache.size() >0);
	}
	
}
