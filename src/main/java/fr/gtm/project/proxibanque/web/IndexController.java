package fr.gtm.project.proxibanque.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/index")
	public ModelAndView updateArticle() {
		final ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}