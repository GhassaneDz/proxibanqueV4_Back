package fr.gtm.project.proxibanque.domain;

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
 * @author Faouzi - Nadir - Fabien: Class POJO pour la création et la gestion des feedback
 *
 */
@Entity
@Table(name = "feedBack")
public class FeedBack {

	@OneToOne
	@JoinColumn(name = "idClient", referencedColumnName = "id")
	@JsonIgnore
	private Client client;

	private boolean feedBack;

	private String feedBackText;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idSurvey", nullable = false)
	private Survey survey;

	public Client getClient() {
		return this.client;
	}

	public String getFeedBackText() {
		return this.feedBackText;
	}

	public Integer getId() {
		return this.id;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public boolean isFeedback() {
		return this.feedBack;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public void setFeedback(final boolean feedback) {
		this.feedBack = feedback;
	}

	public void setFeedBackText(final String feedBackText) {
		this.feedBackText = feedBackText;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setSurvey(final Survey survey) {
		this.survey = survey;
	}

}