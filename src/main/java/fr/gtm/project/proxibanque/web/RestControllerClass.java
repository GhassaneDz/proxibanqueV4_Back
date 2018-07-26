package fr.gtm.project.proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.domain.Client;

@RestController
@RequestMapping("/client")
public class RestControllerClass {

	@Autowired
	private ClientService service;

	@RequestMapping("/{id}")
	public Client client(@PathVariable final Integer id) {
		if(this.service.read(id).isPresent()) {
			return this.service.read(id).get();
		} return null;
	}


}