package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.JavaBasic;

@Repository
public interface JavaBasicRepository extends MongoRepository<JavaBasic, Long> {

}
