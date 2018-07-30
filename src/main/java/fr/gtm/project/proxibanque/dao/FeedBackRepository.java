package fr.gtm.project.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

	/**
	 *
	 * @param id Pour les feedback spécifique sans commentaire
	 * @return Les feedback spécifique sans commentaire
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedBackText` IS NULL", nativeQuery = true)
	List<FeedBack> findComFalse(Integer id);

	/**
	 *
	 * @param id Pour les feedback spécifique avec commentaire
	 * @return Les feedback spécifique avec commentaire
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedBackText` IS NOT NULL", nativeQuery = true)
	List<FeedBack> findComTrue(Integer id);

	/**
	 *
	 * @param id Pour les feedback spécifique négatif
	 * @return Les feedback avec un avis négatif
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedback` = 0 ", nativeQuery = true)
	List<FeedBack> findFeedBackByNeg(Integer id);

	/**
	 *
	 * @param id Pour les feedback spécifique positif
	 * @return Les feedback avec un avis positif
	 */
	@Query(value = " SELECT * FROM `feedback` WHERE `idSurvey`=?1 AND `feedback` = 1 ", nativeQuery = true)
	List<FeedBack> findFeedBackByPos(Integer id);

}
