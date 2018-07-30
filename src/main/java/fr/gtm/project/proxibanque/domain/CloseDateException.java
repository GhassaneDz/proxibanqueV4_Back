package fr.gtm.project.proxibanque.domain;

/**
 * Méthode d'exception permettant de vérifier si la date de cloture (CloseDate)
 * proposé par le gestionnaire est avant la date de Start du sondage
 *
 * @author Fabien - Faouzi - Nadir
 * @version 4.0
 *
 */
public class CloseDateException extends Exception {

	/**
	 * Sérialisation de la classe CloseDateException
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode d'exception créee pour lever une exception si la date de cloture
	 * créée est antérieure à la date de début du sondage.
	 *
	 * @param message
	 *            Message pour la gestion des erreur pour l'affectation des dates
	 *            lors de la création de survey
	 */
	public CloseDateException(final String message) {
		super(message);
	}
}
