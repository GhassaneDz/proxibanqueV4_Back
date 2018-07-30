package fr.gtm.project.proxibanque.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.project.proxibanque.dao.FeedBackRepository;
import fr.gtm.project.proxibanque.domain.FeedBack;

@Service
public class FeedbackService {

	@Autowired
	private FeedBackRepository repo;

	/**
	 * Méthode de création d'un feedBack
	 *
	 * @param entity
	 *            le Feedback à créer
	 * @return Le nouvel objet feedback
	 */
	public FeedBack create(final FeedBack entity) {
		return this.repo.save(entity);
	}

	/**
	 *
	 * @param id
	 *            Id de l'objet Fedback à supprimer
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 *
	 * @param id
	 *            Feedback auquel il faut affecter un décrement
	 * @return Le Feedback avec la nouvelle valeur de décrement
	 */
	public Integer feedNegCount(final Integer id) {
		return this.repo.findFeedBackByNeg(id).size();
	}

	/**
	 *
	 * @param id
	 *            Feedback auquel il faut affecter un incrément
	 * @return Le Feedback avec la nouvelle valeur d'incrémentation
	 */
	public Integer feedPosCount(final Integer id) {
		return this.repo.findFeedBackByPos(id).size();
	}

	/**
	 *
	 * @param id
	 *            Pour trouver un feedback qui n'est pas null
	 * @return Le feedback qui n'est pas null
	 */
	public List<FeedBack> findFeedBackNotNull(final Integer id) {
		return this.repo.findComTrue(id);
	}

	/**
	 *
	 * @param id
	 *            Pour trouver un feedback qui est null
	 * @return Le feedback avec un commentaire null
	 */
	public List<FeedBack> findFeedBackNull(final Integer id) {
		return this.repo.findComFalse(id);
	}

	/**
	 *
	 * @return La liste des feedback
	 */
	public List<FeedBack> list() {
		return this.repo.findAll();
	}

	/**
	 *
	 * @param id
	 *            Pour lire un feedback spécifique avec son Id
	 * @return Le feedback associé à l'id
	 */
	public FeedBack read(final Integer id) {
		FeedBack result = null;
		final Optional<FeedBack> entity = this.repo.findById(id);
		if (entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}

	/**
	 *
	 * @param entity
	 *            Le feedback à mettre à jours
	 * @return Le feedback à jours
	 */
	public FeedBack update(final FeedBack entity) {
		return this.repo.save(entity);
	}
}
