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

import fr.gtm.project.proxibanque.business.SurveyService;
import fr.gtm.project.proxibanque.domain.Survey;

@RestController
@RequestMapping("/survey")
public class SurveyRestController {

	@Autowired
	private SurveyService service ; 
	
	@PostMapping("/")
	public Survey create(@PathVariable final Survey survey) {
		return this.service.create(survey);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}
	
	@RequestMapping("/surveys")
	public List<Survey> list(){
		return this.service.list();
	}
	
	@RequestMapping("/read/{id}")
	public Survey read(@PathVariable final Integer id) {
		if(this.service.read(id).isPresent()) {
			return this.service.read(id).get();
		} return null;
	}
	
	@PutMapping("/update/{id}")
	public Survey update(@RequestBody final Survey survey) {
		return this.service.update(survey);
	}
}