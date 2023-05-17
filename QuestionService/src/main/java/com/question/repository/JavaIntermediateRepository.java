package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.JavaIntermediate;

@Repository
public interface JavaIntermediateRepository extends MongoRepository<JavaIntermediate, Long> {

}
