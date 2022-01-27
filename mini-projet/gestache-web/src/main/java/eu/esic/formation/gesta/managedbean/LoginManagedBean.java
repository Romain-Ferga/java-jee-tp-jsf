package eu.esic.formation.gesta.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import eu.esic.formation.gesta.utils.GestaConstantes;
import eu.fr.esic.formation.jpa.entity.Utilisateur;
import eu.fr.esic.formation.jpa.service.IUtilisateurService;
import eu.fr.esic.formation.jpa.service.impl.UtilisateurServiceImpl;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2298573988062240389L;
	private IUtilisateurService userService;
	private Utilisateur userCourant;
	
	
	public LoginManagedBean(){
		this.userCourant = new Utilisateur();
		this.userService = new UtilisateurServiceImpl();
	}
	
	public String loginAction(){
		Utilisateur userConnecte = this.userService.getUserByEmailAndPassword(this.userCourant.getEmail(), this.userCourant.getPassword());
		System.out.println("USER :"+ userConnecte);
		if (userConnecte != null){
			FacesContext ctx = FacesContext.getCurrentInstance();
	        ExternalContext extCtx = ctx.getExternalContext();
	        Map<String, Object> sessionMap = extCtx.getSessionMap();
	        sessionMap.put(GestaConstantes.LOGGING_BEAN_KEY, userConnecte);
	        return GestaConstantes.MSG_OK;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREUR DE CONNEXION...", null));
			return GestaConstantes.MSG_KO;
		}
		
	}

	public Utilisateur getUserCourant() {
		return userCourant;
	}

	public void setUserCourant(Utilisateur userCourant) {
		this.userCourant = userCourant;
	}
	
	
}
