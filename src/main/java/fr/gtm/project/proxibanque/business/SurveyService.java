package fr.gtm.project.proxibanque.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.project.proxibanque.dao.SurveyRepository;
import fr.gtm.project.proxibanque.domain.Survey;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository repo;

	public Survey create(final Survey entity) {
		return this.repo.save(entity);
	}

	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public List<Survey> list() {
		return this.repo.findAll();
	}

	public Survey read(final Integer id) {
		Survey result = null;
		final Optional<Survey> entity = this.repo.findById(id);
		if (entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}

	public Survey update(final Survey entity) {
		return this.repo.save(entity);
	}

}
