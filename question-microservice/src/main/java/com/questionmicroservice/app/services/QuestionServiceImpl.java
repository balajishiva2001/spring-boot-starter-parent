package com.questionmicroservice.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionmicroservice.app.daos.QuestionDao;
import com.questionmicroservice.app.entities.Question;
import com.questionmicroservice.app.entities.QuestionResponse;
import com.questionmicroservice.app.entities.QuestionWrapper;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		return questionDao.findByCategory(category);
	}

	@Override
	public void addQuestion(Question question) {
		questionDao.save(question);
	}

	@Override
	public void updateQuestion(int questionId, Question question) {
		Question questionFromDb = questionDao.findById(questionId).get();
		questionFromDb.setCategory(question.getCategory());
		questionFromDb.setDifficultyLevel(question.getDifficultyLevel());
		questionFromDb.setOption1(question.getOption1());
		questionFromDb.setOption2(question.getOption2());
		questionFromDb.setOption3(question.getOption3());
		questionFromDb.setOption4(question.getOption4());
		questionFromDb.setQuestionTitle(question.getQuestionTitle());
		questionFromDb.setRightAnswer(question.getRightAnswer());
		questionDao.save(questionFromDb);
	}

	@Override
	public void deleteQuestion(int questionId) {
		questionDao.delete(questionDao.findById(questionId).get());

	}

	@Override
	public Question getQuestion(int questionId) {
		return questionDao.findById(questionId).get();
	}

	@Override
	public void addQuestions(List<Question> questions) {
		questionDao.saveAll(questions);
	}

	@Override
	public List<Integer> generateQuestions(String category, int noOfQuestions) {
		return questionDao.findRandomQuestionsByCategory(category, noOfQuestions);
	}

	@Override
	public List<QuestionWrapper> getQuestionsByIds(List<Integer> questionIds) {
		List<QuestionWrapper> questionWrappers = new ArrayList<QuestionWrapper>();
		for (int id : questionIds) {
			Question question = questionDao.findById(id).get();
			questionWrappers.add(new QuestionWrapper(question.getQuestionId(), question.getQuestionTitle(),
					question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4()));
		}
		return questionWrappers;
	}

	@Override
	public Integer calculateScore(List<QuestionResponse> questionResponses) {
		int score = 0;
		for (QuestionResponse questionResponse : questionResponses) {
			if(questionDao.findById(questionResponse.getQuestionId()).get().getRightAnswer().equalsIgnoreCase(questionResponse.getResponse())) {
				score ++;
			}
		}
		return score;
	}
	
}
