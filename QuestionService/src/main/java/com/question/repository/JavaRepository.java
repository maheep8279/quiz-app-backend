package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Java;

@Repository
public interface JavaRepository extends MongoRepository<Java, Long> {

}
