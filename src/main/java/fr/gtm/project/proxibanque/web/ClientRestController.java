package fr.gtm.project.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.domain.Client;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientService service;

	/**
	 *
	 * @param client Client à crée
	 * @return La création du client
	 */
	@PostMapping({ "", "/" })
	public Client create(@PathVariable final Client client) {
		return this.service.create(client);

	}

	/**
	 *
	 * @param id Client à supprimé
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}

	/**
	 *
	 * @return La liste des clients
	 */
	@RequestMapping("/list")
	public List<Client> list() {
		return this.service.list();
	}

	/**
	 *
	 * @param id Client spécifique à afficher
	 * @return Le client à afficher
	 */
	@RequestMapping("/read/{id}")
	public Client read(@PathVariable final Integer id) {
		if (this.service.read(id) != null) {
			return this.service.read(id);
		}
		return null;
	}

	/**
	 *
	 * @param client Client à mettre à jours
	 * @return Le client à jours
	 */
	@PutMapping({ "", "/" })
	public Client update(@PathVariable final Client client) {
		return this.service.update(client);
	}
}