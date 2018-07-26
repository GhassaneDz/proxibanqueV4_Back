package fr.gtm.project.proxibanque.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedBack")
public class FeedBack {

	@OneToOne
	@JoinColumn(name = "idClient", referencedColumnName = "id")
	private Client client;

	private boolean feedBack;

	private String feedBackText;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idSurvey", nullable = false)
	private Survey survey;

	/**
	 *
	 */
	public FeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param feedBackText
	 * @param feedback
	 * @param survey
	 * @param client
	 */
	public FeedBack(final Integer id, final String feedBackText, final boolean feedback, final Survey survey,
			final Client client) {
		super();
		this.id = id;
		this.feedBackText = feedBackText;
		this.feedBack = feedback;
		this.survey = survey;
		this.client = client;
	}

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

	@Override
	public String toString() {
		return "FeedBack [id=" + this.id + ", feedBackText=" + this.feedBackText + ", feedBack=" + this.feedBack
				+ ", survey=" + this.survey + ", client=" + this.client + "]";
	}
}