package fr.gtm.project.proxibanque.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@GetMapping({"/", "/index"})
	public ModelAndView updateArticle() {
		final ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}