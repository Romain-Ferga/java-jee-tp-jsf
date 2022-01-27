package eu.fr.esic.formation.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import eu.fr.esic.formation.jpa.util.DepartementEnum;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Utilisateur.findAll", query="select u FROM Utilisateur u"),
@NamedQuery(name="Utilisateur.findByEmailAndPassword", query="select u FROM Utilisateur u where u.email=:paramEmail and u.password=:paramPassword"),
@NamedQuery(name="Utilisateur.findEmailSiExiste", query="select 1 FROM Utilisateur u where u.email=:paramEmail"),
@NamedQuery(name="Utilisateur.findEmailEnDoublon", query="select 1 FROM Utilisateur u  where u.email=:paramEmail and u.idUtilisateur<>:paramIdUtilisateur"),
@NamedQuery(name="Utilisateur.findUtilisateurParSexe", query="select u FROM Utilisateur u where u.sexe = :paramSexe")
})
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	public static String ID_NAME = "idUtilisateur";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER")
	private Integer idUtilisateur;

	@Column(name="NOM")
	private String nom;

	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CODE_POSTAL")
	private Integer codePostal;
	
	@Column(name="CODE_DEPARTEMENT")
	private Integer codeDepartement;
	
	@Column(name="SEXE")
	private int sexe;
	
	@Column(name="DATE_INSCRIPTION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInscription;

	
	
	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="user", cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	private List<Tache> listeTaches;

	public Utilisateur() {
		this.dateInscription = new Date();
	}
	
	public Utilisateur(Integer idUtilisateur, String nom, String prenom, String email, String password,
			Integer codePostal, Integer departement, int sexe) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codePostal = codePostal;
		this.codeDepartement = departement;
		this.sexe = sexe;
		this.dateInscription = new Date();
	}

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSexe() {
		return this.sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	
	public String toString(){
		String genre = this.sexe == 1 ? "M.":"Mme";
		return genre +" "+ this.nom + " PRENOM :"+ this.prenom + " EST DANS LE "+ this.codePostal + " AVECE EMAIL :"+ this.email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public List<Tache> getListeTaches() {
		return listeTaches;
	}

	public void setListeTaches(List<Tache> listeTaches) {
		this.listeTaches = listeTaches;
	}

	public Integer getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(Integer codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getLibDepartement(){
		return DepartementEnum.getLibByCodeDepartement(this.codeDepartement);
	}

}