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

/**
 * Controlleur REST des commentaires (feedback)
 * 
 * @author Nadir && Faouzi && Fabien
 *
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackRestController {

	@Autowired
	private FeedbackService feedBservice;

	/**
	 * WebService POST permettant de créer en persistence un nouveau commentaire
	 * (feedback)
	 *
	 * @param feedBack
	 *            Pour la création d'un feedback
	 * @return Le feedback à crée
	 */
	@PostMapping({ "", "/" })
	public FeedBack create(@RequestBody final FeedBack feedBack) {
		return this.feedBservice.create(feedBack);
	}

	/**
	 * WebService permettant la suppression d'un commentaire en persistence à partir
	 * de son Id
	 *
	 * @param id
	 *            Pour la supression d'un feedback spécifique
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		this.feedBservice.delete(id);
	}

	/**
	 * WebService permettant de retourner la liste des commentaires présents en
	 * persistence
	 *
	 * @return La liste des feedback
	 */
	@RequestMapping("/")
	public List<FeedBack> list() {
		return this.feedBservice.list();
	}

	/**
	 * WebService permettant l'affichage d'un commentaire à partir d'un Id présent
	 * dans la Variable Path. Soit l'id est Null et la méthode renvoie un
	 * commentaire vide, soit l'id est présent et la méthode renvoie le commentaire.
	 *
	 * @param id
	 *            numéro d'identification d'un commentaire permettant son affichage
	 * @return Le commentaire spécifique à l'id
	 */
	@RequestMapping("/{id}")
	public FeedBack read(@PathVariable final Integer id) {
		if (this.feedBservice.read(id) != null) {
			return this.feedBservice.read(id);
		}
		return null;
	}

	/**
	 * WebService permettant la mise à jour d'un commentaire en persistence
	 *
	 * @param feedBack
	 *            est le commentaire à mettre à jour
	 *
	 * @return Le feedback avec les informations misent à jour
	 */
	@PutMapping({ "", "/" })
	public FeedBack update(@RequestBody final FeedBack feedBack) {
		return this.feedBservice.update(feedBack);
	}

}
