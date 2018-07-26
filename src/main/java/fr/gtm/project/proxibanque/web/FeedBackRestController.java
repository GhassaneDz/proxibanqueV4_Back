package fr.gtm.project.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.FeedbackService;
import fr.gtm.project.proxibanque.domain.FeedBack;

@RestController
@RequestMapping("/feedback")
public class FeedBackRestController {

	@Autowired
	private FeedbackService FBservice;

	@RequestMapping("/create/{id}")
	public FeedBack create(@PathVariable final FeedBack feedBack) {
		return this.FBservice.create(feedBack);
	}

	@RequestMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final Integer id) {
		this.FBservice.delete(id);
	}

	@RequestMapping("/list")
	public List<FeedBack> list() {
		return this.FBservice.list();
	}

	@RequestMapping("/read/{id}")
	public FeedBack read(@PathVariable final Integer id) {
		if (this.FBservice.read(id).isPresent()) {
			return this.FBservice.read(id).get();
		}
		return null;
	}

	@RequestMapping("/update/{id}")
	public FeedBack update(@PathVariable final FeedBack feedBack) {
		return this.FBservice.update(feedBack);
	}

}
