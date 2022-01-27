package eu.esic.formation.gesta.managedbean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import eu.esic.formation.gesta.utils.GestaConstantes;

/**
 * Pour la gestion de la deconnexion à l'application
 * @author CHZOME
 *
 */
@ManagedBean(name ="logoutManagedBean")
@RequestScoped
public class LogoutManagedBean {

	public String logoutAction() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext extCtx = facesContext.getExternalContext();
        Map<String, Object> sessionMap = extCtx.getSessionMap();
        if (sessionMap != null){
        	sessionMap.put(GestaConstantes.LOGGING_BEAN_KEY, null);
        }
		HttpSession httpSession = (HttpSession)extCtx.getSession(false);
		httpSession.invalidate();
		return GestaConstantes.MSG_OK;
	}
}
