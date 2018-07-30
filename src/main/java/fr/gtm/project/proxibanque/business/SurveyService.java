package fr.gtm.project.proxibanque.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.project.proxibanque.dao.SurveyRepository;
import fr.gtm.project.proxibanque.domain.CloseDateException;
import fr.gtm.project.proxibanque.domain.EndDateException;
import fr.gtm.project.proxibanque.domain.Survey;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository repo;

	public Survey create(final Survey entity) throws EndDateException {
		if (entity.getEndDate().isBefore(entity.getStartDate())) {
			throw new EndDateException(
					"Vous ne pouvez pas renseigner une date de fin antérieure à la date de début du sondage.");
		}
		return this.repo.save(entity);
	}

	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public int getActualSurvey() {
		int result = 0;
		final LocalDate today = LocalDate.now();
		final List<Survey> listSurvey = this.list();
		for (final Survey survey : listSurvey) {
			if (today.isAfter(survey.getStartDate()) && today.isBefore(survey.getEndDate())) {
				result = survey.getId();
			}
		}
		return result;
	}

	public int isSurveyClosable() {
		int isSurveyCurrent = 0;
		final LocalDate today = LocalDate.now();
		final List<Survey> listSurvey = this.list();
		for (final Survey survey : listSurvey) {
			if (((survey.getCloseDate() == null) || survey.getEndDate().isAfter(today))) {
				isSurveyCurrent = survey.getId();
			}
		}
		return isSurveyCurrent;

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

	public Survey update(final Survey entity) throws CloseDateException {
		if (entity.getCloseDate().isBefore(entity.getStartDate())) {
			throw new CloseDateException(
					"Vous ne pouvez pas renseigner une date de cloture antérieure à la date de début du sondage");
		}
		return this.repo.save(entity);
	}

}
