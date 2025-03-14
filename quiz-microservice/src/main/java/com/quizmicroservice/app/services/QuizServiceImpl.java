package com.quizmicroservice.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizmicroservice.app.daos.QuizDao;
import com.quizmicroservice.app.entities.QuestionResponse;
import com.quizmicroservice.app.entities.QuestionWrapper;
import com.quizmicroservice.app.entities.Quiz;
import com.quizmicroservice.app.feign.QuestionService;



@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDao quizDao;

	@Autowired
	private QuestionService questionService;

	@Override
	public void createQuiz(String category, int noOfQuestions, String title) {
		List<Integer> questions = (List<Integer>) questionService.generate(category, noOfQuestions);
		Quiz quiz = new Quiz(0, title, questions);
		quizDao.save(quiz);
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(int quizId) {
		Quiz quiz = quizDao.findById(quizId).get();
		List<Integer> questions = quiz.getQuestionIds();
		return (List<QuestionWrapper>) questionService.getQuestionsByIds(questions);
	}

	@Override
	public int calculateQuizScore(List<QuestionResponse> questionResponses) {
		return (int) questionService.calculateScore(questionResponses).getBody();
	}

}
