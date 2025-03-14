package com.quizmicroservice.app.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizmicroservice.app.entities.QuestionResponse;
import com.quizmicroservice.app.entities.QuestionWrapper;

@FeignClient("QUESTION-MICROSERVICE")
public interface QuestionService {

	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> generate(@RequestParam String category, @RequestParam int noOfQuestions);

	@PostMapping("/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> questionIds);

	@PostMapping("/calculatescore")
	public ResponseEntity<Integer> calculateScore(@RequestBody List<QuestionResponse> questionResponses);
}