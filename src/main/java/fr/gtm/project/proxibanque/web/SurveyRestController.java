package fr.gtm.project.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.SurveyService;
import fr.gtm.project.proxibanque.domain.CloseDateException;
import fr.gtm.project.proxibanque.domain.EndDateException;
import fr.gtm.project.proxibanque.domain.Survey;

/**
 * Controlleur REST des sondages (surveys)
 *
 * @author Nadir && Faouzi && Fabien
 *
 */
@RestController
@RequestMapping("/survey")
public class SurveyRestController {

	@Autowired
	private SurveyService service;

	/**
	 * La méthode checkSurvey est un WebService qui retourne le sondage actif sans
	 * paramètre La méthode checkSurvey est un WebService qui retourne le sondage
	 * actif. Il est égal à 0 s'il n'y a pas de survey.
	 *
	 * @return result, le sondage actif
	 */
	@GetMapping({ "", "/" })
	public int checkSurvey() {
		int result = 0;
		final int actualSurvey = this.service.getActualSurvey();
		if (actualSurvey != 0) {
			result = actualSurvey;
		} else {
			result = 0;
		}
		return result;
	}

	/**
	 * WebService de création d'un Survey
	 *
	 * @param survey
	 *            Le paramètre est un objet de type Survey
	 * @param survey
	 *            Le paramètre est un objet de type Survey
	 * @return Le retour est la création d'un nouvel objet de type Survey
	 * @throws EndDateException
	 *             Pour valider que la date de clôture ne puisse pas être avant la
	 *             date de lancement.
	 */
	@PostMapping({ "", "/" })
	public Survey create(@RequestBody final Survey survey) throws EndDateException {
		return this.service.create(survey);
	}

	/**
	 * WebService de suppréssion d'un Survey
	 *
	 * @param id
	 *            Le paramètre est l'id de l'objet Survey à supprimer
	 *
	 * @param id
	 *            Le paramètre est l'id de l'objet Survey à supprimer
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}

	/**
	 * WebService d'affichage de tout les survey
	 *
	 * @return Method qui liste tout les survey
	 */
	@RequestMapping("/{id}")
	public Survey getSurveyId(@PathVariable final Integer id) {

		return this.service.read(id);
	}

	@RequestMapping({ "/list" })
	public List<Survey> list() {
		return this.service.list();
	}

	/**
	 * WebService de lecture d'un survey spécifique
	 *
	 * @param id
	 *            Paramètre du survey spécifique à afficher.
	 * @param id
	 *            Paramètre du survey spécifique à afficher.
	 * @return Le survey demandé
	 */
	@RequestMapping("/read/{id}")
	public Survey read(@PathVariable final Integer id) {
		if (this.service.read(id) != null) {
			return this.service.read(id);
		}
		return null;
	}

	/**
	 * WebService de mise à jours d'un survey
	 *
	 * @param survey
	 *            Survey à mettre à jours
	 *
	 * @param survey
	 *            Survey à mettre à jours
	 * @return La mise à jours du survey
	 * @throws CloseDateException
	 *             Pour valider que la date de clôture ne soit pas avant la date de
	 *             lancement
	 */
	@PutMapping({ "", "/" })
	public Survey update(@RequestBody final Survey survey) throws CloseDateException {
		return this.service.update(survey);
	}
}
