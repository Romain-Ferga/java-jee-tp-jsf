package eu.esic.formation.jsf.demo.backendbean;

import java.io.Serializable;
import java.util.Date;

public class PersonneBean implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 7924645496259263536L;
    
    private Integer idPersonne;
    private String matricule;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private Integer genre;
    private String email;
    private String niveauService;
    
    public Integer getIdPersonne() {
        return idPersonne;
    }
    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }
    
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Integer getGenre() {
        return genre;
    }
    public void setGenre(Integer genre) {
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
}
