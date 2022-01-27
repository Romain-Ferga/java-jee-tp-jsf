package eu.esic.formation.gesta.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.service.IUtilisateurService;
import eu.fr.esic.formation.jpa.service.impl.UtilisateurServiceImpl;

@ManagedBean(name= "listerUserManagedBean")
public class ListerUserManagedBean {

private IUtilisateurService userService;
private List<Utilisateur> listeUsers;
	
	
	public ListerUserManagedBean(){
		this.userService = new UtilisateurServiceImpl();
		//On recupere la liste en base
		this.listeUsers = this.userService.findAll();
	}

	
	public String deleteUserById(Integer idUser){
		if (idUser != null){
			this.userService.deleteById(idUser);
			this.listeUsers = this.userService.findAll();
		}
		return "";
	}

	public List<Utilisateur> getListeUsers() {
		return listeUsers;
	}


	public void setListeUsers(List<Utilisateur> listeUsers) {
		this.listeUsers = listeUsers;
	}
	
	
}
