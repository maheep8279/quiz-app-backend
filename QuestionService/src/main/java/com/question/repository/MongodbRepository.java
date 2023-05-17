package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.MongoDb;

@Repository
public interface MongodbRepository extends MongoRepository<MongoDb, Long> {

}
