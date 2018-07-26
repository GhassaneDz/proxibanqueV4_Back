package fr.gtm.project.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.domain.Client;

@RestController
@RequestMapping("/client")
public class RestControllerClass {

	@Autowired
	private ClientService service;

	@RequestMapping("/create/{id}")
	public Client create(@PathVariable final Client client) {
		return this.service.create(client);
	}

	@RequestMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}

	@RequestMapping("/clients")
	public List<Client> list(){
		return this.service.list();
	}

	@RequestMapping("/read/{id}")
	public Client read(@PathVariable final Integer id) {
		if(this.service.read(id).isPresent()) {
			return this.service.read(id).get();
		} return null;
	}

	@RequestMapping("/update/{id}")
	public Client update(@PathVariable final Client client) {
		return this.service.update(client);
	}
}