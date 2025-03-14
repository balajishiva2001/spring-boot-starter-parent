package com.questionmicroservice.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionmicroservice.app.entities.Question;
import com.questionmicroservice.app.entities.QuestionResponse;
import com.questionmicroservice.app.entities.QuestionWrapper;
import com.questionmicroservice.app.services.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@GetMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<List<Question>>(questionService.getAllQuestions(), HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return new ResponseEntity<List<Question>>(questionService.getQuestionByCategory(category), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		questionService.addQuestion(question);
		return new ResponseEntity<String>("Question Created", HttpStatus.CREATED);
	}
	
	@PostMapping("/createQuestions")
	public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions){
		questionService.addQuestions(questions);
		return new ResponseEntity<String>("Multiple Questions Created", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question question){
		questionService.updateQuestion(id, question);
		return new ResponseEntity<String>("Question Updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id){
		questionService.deleteQuestion(id);
		return new ResponseEntity<String>("Question Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable int id){
		return new ResponseEntity<Question>(questionService.getQuestion(id), HttpStatus.OK);
	}
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam int noOfQuestions){
		return new ResponseEntity<List<Integer>>(questionService.generateQuestions(category, noOfQuestions), HttpStatus.OK);
	}
	
	@PostMapping("/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> questionIds){
		return new ResponseEntity<List<QuestionWrapper>>(questionService.getQuestionsByIds(questionIds),HttpStatus.OK);
	}
	
	@PostMapping("/calculatescore")
	public ResponseEntity<Integer> calculateScore(@RequestBody List<QuestionResponse> questionResponses){
		return new ResponseEntity<Integer>(questionService.calculateScore(questionResponses), HttpStatus.OK);
	}
}
