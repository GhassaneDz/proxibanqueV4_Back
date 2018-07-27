package fr.gtm.project.proxibanque.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/{id}")
	public FeedBack create(@PathVariable final FeedBack feedBack) {
		return this.FBservice.create(feedBack);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		this.FBservice.delete(id);
	}

	@RequestMapping("/")
	public List<FeedBack> list() {
		return this.FBservice.list();
	}

	@RequestMapping("/{id}")
	public FeedBack read(@PathVariable final Integer id) {
		if (this.FBservice.read(id) != null) {
			return this.FBservice.read(id);
		}
		return null;
	}

	@PutMapping("/update/{id}")
	public FeedBack update(@RequestBody final FeedBack feedBack, final HttpServletResponse response)
			throws IOException {
		if (feedBack.getId() == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "The feedBack id is missing to update.");
		}
		return this.FBservice.update(feedBack);
	}

}
