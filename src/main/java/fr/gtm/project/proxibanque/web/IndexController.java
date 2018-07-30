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

@Controller
public class IndexController {

	@Autowired
	private FeedbackService feedBackService;

	@Autowired
	private SurveyService surveyService;

	/**
	 * Methode de création d'un survey
	 * @param startDate Date de début du survey
	 * @param endDate Date de fin du survey
	 * @param ra Pour effectuer une redirection avec les paramètres
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
	 * Affichage d'une page de feedback d'un survey
	 * @param id Pour affiche un feedback spécifique
	 * @return Une page de détail de feedback d'un survey
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
	 * Affichage d'un survey spécifique
	 * @param id Pour trouver un survey spécifique
	 * @return Une page détail correspondante à l'id du survey
	 */
	@GetMapping({ "/EditSurvey" })
	public ModelAndView editSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("EditSurvey");
		mav.addObject("survey", this.surveyService.read(id));
		return mav;
	}

	/**
	 * Affichage d'un survey avec toutes ces informations
	 * @param startDate Date de démarrage actuel du survey
	 * @param endDate Date de fin actuel du survey
	 * @param closeDate Date de fermeture du survey
	 * @param id Identifiant correspondant au survey
	 * @param ra Traitement de la redirection avec les paramètres
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
	 * Ahhichage de tout les survey dans la page d'acceuil
	 * @return La page d'acceuil index avec la liste des survey
	 */
	@GetMapping("/index")
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