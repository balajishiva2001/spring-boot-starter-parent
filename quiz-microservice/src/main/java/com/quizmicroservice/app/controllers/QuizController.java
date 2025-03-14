package com.quizmicroservice.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizmicroservice.app.entities.QuestionResponse;
import com.quizmicroservice.app.entities.QuestionWrapper;
import com.quizmicroservice.app.services.QuizService;



@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions,
			@RequestParam String title) {
		quizService.createQuiz(category, noOfQuestions, title);
		return new ResponseEntity<String>("Quiz Created", HttpStatus.CREATED);
	}

	@GetMapping("/{quizId}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int quizId) {
		return new ResponseEntity<List<QuestionWrapper>>(quizService.getQuizQuestions(quizId), HttpStatus.OK);
	}

	@PostMapping("/calculatescore")
	public ResponseEntity<String> calculateQuizScore(@RequestBody List<QuestionResponse> questionResponses) {
		return new ResponseEntity<String>(new StringBuilder("Quiz Score: ")
				.append(quizService.calculateQuizScore(questionResponses)).toString(), HttpStatus.OK);
	}
}
