package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.Survey;

/**
 * L'interface SurveyRepository permet de lier l'entité Survey à un JPA
 * repository
 * 
 * @author Nadir && Faouzi && Fabien
 *
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
