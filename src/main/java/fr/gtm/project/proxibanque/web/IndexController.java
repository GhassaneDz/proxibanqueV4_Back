package fr.gtm.project.proxibanque.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.FeedbackService;
import fr.gtm.project.proxibanque.business.SurveyService;
import fr.gtm.project.proxibanque.domain.Survey;

@Controller
public class IndexController {

	@Autowired
	private SurveyService surveyService;

	@Autowired
	private FeedbackService feedBackService;

	@PostMapping({ "/", "/index" })
	public ModelAndView createSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate) {

		final Survey survey = new Survey();
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		this.surveyService.create(survey);
		final ModelAndView mav = new ModelAndView("redirect:/index.html");
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

	@GetMapping("/detail")
	public ModelAndView detailSurvey(@RequestParam("id") final Integer id, final Model map) {
		final ModelAndView mav = new ModelAndView("detail");
		map.addAttribute("survey", this.surveyService.read(id));
		return mav;
	}

	@GetMapping({ "/EditSurvey" })
	public ModelAndView editSurvey(@RequestParam("id") final Integer id) {
		final ModelAndView mav = new ModelAndView("EditSurvey");
		mav.addObject("survey", this.surveyService.read(id));
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editSurvey(@RequestParam("id") final Integer id, final Model map) {
		final ModelAndView mav = new ModelAndView("edit");
		final Survey survey = this.surveyService.read(id);
		mav.addObject("survey", survey);
		return mav;
	}

	@PostMapping("/EditSurvey")
	public ModelAndView editSurvey(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate closeDate,
			@RequestParam("id") final Integer id) {

		final Survey survey = this.surveyService.read(id);
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		survey.setCloseDate(closeDate);
		this.surveyService.update(survey);
		final ModelAndView mav = new ModelAndView("redirect:/index.html");
		return mav;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		final List<Survey> survey = this.surveyService.list();
		mav.addObject("surveyList", survey);
		mav.addObject("surveys", this.surveyService.list());
		return mav;
	}

}