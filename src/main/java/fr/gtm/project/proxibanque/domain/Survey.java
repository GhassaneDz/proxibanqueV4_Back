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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


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
	@JsonFormat(pattern="dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate startDate ;

	@Column(nullable = false)
	@JsonFormat(pattern="dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate endDate ;

	@Column(nullable = false)
	@JsonFormat(pattern="dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate closeDate ;

	@OneToMany(mappedBy="survey", fetch=FetchType.EAGER)
	@JsonIgnore
	private List <FeedBack> feedBacks ;



	/**
	 * @return la date de fermeture du sondage
	 */
	public LocalDate getCloseDate() {
		return this.closeDate;
	}

	/**
	 * @return la date de fin du sondage
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}


	/**
	 * @return la liste des commentaires pour un sondage
	 */
	public List<FeedBack> getFeedBacks() {
		return this.feedBacks;
	}

	/**
	 * @return l'identifient de la classe Survey
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return la date de début du sondage
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}

	/**
	 * @param closeDate la date de fermeture du sondage
	 */
	public void setCloseDate(final LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @param endDate la date de fin du sondage
	 */
	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param feedBacks la liste des commentaires du sondage
	 */
	public void setFeedBacks(final List<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}

	/**
	 * @param id l'identifient de la classe Survey
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param startDate la date de début du sondage
	 */
	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}






}
