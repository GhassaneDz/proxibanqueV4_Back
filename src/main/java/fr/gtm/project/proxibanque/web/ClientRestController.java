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

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.domain.Client;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientService service;

	/**
	 * Méthode de création d'un client
	 * @param client Client à crée
	 * WebService
	 * @param client Client à crée
	 * @return La création du client
	 */
	@PostMapping({ "", "/" })
	public Client create(@RequestBody final Client client) {
		return this.service.create(client);

	}

	/**
	 * Méthode de suppréssion d'un client
	 * @param id Client à supprimé
	 *
	 * @param id
	 *            Client à supprimé
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}

	/**
	 * Méthode qui liste tout les clients
	 * @return La liste des clients
	 */
	@RequestMapping("/list")
	public List<Client> list() {
		return this.service.list();
	}

	/**
	 * Méthode qui affiche un client spécifique
	 * @param id Client spécifique à afficher
	 *
	 * @param id
	 *            Client spécifique à afficher
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
	 * Méthode de mise à jours d'un client spécifique
	 * @param client Client à mettre à jours
	 *
	 * @param client
	 *            Client à mettre à jours
	 * @return Le client à jours
	 */
	@PutMapping({ "", "/" })
	public Client update(@RequestBody final Client client) {
		return this.service.update(client);
	}
}