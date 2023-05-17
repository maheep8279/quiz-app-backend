package com.question.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Html;

@Repository
public interface HtmlRepository extends MongoRepository<Html, Long> {

}
