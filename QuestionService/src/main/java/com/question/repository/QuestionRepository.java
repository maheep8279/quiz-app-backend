package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {

}
