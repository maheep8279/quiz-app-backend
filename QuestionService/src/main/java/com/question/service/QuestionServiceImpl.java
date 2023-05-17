package com.question.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.question.repository.HtmlRepository;
import com.question.repository.JavaAdvanceRepository;
import com.question.repository.JavaBasicRepository;
import com.question.repository.JavaIntermediateRepository;
import com.question.repository.JavaRepository;
import com.question.repository.MongodbRepository;
import com.question.repository.QuestionRepository;
import com.question.model.Html;
import com.question.model.Java;
import com.question.model.JavaAdvance;
import com.question.model.JavaBasic;
import com.question.model.JavaIntermediate;
import com.question.model.MongoDb;
import com.question.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepo;

	@Autowired
	private JavaRepository javaRepository;

	@Autowired
	private MongodbRepository mongodbRepository;

	@Autowired
	private HtmlRepository htmlRepository;

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private JavaBasicRepository javaBasicRepository;

	@Autowired
	private JavaIntermediateRepository javaIntermediateRepository;

	@Autowired
	private JavaAdvanceRepository javaAdvanceRepository;

	@Override
	public List<Question> getAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public List<Question> addQuestions(List<Question> questions) {
		return questionRepo.insert(questions);
	}

	@Override
	public List<Java> addJava(List<Java> java) {
		return javaRepository.insert(java);
	}

	@Override
	public List<MongoDb> addMongoDb(List<MongoDb> mongo) {
		return mongodbRepository.insert(mongo);
	}

	@Override
	public List<Html> addHtml(List<Html> html) {
		return htmlRepository.insert(html);
	}

	@Override
	public List<Java> getAllJava() {
		return javaRepository.findAll();
	}

	@Override
	public List<MongoDb> getAllMongo() {
		return mongodbRepository.findAll();
	}

	@Override
	public List<Html> getAllHtml() {
		return htmlRepository.findAll();
	}

	@Override
	public Java getById(long id) {
		return javaRepository.findById(id).get();
	}

	@Override
	public Java updateQuestion(Java java) {
		Optional<Java> findById = javaRepository.findById(java.getId());
		if (findById.isPresent()) {
			javaRepository.save(java);
		}
		return java;
	}

	@Override
	public String deleteJavaQuestion(long id) {
		javaRepository.deleteById(id);
		return "success";
	}

	public Set<String> getCollection() {
		return mongoOperations.getCollectionNames();
	}

	public List<String> getCollections() {
		Set<String> collectionNames = mongoOperations.getCollectionNames();
		List<String> collectList = collectionNames.stream().collect(Collectors.toList());
		Collections.sort(collectList);
		System.out.println(collectList);
		return collectList;
	}

	@Override
	public List<JavaBasic> getAllJavaBasic() {
		return javaBasicRepository.findAll();
	}

	@Override
	public List<JavaBasic> addJavaBasic(List<JavaBasic> java) {
		return javaBasicRepository.insert(java);
	}

	@Override
	public JavaBasic getByIdBasic(long id) {
		return javaBasicRepository.findById(id).get();
	}

	@Override
	public JavaBasic updateQuestionBasic(JavaBasic java) {
		Optional<JavaBasic> findById = javaBasicRepository.findById(java.getId());
		if (findById.isPresent()) {
			javaBasicRepository.save(java);
		}
		return java;
	}

	@Override
	public String deleteJavaBasicQuestion(long id) {
		javaBasicRepository.deleteById(id);
		return "success";
	}

	@Override
	public List<JavaIntermediate> getAllJavaIntermediate() {
		return javaIntermediateRepository.findAll();
	}

	@Override
	public List<JavaIntermediate> addJavaIntermediate(List<JavaIntermediate> java) {
		return javaIntermediateRepository.insert(java);
	}

	@Override
	public JavaIntermediate getByIdIntermediate(long id) {
		return javaIntermediateRepository.findById(id).get();
	}

	@Override
	public JavaIntermediate updateQuestionIntermediate(JavaIntermediate java) {
		Optional<JavaIntermediate> findById = javaIntermediateRepository.findById(java.getId());
		if (findById.isPresent()) {
			javaIntermediateRepository.save(java);
		}
		return java;
	}

	@Override
	public String deleteJavaIntermediateQuestion(long id) {
		javaIntermediateRepository.deleteById(id);
		return "success";
	}

	@Override
	public List<JavaAdvance> getAllJavaAdvance() {

		return javaAdvanceRepository.findAll();
	}

	@Override
	public List<JavaAdvance> addJavaAdvance(List<JavaAdvance> java) {

		return javaAdvanceRepository.insert(java);
	}

	@Override
	public JavaAdvance getByIdAdvance(long id) {
		return javaAdvanceRepository.findById(id).get();
	}

	@Override
	public JavaAdvance updateQuestionAdvance(JavaAdvance java) {
		Optional<JavaAdvance> findById = javaAdvanceRepository.findById(java.getId());
		if (findById.isPresent()) {
			javaAdvanceRepository.save(java);
		}
		return java;
	}

	@Override
	public String deleteJavaAdvanceQuestion(long id) {
		javaAdvanceRepository.deleteById(id);
		return "success";
	}

	@Override
	public String deleteMongo(long id) {
		mongodbRepository.deleteById(id);
		return "success";
	}

	@Override
	public String deleteHtml(long id) {
		htmlRepository.deleteById(id);
		return "success";
	}

}
