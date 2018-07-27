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

	public FeedBack create(final FeedBack entity) {
		return this.repo.save(entity);
	}

	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public List<FeedBack> list() {
		return this.repo.findAll();
	}

	public FeedBack read(final Integer id) {
		FeedBack result = null;
		final Optional<FeedBack> entity = this.repo.findById(id);
		if (entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}

	public FeedBack update(final FeedBack entity) {
		return this.repo.save(entity);
	}

}
