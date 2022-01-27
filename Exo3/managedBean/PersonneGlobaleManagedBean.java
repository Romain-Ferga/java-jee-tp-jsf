package eu.esic.formation.jsf.demo.managedbean;

import eu.esic.formation.jsf.demo.backendbean.PersonneBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="personGlobaleBean")
@RequestScoped
public class PersonneGlobaleManagedBean {

    public static final String KEY_SESSION_PERSONNE = "listePersonneKey";
    private PersonneBean personneGeree;
    private List<PersonneBean> listePersonne;
   
    public PersonneGlobaleManagedBean(){
        personneGeree = new PersonneBean();
    }
    
    
    public PersonneBean getPersonneGeree() {
        return personneGeree;
    }

    public void setPersonneGeree(PersonneBean personneGeree) {
        this.personneGeree = personneGeree;
    }
    
    public String enregistrerPersonne(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extCtx = ctx.getExternalContext();
        Map<String, Object> sessionMap = extCtx.getSessionMap();
        List<PersonneBean> listePInSession = (List<PersonneBean> )sessionMap.get(KEY_SESSION_PERSONNE);
        if (listePInSession == null) {
            listePInSession = new ArrayList<PersonneBean>();
        }
        listePInSession.add(personneGeree);
        //On remet en session 
        sessionMap.put(KEY_SESSION_PERSONNE, listePInSession);
        this.listePersonne = listePInSession;
        return "success";
    }
    
    public void validateEmail(FacesContext context, UIComponent toValidate,
        Object value) throws ValidatorException {
    String eMail = (String) value;
    if (eMail.indexOf("@") < 0) {
        FacesMessage message = new FacesMessage("Adresse Email invalide !");
        throw new ValidatorException(message);
    }
}
    
    public String modifierPersonne(){
        return "listePersonne";
    }
    
    
    public List<PersonneBean> getListePersonne() {
        return listePersonne;
    }

    public void setListePersonne(List<PersonneBean> listePersonne) {
        this.listePersonne = listePersonne;
    }

    
    
}
