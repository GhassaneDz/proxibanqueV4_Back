package fr.gtm.project.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.domain.Client;

/**
 * Controlleur REST des clients
 *
 * @author Nadir && Faouzi && Fabien
 *
 */
@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientService service;

	/**
	 *
	 * WebService permettant de créer un client en persistence. Cette methode
	 * requiert un client lors de la méthode POST.
	 *
	 * @param client
	 *            le client à créer en persistence
	 *
	 * @return client, Le client créé en persistence
	 *
	 */
	@PostMapping({ "", "/" })
	public Client create(@RequestBody final Client client) {
		return this.service.create(client);

	}

	/**
	 * WebService permettant l'affichage de la liste des client présent en
	 * persistence
	 *
	 * @return La liste des clients présent en persistence
	 *
	 * @param id
	 *            Client à supprimé
	 */
	@RequestMapping("/list")
	public List<Client> list() {
		return this.service.list();
	}

	/**
	 * WebService permettant l'affichage d'un client à partir d'un Id présent dans
	 * la Variable Path. Soit l'id est Null et la méthode renvoie un client vide,
	 * soit l'id est présent et la méthode renvoie le client.
	 *
	 * @param id
	 *            Client spécifique à afficher
	 * @return Le client à afficher (soit null s'il n'y a pas de client associé à
	 *         l'id, soit le client si l'association id<-> client existe
	 */
	@RequestMapping("/read/{id}")
	public Client read(@PathVariable final Integer id) {
		if (this.service.read(id) != null) {
			return this.service.read(id);
		}
		return null;
	}

	/**
	 * WebService permettant de mettre à jour un client. Cette méthode requiert un
	 * client en paramètre
	 *
	 * ======= Méthode de mise à jours d'un client spécifique
	 *
	 * @param client
	 *            Client à mettre à jours
	 *
	 *
	 * @return client Le client mis à jour avec les nouvelles informations
	 */
	@PutMapping({ "", "/" })
	public Client update(@RequestBody final Client client) {
		return this.service.update(client);
	}
}
