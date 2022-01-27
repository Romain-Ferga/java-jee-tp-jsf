package eu.fr.esic.formation.jpa.util;

public enum StatutTacheEnum {

	A_FAIRE(1,"TODO"),
	EN_COURS(2,"WIP"),
	FINI(3,"DONE"),
	A_TESTER(4,"TOTEST");
	
	StatutTacheEnum(int codeStatut,String libTache){
		this.statutTache = codeStatut;
		this.libStatutTache = libTache;
	}
	private Integer statutTache;
	private String libStatutTache;
	
	/**
	 * Renvoie le libellé du statut d'une tache en fonction du code de la tache
	 * @param codeTache : code de la tache pour lequel on recherche le statut
	 * @return
	 */
	public static String getLibStatutTache(int codeTache){
		for(StatutTacheEnum statut : values()){
			if (statut.getStatutTache().equals(codeTache)){
				return statut.getLibStatutTache();
			}
		}
		return "";
	}
	
	public String getLibStatutTache() {
		return libStatutTache;
	}
	public void setLibStatutTache(String libStatutTache) {
		this.libStatutTache = libStatutTache;
	}
	public Integer getStatutTache() {
		return statutTache;
	}
	public void setStatutTache(Integer statutTache) {
		this.statutTache = statutTache;
	}
	
}
