package com.quizmicroservice.app.services;

import java.util.List;

import com.quizmicroservice.app.entities.QuestionResponse;
import com.quizmicroservice.app.entities.QuestionWrapper;



public interface QuizService {
	
	void createQuiz(String category, int noOfQuestions, String title);
	
	List<QuestionWrapper> getQuizQuestions(int quizId);
	
	int calculateQuizScore(List<QuestionResponse> questionResponses);
}
