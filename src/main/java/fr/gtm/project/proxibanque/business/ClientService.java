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
	 * Méthode service de création d'un client
	 * @param entity Le client à crée
	 * Méthode de création d'un client
	 *
	 * @param entity
	 *            Le client à crée
	 * @return La création du client
	 */
	public Client create(final Client entity) {
		return this.repo.save(entity);
	}

	/**
	 * Méthode service de suppréssion d'un client
	 * @param id Le client spécifique à supprimer
	 * Methode de suppresion d'un client
	 *
	 * @param id
	 *            Le client spécifique à supprimer
	 *
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 * Méthode service de listing des clients
	 * Méthode de recherche d'un numéro de client à partir de son Id
	 *
	 * @param id
	 *            l'id du client
	 * @return le numéro du client
	 */
	public Client findClientByNumber(final Integer id) {
		return this.repo.findClientByNumber(id);
	}

	/**
	 * Méthode de listing de tous les clients
	 *
	 * @return La liste des clients
	 */
	public List<Client> list() {
		return this.repo.findAll();
	}

	/**

	 * Méthode service de lecture d'un client spécifique
	 * @param id Du client spécifique à afficher
	 * @return Le client spécifique à l'id

	 * Méthode d'affichage d'un client à partir de son Id
	 *
	 * @param id
	 *            Du client spécifique à afficher
	 * @return Le client d'après son Id
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
	 * Méthode service de mise à jours d'un client
	 * @param entity Le client à mettre à jours
	 * @return Le client à jours
	 * Mise à jour d'un client à partir de sont Id.
	 *
	 * @param entity
	 *            Le client à mettre à jour
	 * @return Le client à jour est enregistré en BDD
	 */
	public Client update(final Client entity) {
		return this.repo.save(entity);
	}
}
