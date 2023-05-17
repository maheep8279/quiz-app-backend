package com.question.service;

import java.util.List;
import java.util.Set;

import com.question.model.Html;
import com.question.model.Java;
import com.question.model.JavaAdvance;
import com.question.model.JavaBasic;
import com.question.model.JavaIntermediate;
import com.question.model.MongoDb;
import com.question.model.Question;

public interface QuestionService {
  public List<Question> getAllQuestions();
  public List<Question> addQuestions(List<Question> questions);
	

	List<Java> addJava(List<Java> java);

	List<MongoDb> addMongoDb(List<MongoDb> mongo);

	List<Html> addHtml(List<Html> html);

	List<Java> getAllJava();

	List<MongoDb> getAllMongo();

	List<Html> getAllHtml();

	Java getById(long id);

	Java updateQuestion(Java java);

	String deleteJavaQuestion(long id);

	Set<String> getCollection();

	List<JavaBasic> getAllJavaBasic();

	JavaBasic getByIdBasic(long id);

	JavaBasic updateQuestionBasic(JavaBasic java);

	String deleteJavaBasicQuestion(long id);

	List<JavaBasic> addJavaBasic(List<JavaBasic> java);

	List<JavaIntermediate> getAllJavaIntermediate();

	List<JavaIntermediate> addJavaIntermediate(List<JavaIntermediate> java);

	JavaIntermediate getByIdIntermediate(long id);

	JavaIntermediate updateQuestionIntermediate(JavaIntermediate java);

	String deleteJavaIntermediateQuestion(long id);

	List<JavaAdvance> getAllJavaAdvance();

	List<JavaAdvance> addJavaAdvance(List<JavaAdvance> java);

	JavaAdvance getByIdAdvance(long id);

	JavaAdvance updateQuestionAdvance(JavaAdvance java);

	String deleteJavaAdvanceQuestion(long id);

	List<String> getCollections();

	String deleteMongo(long id);

	String deleteHtml(long id);

}
