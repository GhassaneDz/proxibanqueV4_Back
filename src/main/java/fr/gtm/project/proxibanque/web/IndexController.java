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

import fr.gtm.project.proxibanque.business.SurveyService;
import fr.gtm.project.proxibanque.domain.Survey;

@Controller
public class IndexController {

	@Autowired
	private SurveyService service;

	@GetMapping("/detail")
	public ModelAndView detailSurvey(@RequestParam("id") final Integer id, final Model map) {
		final ModelAndView mav = new ModelAndView("detail");
		map.addAttribute("survey", this.service.read(id).get());
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editSurvey(@RequestParam("id") final Integer id, final Model map) {
		final ModelAndView mav = new ModelAndView("edit");
		final Survey survey = this.service.read(id).get();
		mav.addObject("survey", survey);
		return mav;
	}

	@PostMapping("/edit")
	public ModelAndView editSurvey(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate endDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate closeDate,
			@RequestParam("id") final Integer id) {

		final Survey survey = this.service.read(id).get();
		survey.setStartDate(startDate);
		survey.setEndDate(endDate);
		survey.setCloseDate(closeDate);
		this.service.update(survey);
		final ModelAndView mav = new ModelAndView("redirect:/index.html");
		return mav;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		final List<Survey> survey = this.service.list();
		mav.addObject("surveyList", survey);
		return mav;
	}
}