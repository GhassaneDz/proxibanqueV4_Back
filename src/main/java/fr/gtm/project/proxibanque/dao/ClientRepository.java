package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.Client;

/**
 * L'interface ClientRepository permet de lier l'entité Client à un JPA
 * repository
 *
 * @author Nadir && Faouzi && Fabien
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	/**
	 * Methode de Query vers SQL permettant de rechercher un client à partir de son
	 * numéro d'identifiant (number)
	 * 
	 * @param id
	 *            l'id du client à partir duquel rechercher son numéro.
	 * @return
	 */
	@Query(value = " SELECT * FROM `client` WHERE `number`=?1 ", nativeQuery = true)
	Client findClientByNumber(Integer id);

}
