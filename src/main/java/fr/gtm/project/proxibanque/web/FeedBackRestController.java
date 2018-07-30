package fr.gtm.project.proxibanque.web;

import java.util.List;

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

	/**
	 *
	 * @param feedBack Pour la création d'un feedback
	 * @return Le feedback à crée
	 */
	@PostMapping({ "", "/" })
	public FeedBack create(@PathVariable final FeedBack feedBack) {
		return this.FBservice.create(feedBack);
	}

	/**
	 *
	 * @param id Pour la suppréssion d'un feedback spécifique
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		this.FBservice.delete(id);
	}

	/**
	 *
	 * @return La liste des feedback
	 */
	@RequestMapping("/")
	public List<FeedBack> list() {
		return this.FBservice.list();
	}

	/**
	 *
	 * @param id Pour la lecture d'un feedback spécifique
	 * @return Le feedback spécifique à l'id
	 */
	@RequestMapping("/{id}")
	public FeedBack read(@PathVariable final Integer id) {
		if (this.FBservice.read(id) != null) {
			return this.FBservice.read(id);
		}
		return null;
	}

	/**
	 *
	 * @param feedBack Pour la mise à jours d'un feedback
	 * @return Le feedback avec les informations associés
	 */
	@PutMapping({ "", "/" })
	public FeedBack update(@RequestBody final FeedBack feedBack) {
	   return this.FBservice.update(feedBack);
	}

}
