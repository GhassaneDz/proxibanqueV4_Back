package fr.gtm.project.proxibanque.domain;

public class CloseDateException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param message Message pour la gestion des erreur pour l'affectation des dates lors de la création de survey
	 */
	public CloseDateException(final String message) {
		super(message);
	}
}
