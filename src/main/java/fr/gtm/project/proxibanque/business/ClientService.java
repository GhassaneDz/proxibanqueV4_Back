package fr.gtm.project.proxibanque.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.project.proxibanque.dao.ClientRepository;
import fr.gtm.project.proxibanque.domain.Client;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	/**
	 *
	 * @param entity
	 *            Le client à crée
	 * @return La création du client
	 */
	public Client create(final Client entity) {
		return this.repo.save(entity);
	}

	/**
	 *
	 * @param id
	 *            Le client spécifique à supprimer
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public Client findClientByNumber(final Integer id) {
		return this.repo.findClientByNumber(id);
	}

	/**
	 *
	 * @return La liste des clients
	 */
	public List<Client> list() {
		return this.repo.findAll();
	}

	/**
	 *
	 * @param id
	 *            Du client spécifique à afficher
	 * @return Le client spécifique à l'id
	 */
	public Client read(final Integer id) {
		Client result = null;
		final Optional<Client> entity = this.repo.findById(id);
		if (entity.isPresent()) {
			result = entity.get();
		}
		return result;
	}

	/**
	 *
	 * @param entity
	 *            Le client à mettre à jours
	 * @return Le client à jours
	 */
	public Client update(final Client entity) {
		return this.repo.save(entity);
	}
}
