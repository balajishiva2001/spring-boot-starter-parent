package com.quizmicroservice.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizmicroservice.app.entities.Quiz;



@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
