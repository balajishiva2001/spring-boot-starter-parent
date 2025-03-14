package com.questionmicroservice.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.questionmicroservice.app.entities.Question;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	@Query(value = "select q.id from question q where category=:category order by random() limit :noOfQuestions;", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(String category, int noOfQuestions);
	
	List<Question> findByCategory(String category);
}
