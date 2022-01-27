package eu.fr.esic.formation.jpa.exception;

/**
 * Classe de gestion des exceptions
 * @author CHZOME
 *
 */
public class GestaBusinessException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestaBusinessException(String message) {
		super(message);
	}
}
