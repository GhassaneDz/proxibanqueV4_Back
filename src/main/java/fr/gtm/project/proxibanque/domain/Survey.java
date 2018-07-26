package fr.gtm.project.proxibanque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nadir && Faouzi && Fabien
 * @version 4.0
 * Classe representant un sondage proposé au client de la banque
 *
 */
@Entity
public class Survey implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	
	@Column(nullable = false)
	private LocalDate startDate ;
	
	@Column(nullable = false)
	private LocalDate endDate ;
	
	@Column(nullable = false)
	private LocalDate closeDate ;
	
	@OneToMany(mappedBy="survey", fetch=FetchType.EAGER)
	@JsonIgnore
	private List <FeedBack> feedBacks ;
	
	
	
	/**
	 * @return l'identifient de la classe Survey 
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id l'identifient de la classe Survey
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * @return la date de début du sondage
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate la date de début du sondage
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return la date de fin du sondage
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate la date de fin du sondage
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return la date de fermeture du sondage
	 */
	public LocalDate getCloseDate() {
		return closeDate;
	}
	
	/**
	 * @param closeDate la date de fermeture du sondage
	 */
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}
	
	/**
	 * @return la liste des commentaires pour un sondage
	 */
	public List<FeedBack> getFeedBacks() {
		return feedBacks;
	}
	
	/**
	 * @param feedBacks la liste des commentaires du sondage
	 */
	public void setFeedBacks(List<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}
	
	
	
	
	

}
