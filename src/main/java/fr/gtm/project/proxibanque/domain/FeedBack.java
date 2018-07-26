package fr.gtm.project.proxibanque.domain;

public class FeedBack {

	private Integer id;
	private String feedBackText;
	private boolean feedback;
	private Survey survey;
	private Client client;

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
	public FeedBack(final Integer id, final String feedBackText, final boolean feedback, final Survey survey, final Client client) {
		super();
		this.id = id;
		this.feedBackText = feedBackText;
		this.feedback = feedback;
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
		return this.feedback;
	}

	public void setClient(final Client client) {
		this.client = client;
	}

	public void setFeedback(final boolean feedback) {
		this.feedback = feedback;
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
		return "FeedBack [id=" + this.id + ", feedBackText=" + this.feedBackText + ", feedback=" + this.feedback + ", survey=" + this.survey
				+ ", client=" + this.client + "]";
	}
}