package eu.fr.esic.formation.jpa.util;

public enum GenreEnum {

	GENRE_HOMME(1),
	GENRE_FEMME(2);
	private Integer codeGenre;
	GenreEnum(int genre){
		this.codeGenre = genre;
	}
	public Integer getCodeGenre() {
		return codeGenre;
	}
	public void setCodeGenre(Integer codeGenre) {
		this.codeGenre = codeGenre;
	}
}
