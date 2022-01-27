package eu.esic.formation.gesta.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import eu.esic.formation.gesta.utils.GestaConstantes;
import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.exception.GestaBusinessException;
import eu.fr.esic.formation.jpa.service.IUtilisateurService;
import eu.fr.esic.formation.jpa.service.impl.UtilisateurServiceImpl;
import eu.fr.esic.formation.jpa.util.DepartementEnum;

@ManagedBean(name = "gestionUserManagedBean")
@ViewScoped
public class GestionUserManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8437951921380040419L;
	private Utilisateur userCourant;
	private IUtilisateurService userService;
	
	public GestionUserManagedBean() {
		super();
		this.userService = new UtilisateurServiceImpl();
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUserParam = params.get("idUserParam");
		if (StringUtils.isNotBlank(idUserParam)){//On affiche en mode modification
			Integer idUser = Integer.parseInt(idUserParam);
			this.userCourant = this.userService.getEntityById(idUser);
		}else {//On affiche en mode creation
			this.userCourant = new Utilisateur();
		}
	}
	
	
	
	public String addUserAction(){
		try {
			//On cree l'utilisateur 
			this.userService.creerOuMetAJourUtilisateur(this.userCourant);
			//On recupere la liste en base
		} catch (GestaBusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
			return GestaConstantes.MSG_KO;
		}
		return GestaConstantes.MSG_OK;
	}
	
	public String loadUserAction(Integer idUser){
		if (idUser != null){
			this.userCourant = this.userService.getEntityById(idUser);
		}
		return GestaConstantes.MSG_OK;
	}
	
	public String deleteUserAction(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUserParam = params.get("idUserParam");
		if (StringUtils.isNotBlank(idUserParam)){
			
		}
		return null;
	}



	public DepartementEnum[] getDepartements() {
		return DepartementEnum.values();
	}



	public Utilisateur getUserCourant() {
		return userCourant;
	}



	public void setUserCourant(Utilisateur userCourant) {
		this.userCourant = userCourant;
	}
}
