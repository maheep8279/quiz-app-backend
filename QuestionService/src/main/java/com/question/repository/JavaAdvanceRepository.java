package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.JavaAdvance;

@Repository
public interface JavaAdvanceRepository extends MongoRepository<JavaAdvance, Long> {

}
