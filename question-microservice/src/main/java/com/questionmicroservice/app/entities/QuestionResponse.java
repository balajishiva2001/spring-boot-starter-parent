package com.questionmicroservice.app.entities;

public class QuestionResponse {

	private int questionId;
	
	private String response;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public QuestionResponse(int questionId, String response) {
		super();
		this.questionId = questionId;
		this.response = response;
	}

	public QuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QuestionResponse [questionId=" + questionId + ", response=" + response + "]";
	}
	
}
