package com.quizinfo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quizinfo.model.QuizInfo;

@Repository
public interface IQuizInfoRepository extends MongoRepository<QuizInfo, Long>{
   Optional<QuizInfo> findByQuizName(String quiz);
}
