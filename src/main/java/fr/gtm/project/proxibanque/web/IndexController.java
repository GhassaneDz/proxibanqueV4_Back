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

	@PostMapping({ "/", "/index" })
	public ModelAndView createSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			final RedirectAttributes ra) {

		String messageCloseDateExc = "";
		final Survey survey = new Survey();
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		try {
			this.surveyService.create(survey);
		} catch (final EndDateException e) {
			messageCloseDateExc = e.getMessage();
		}
		final ModelAndView mav = new ModelAndView("redirect:/index.html");
		ra.addFlashAttribute("CloseDateExc", messageCloseDateExc);
		return mav;
	}

	@GetMapping({ "/DetailsSurvey" })
	public ModelAndView detailsSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("DetailsSurvey");
		mav.addObject("feedNegCount", this.feedBackService.feedNegCount(id));
		mav.addObject("feedPosCount", this.feedBackService.feedPosCount(id));
		mav.addObject("feedBackText", this.feedBackService.findFeedBackNotNull(id));
		return mav;
	}

	@GetMapping({ "/EditSurvey" })
	public ModelAndView editSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("EditSurvey");
		mav.addObject("survey", this.surveyService.read(id));
		return mav;
	}

	@PostMapping("/EditSurvey")
	public ModelAndView editSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate closeDate,
			@RequestParam("id") final Integer id, final RedirectAttributes ra) {
		int idSurvey = 0;
		String messageEndDateExc = "";
		final Survey survey = this.surveyService.read(id);
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		survey.setCloseDate(closeDate);
		idSurvey = survey.getId();
		try {
			this.surveyService.update(survey);
		} catch (final CloseDateException e) {
			messageEndDateExc = e.getMessage();
		}
		final ModelAndView mav = new ModelAndView("redirect:/EditSurvey.html?id=" + idSurvey);
		ra.addFlashAttribute("EndDateExc", messageEndDateExc);
		return mav;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		final List<Survey> survey = this.surveyService.list();
		final int isActualSurveyExist = this.surveyService.getActualSurvey();
		mav.addObject("surveyList", survey);
		mav.addObject("surveys", this.surveyService.list());
		mav.addObject("isActualSurveyExist", isActualSurveyExist);
		return mav;
	}

}