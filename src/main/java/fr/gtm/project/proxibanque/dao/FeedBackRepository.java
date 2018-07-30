package fr.gtm.project.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.FeedBack;

/**
 * L'interface FeedBackRepository permet de lier l'entité FeedBack à un JPA
 * repository
 *
 * @author Nadir && Faouzi && Fabien
 *
 */
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

	/**
	 * Methode de Query vers SQL permettant d'afficher la liste des commentaire vide
	 * 
	 * @param id
	 *            Pour les feedback spécifique sans commentaire
	 * @return Les feedback spécifique sans commentaire
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedBackText` IS NULL", nativeQuery = true)
	List<FeedBack> findComFalse(Integer id);

	/**
	 * Methode de Query vers SQL permettant d'afficher la liste des commentaire non
	 * vide
	 * 
	 * @param id
	 *            Pour les feedback spécifique avec commentaire
	 * @return Les feedback spécifique avec commentaire
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedBackText` IS NOT NULL", nativeQuery = true)
	List<FeedBack> findComTrue(Integer id);

	/**
	 * Methode de Query vers SQL permettant de sélectionner la liste des commentaire
	 * négatif
	 * 
	 * @param id
	 *            Pour les feedback spécifique négatif
	 * @return Les feedback avec un avis négatif
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedback` = 0 ", nativeQuery = true)
	List<FeedBack> findFeedBackByNeg(Integer id);

	/**
	 * Methode de Query vers SQL permettant de sélectionner la liste des commentaire
	 * positif
	 * 
	 * @param id
	 *            Pour les feedback spécifique positif
	 * @return Les feedback avec un avis positif
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedback` = 1 ", nativeQuery = true)
	List<FeedBack> findFeedBackByPos(Integer id);

}
