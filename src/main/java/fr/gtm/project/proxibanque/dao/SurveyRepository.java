package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {

}
