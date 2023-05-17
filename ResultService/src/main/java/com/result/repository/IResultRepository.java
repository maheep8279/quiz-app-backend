package com.result.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.result.model.Result;

@Repository
public interface IResultRepository extends MongoRepository<Result,Long> {
  Optional<Result> findByNameAndQuizNameAndDate(String name,String quizName, LocalDate date);
  List<Result> findAllByNameAndQuizName(String name,String quizName);
}
