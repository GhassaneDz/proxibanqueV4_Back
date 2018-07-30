package fr.gtm.project.proxibanque.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.project.proxibanque.dao.SurveyRepository;
import fr.gtm.project.proxibanque.domain.CloseDateException;
import fr.gtm.project.proxibanque.domain.EndDateException;
import fr.gtm.project.proxibanque.domain.Survey;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository repo;

	/**

	 * Méthode service de création d'un survey
	 * @param entity Nouveau survey à crée en paramètre

	 *
	 * @param entity
	 *            Nouveau survey à crée en paramètre
	 * @return La création du nouveau survey si aucune erreur est thrown
	 * @throws EndDateException
	 *             Validation de la date de clôture
	 */
	public Survey create(final Survey entity) throws EndDateException {
		if (entity.getEndDate().isBefore(entity.getStartDate())) {
			throw new EndDateException(
					"Vous ne pouvez pas renseigner une date de fin antérieure à la date de début du sondage.");
		}
		return this.repo.save(entity);
	}

	/**

	 * Méthode service de suppréssion d'un survey
	 * @param id Identifiant du survey à supprimer
	 *
	 * @param id
	 *            Identifiant du survey à supprimer
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 * Méthode service de consultation de survey en cours
	 * @return Voir si il y a un sondage en cours
	 */
	public int getActualSurvey() {
		int result = 0;
		final LocalDate today = LocalDate.now();
		final List<Survey> listSurvey = this.list();
		for (final Survey survey : listSurvey) {
			if (today.isAfter(survey.getStartDate()) && today.isBefore(survey.getEndDate())) {
				if (survey.getCloseDate() == null) {
					result = survey.getId();
				} else {
					result = 0;
				}
			}
		}
		return result;
	}

	/**
	 * Méthode service de consultation de survey clôturable
	 * @return Le survey qui peut être clôturé
	 */
	public int isSurveyClosable() {
		int isSurveyCurrent = 0;
		final LocalDate today = LocalDate.now();
		final List<Survey> listSurvey = this.list();
		for (final Survey survey : listSurvey) {
			if (survey.getCloseDate() == null || survey.getEndDate().isAfter(today)) {
				isSurveyCurrent = survey.getId();
			}
		}
		return isSurveyCurrent;

	}

	/**
	 * Méthode service de listing de tout les survey
	 * @return La liste des survey
	 */
	public List<Survey> list() {
		return this.repo.findAll();
	}

	/**

	 * Méthode service d'affichage d'un survey spécifique par son id
	 * @param id du survey spécifique
	 *
	 * @param id
	 *            du survey spécifique
	 * @return le survey correspondant à l'id
	 */
	public Survey read(final Integer id) {
		Survey result = null;
		final Optional<Survey> entity = this.repo.findById(id);
		if (entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}

	/**

	 * Méthode service de mise à jours d'un survey
	 * @param entity Le survey à mettre à jours
	 * @param entity
	 *            Le survey à mettre à jours
	 * @return Le survey avec les changements
	 * @throws CloseDateException
	 *             Pour ne pas attribuer une date de clôture antérieur à la date de
	 *             publication
	 */
	public Survey update(final Survey entity) throws CloseDateException {
		if (entity.getCloseDate().isBefore(entity.getStartDate())) {
			throw new CloseDateException(
					"Vous ne pouvez pas renseigner une date de cloture antérieure à la date de début du sondage");
		}
		return this.repo.save(entity);
	}
}