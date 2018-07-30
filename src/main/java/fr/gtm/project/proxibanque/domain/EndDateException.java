package fr.gtm.project.proxibanque.domain;

/**
 * Méthode d'exception permettant de vérifier si la date de fin (EndDate)
 * proposé par le gestionnaire est avant la date de Start du sondage
 *
 * @author Fabien - Faouzi - Nadir
 *
 */
public class EndDateException extends Exception {

	/**
	 * Sérialisation de la classe EndDateException
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Methode d'exception créée pour lever une exception si la date de fin créée
	 * est antérieure à la date de début du sondage.
	 *
	 * @param message
	 *            Message pour la gestion des erreur pour l'affectation des dates
	 *            lors de la création de survey
	 */
	public EndDateException(final String message) {
		super(message);
	}
}
