package eu.fr.esic.formation.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import eu.fr.esic.formation.jpa.util.StatutTacheEnum;


/**
 * The persistent class for the Tache database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Tache.findAll", query="SELECT t FROM Tache t"),
@NamedQuery(name="Tache.findTacheParIdUer", query="SELECT t FROM Tache t where t.user.idUtilisateur=:paramIdUtilisateur"),
@NamedQuery(name="Tache.findTacheParCodePostal", query="SELECT t FROM Tache t where cast(t.user.codePostal as string) like  :paramCodePostal"),
@NamedQuery(name="Tache.findTacheParStatut", query="SELECT t FROM Tache t where t.statut = :paramStatut")
})
public class Tache implements Serializable { 
	private static final long serialVersionUID = 1L;
	public static String ID_NAME = "idTache";

	@Id
	@Column(name="ID_TACHE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTache;

	
	@Column(name="LIBELLE")
	private String libelleTache;
	
	@Column(name="STATUT")
	private Integer statut;
	
	@Column(name="TEMPS_RESTANT")
	private Integer tempsRestant;
	
	@Column(name="TEMPS_IMPARTI")
	private Integer tempsImparti;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATION")
	private Date dateCreation;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private Utilisateur user;


	public Tache() {
		this.dateCreation = new Date();
	}
	
	public Tache(Integer idTache, String libelleTache, Integer statut, Integer tempsRestant, Integer tempsImparti) {
		super();
		this.idTache = idTache;
		this.libelleTache = libelleTache;
		this.statut = statut;
		this.tempsRestant = tempsRestant;
		this.tempsImparti = tempsImparti;
		this.dateCreation = new Date();
	}

	public Integer getIdTache() {
		return this.idTache;
	}

	public void setIdTache(Integer idTache) {
		this.idTache = idTache;
	}

	public Date getDate() {
		return this.dateCreation;
	}

	public void setDate(Date date) {
		this.dateCreation = date;
	}

	
	public String toString(){
		return "Libellé : "+ this.libelleTache + " temps Restant : "+ this.tempsRestant + " tempsImparti : "+ this.tempsImparti;
	}

	public String getLibelleTache() {
		return libelleTache;
	}

	public void setLibelleTache(String libelleTache) {
		this.libelleTache = libelleTache;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public Integer getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(Integer tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public Integer getTempsImparti() {
		return tempsImparti;
	}

	public void setTempsImparti(Integer tempsImparti) {
		this.tempsImparti = tempsImparti;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public String getLibStatutTache(){
		return StatutTacheEnum.getLibStatutTache(this.statut);
	}
}