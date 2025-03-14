package com.questionmicroservice.app.services;

import java.util.List;

import com.questionmicroservice.app.entities.Question;
import com.questionmicroservice.app.entities.QuestionResponse;
import com.questionmicroservice.app.entities.QuestionWrapper;


public interface QuestionService {
	
	List<Question> getAllQuestions();
	
	List<Question> getQuestionByCategory(String category);
	
	void addQuestion(Question question);
	
	void updateQuestion(int questionId, Question question);
	
	void deleteQuestion(int questionId);
	
	Question getQuestion(int questionId);

	void addQuestions(List<Question> questions);

	List<Integer> generateQuestions(String category, int noOfQuestions);

	List<QuestionWrapper> getQuestionsByIds(List<Integer> questionIds);

	Integer calculateScore(List<QuestionResponse> questionResponses);
}
