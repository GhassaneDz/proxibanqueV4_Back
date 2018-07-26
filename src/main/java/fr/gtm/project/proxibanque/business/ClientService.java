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

	public Client create(final Client entity) {
		return this.repo.save(entity);
	}

	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	public List<Client> list() {
		return this.repo.findAll();
	}

	public Optional<Client> read(final Integer id) {
		return this.repo.findById(id);
	}

	public Client update(final Client entity) {
		return this.repo.save(entity);
	}

}
