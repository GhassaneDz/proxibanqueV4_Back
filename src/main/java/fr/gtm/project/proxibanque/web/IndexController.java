package fr.gtm.project.proxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.gtm.project.proxibanque.business.FeedbackService;
import fr.gtm.project.proxibanque.business.SurveyService;
import fr.gtm.project.proxibanque.domain.CloseDateException;
import fr.gtm.project.proxibanque.domain.EndDateException;
import fr.gtm.project.proxibanque.domain.Survey;

/**
 * IndexController permet de dispatcher les requetes HTTP concernant BackEnd
 *
 * @author Nadir && Faouzi && Fabien
 *
 */
@Controller
public class IndexController {

	@Autowired
	private FeedbackService feedBackService;

	@Autowired
	private SurveyService surveyService;

	/**
	 * La méthode createSurvey est la méthode de création d'un sondage à partir du
	 * formulaire de la page d'acceuil. Cette méthode vérifie si la date de fin
	 * postée est bien plus ancienne que la date de début du sondage.
	 *
	 * @param startDate
	 *            Date de début du sondage
	 * @param endDate
	 *            Date de fin du sondage
	 * @param ra
	 *            Message d'erreur transmis par l'URL si erreur (date de fin plus
	 *            ancienne que la date de début du sondage.)
	 * @return Un mav avec le survey demandé
	 */
	@PostMapping({ "/", "/index" })
	public ModelAndView createSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			final RedirectAttributes ra) {
		String messageEndDateExc = "";
		final Survey survey = new Survey();
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		try {
			this.surveyService.create(survey);
		} catch (final EndDateException e) {
			messageEndDateExc = e.getMessage();
		}
		final ModelAndView mav = new ModelAndView("redirect:/index.html");
		ra.addFlashAttribute("endDateExc", messageEndDateExc);
		return mav;
	}

	/**
	 * Méthode d'affichage de la liste des commentaires pour un sondage spécifique
	 *
	 * @param id
	 *            l'id du sondage. un appel au service comenatire permet de
	 *            récupérer le décompte des commentaires positifs ou négatif de ce
	 *            sondage.
	 *
	 * @return Une page de détail des commentaires d'un sondage
	 */
	@GetMapping({ "/DetailsSurvey" })
	public ModelAndView detailsSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("DetailsSurvey");
		mav.addObject("feedNegCount", this.feedBackService.feedNegCount(id));
		mav.addObject("feedPosCount", this.feedBackService.feedPosCount(id));
		mav.addObject("feedBackText", this.feedBackService.findFeedBackNotNull(id));

		return mav;
	}

	/**
	 * Méthode d'affichage d'un sondage spécifique. Elle permet d'afficher le
	 * sondage à éditer, c'est à dire la date de cloture du sondage.
	 *
	 * @param id
	 *            Pour trouver le survey à cloturer
	 * @return la page permettant de cloturer le sondage
	 */
	@GetMapping({ "/EditSurvey" })
	public ModelAndView editSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("EditSurvey");
		mav.addObject("survey", this.surveyService.read(id));
		return mav;
	}

	/**
	 * Méthode de mise à jour d'un sondage. Cette méthode récupère la date de début,
	 * de fin et de cloture (nouvellement proposé par le gestionnaire) Cette méthode
	 * vérifie si la date de cloture postée est bien plus ancienne que la date de
	 * début du sondage.
	 *
	 * @param startDate
	 *            Date de démarrage actuel du sondage
	 * @param endDate
	 *            Date de fin actuel du sondage
	 * @param closeDate
	 *            Date de cloture du sondage
	 * @param id
	 *            Identifiant correspondant au sondage à mettre à jour
	 * @param ra
	 *            Message d'erreur transmis par l'URL si erreur (date de cloture
	 *            plus ancienne que la date de début du sondage.)
	 * @return La page d'edition du survey
	 */
	@PostMapping("/EditSurvey")
	public ModelAndView editSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate closeDate,
			@RequestParam("id") final Integer id, final RedirectAttributes ra) {
		int idSurvey = 0;
		String messageCloseDateExc = "";
		final Survey survey = this.surveyService.read(id);
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		survey.setCloseDate(closeDate);
		idSurvey = survey.getId();
		final ModelAndView mav = new ModelAndView();
		try {
			this.surveyService.update(survey);
		} catch (final CloseDateException e) {
			messageCloseDateExc = e.getMessage();
		}
		if (messageCloseDateExc == "") {
			mav.setViewName("redirect:/index.html");
		} else {
			mav.setViewName("redirect:/EditSurvey.html?id=" + idSurvey);
			ra.addFlashAttribute("CloseDateExc", messageCloseDateExc);
		}
		return mav;
	}

	/**
	 * Méthode d'affichage de l'entièreté des sondages dans la page d'acceuil. Cette
	 * méthode vérifie directement si un sondage est en cours ou non. Celà permet
	 * d'empécher la création d'un nouveau sondage le cas échéant.
	 *
	 * @return La page d'acceuil index avec la liste des survey
	 */
	@GetMapping({ "/", "/index" })
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		final List<Survey> survey = this.surveyService.list();
		final Integer isActualSurveyExist = this.surveyService.getActualSurvey();
		mav.addObject("surveyList", survey);
		mav.addObject("surveys", this.surveyService.list());
		mav.addObject("isActualSurveyExist", isActualSurveyExist);
		return mav;
	}
}
