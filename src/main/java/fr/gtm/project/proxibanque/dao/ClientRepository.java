package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value = " SELECT * FROM `client` WHERE `number`=?1 ", nativeQuery = true)
	Client findClientByNumber(Integer id);

}
