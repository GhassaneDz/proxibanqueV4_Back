package fr.gtm.project.proxibanque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Faouzi - Nadir - Fabien: Class POJO pour la création et la gestion
 *         des feedback
 *
 */
@Entity
@Table(name = "feedBack")
public class FeedBack implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "idClient", referencedColumnName = "id", nullable = false)
	private Client client;

	private boolean feedback;

	public boolean isNewClients() {
		return newClients;
	}

	public void setNewClients(boolean newClients) {
		this.newClients = newClients;
	}

	private String feedBackText;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idSurvey", nullable = false)
	private Survey survey;
	
	boolean newClients ; 

	/**
	 * Getter du client
	 *
	 * @return un client
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 * Getter d'un commentaire (feedBackText)
	 *
	 * @return feedBackText le commentaire
	 */
	public String getFeedBackText() {
		return this.feedBackText;
	}

	/**
	 * Getter de l'id d'un feedback
	 *
	 * @return l'id du feedback
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Getter du sondage (survey)
	 *
	 * @return survey :le sondage
	 */
	public Survey getSurvey() {
		return this.survey;
	}

	/**
	 * Méthode permettant de savoir si un commentaire est présent ou non. C'est un
	 * boolean. S'il est true il y a un commentaire. S'il est false c'est qu'il n'y
	 * a pas de commentaire.
	 *
	 * @return feedback le boolean(présence ou absence d'un commentaire).
	 */
	public boolean isFeedback() {
		return this.feedback;
	}

	/**
	 * Setter d'un client
	 *
	 * @param client
	 *            le client créer
	 */
	public void setClient(final Client client) {
		this.client = client;
	}

	/**
	 * Setter du boolen feedback. FeedBack est true s'il y a un commentaire ou false
	 * s'il n'y en a pas.
	 *
	 * @param feedback
	 *            le boolen (présence ou absence de commentaire)
	 */
	public void setFeedback(final boolean feedback) {
		this.feedback = feedback;
	}

	/**
	 * Setter de FeedBackText, le commentaire
	 *
	 * @param feedBackText
	 *            le commentaire à créer.
	 */
	public void setFeedBackText(final String feedBackText) {
		this.feedBackText = feedBackText;
	}

	/**
	 * Setter de l'id d'un feedback
	 *
	 * @param id
	 *            l'identifiant d'un feedback
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter d'un sondage (survey)
	 *
	 * @param survey
	 *            le sondage
	 */
	public void setSurvey(final Survey survey) {
		this.survey = survey;
	}
}
