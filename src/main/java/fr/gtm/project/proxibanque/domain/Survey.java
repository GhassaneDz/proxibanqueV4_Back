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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Nadir && Faouzi && Fabien
 * @version 4.0 Classe representant un sondage proposé au client de la banque
 *
 */
@Entity
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	@JsonFormat(pattern = "dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate closeDate;

	@Column
	@JsonFormat(pattern = "dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate endDate;

	@OneToMany(mappedBy = "survey", fetch = FetchType.EAGER)
	@Column
	@JsonIgnore
	private List<FeedBack> feedBacks;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@JsonFormat(pattern = "dd-mm-yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate startDate;

	/**
	 * Getter de la méthode CloseDate
	 *
	 * @return la date de fermeture du sondage
	 */
	public LocalDate getCloseDate() {
		return this.closeDate;
	}

	/**
	 * Getter de la méthode EndDate
	 *
	 * @return la date de fin du sondage
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}

	/**
	 * Getter de la méthode Liste qui renvoie la liste des commentaires
	 *
	 * @return feedbacks la liste des commentaires pour un sondage
	 */
	public List<FeedBack> getFeedBacks() {
		return this.feedBacks;
	}

	/**
	 * getter de l'identifiant du survey
	 *
	 * @return id l'identifient de la classe Survey
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Getter de la StartDate
	 * 
	 * @return la date de début du sondage
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}

	/**
	 * Setter de la CloseDate
	 * 
	 * @param closeDate
	 *            la date de fermeture du sondage
	 *
	 */
	public void setCloseDate(final LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * Setter de la EndDate
	 * 
	 * @param endDate
	 *            la date de fin du sondage
	 *
	 */
	public void setEndDate(final LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Setter des feedbacks
	 * 
	 * @param feedBacks
	 *            la liste des commentaires du sondage
	 *
	 */
	public void setFeedBacks(final List<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}

	/**
	 * Setter de l'id de la survey
	 * 
	 * @param id
	 *            l'identifiant de la classe Survey
	 *
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter de la StartDate
	 * 
	 * @param startDate
	 *            la date de début du sondage
	 *
	 */
	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

}
