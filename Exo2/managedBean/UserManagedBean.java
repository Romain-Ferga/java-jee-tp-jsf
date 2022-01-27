package eu.esic.formation.jsf.demo.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserManagedBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3186267618884168657L;
	private String prenom;
	private String nom;
	private Date datenaissance;
	private String genre;
	private String email;
	private String niveauService;
	private Map<String, Object> listNiveauService;


	public UserManagedBean() {
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveauService() {
		return niveauService;
	}

	public void setNiveauService(String niveauService) {
		this.niveauService = niveauService;
	}

	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String eMail = (String) value;
		if (eMail.indexOf("@") < 0) {
			FacesMessage message = new FacesMessage("Adresse Email invalide !");
			throw new ValidatorException(message);
		}
	}

	public String ajoutUtilisateurConfirme() {
		// Cette m�thode pourrait faire un appel en base de donn�es vie DAO ou couche service 
		System.out.println("Ajout d'un nouvel utilisateur");
		return "success";
	}

	public Map<String, Object> getListNiveauService() {
		return listNiveauService;
	}

	public void setListNiveauService(Map<String, Object> listNiveauService) {
		this.listNiveauService = listNiveauService;
	}
	
	@PostConstruct
	public void initBean(){
		System.out.println("Init ManagedBean**************");
		listNiveauService = new LinkedHashMap<String, Object>();
		listNiveauService.put("Basic", "basic"); //label, value
		listNiveauService.put("Medium", "medium");
		listNiveauService.put("Premium	", "premium");
	}
	
	

}