package com.quizmicroservice.app.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quizId;
	
	private String title;
	
	@ElementCollection
	private List<Integer> questionIds;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int quizId, String title, List<Integer> questionIds) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.questionIds = questionIds;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", title=" + title + ", questionIds=" + questionIds + "]";
	}

}
