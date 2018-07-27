package fr.gtm.project.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.project.proxibanque.domain.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

	@Query(value = " SELECT * FROM `feedback` WHERE `feedBackText` IS NULL", nativeQuery = true)
	List<FeedBack> findComFalse();

	@Query(value = " SELECT * FROM `feedback` WHERE `feedBackText` IS NOT NULL", nativeQuery = true)
	List<FeedBack> findComTrue();

	@Query(value = " SELECT * FROM `feedback` WHERE `feedback` = 0 ", nativeQuery = true)
	List<FeedBack> findFeedBackByNeg();

	@Query(value = " SELECT * FROM `feedback` WHERE `feedback` = 1 ", nativeQuery = true)
	List<FeedBack> findFeedBackByPos();

}
