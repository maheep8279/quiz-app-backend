package com.question.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.exception.SequenceException;
import com.question.model.Html;
import com.question.model.Java;
import com.question.model.JavaAdvance;
import com.question.model.JavaBasic;
import com.question.model.JavaIntermediate;
import com.question.model.MongoDb;
import com.question.model.Question;
import com.question.service.QuestionService;
import com.question.service.SequenceDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {
   
	@Autowired
	private QuestionService service;
	
	@Autowired
	private SequenceDao sequenceDao;
		
	@GetMapping("/")
	public List<Question> showAllQuestions(){
		return service.getAllQuestions();
	
	}
	
	@PostMapping("/addQuestion")
	public List<Question> addQuestion(@RequestBody List<Question> questions) throws SequenceException{
		for(Question q: questions) {
		long sequenceid = sequenceDao.getNextSequenceId("questions");
		System.out.println("*********" + sequenceid + "********");
		q.setId(sequenceid);
		}
		return service.addQuestions(questions);
	}
	
	@GetMapping("/getList")
	public Set<String> getCollections(){
		return service.getCollection();
	}
	
	@GetMapping("/getLists")
	public List<String> getCollectionsa(){
		return service.getCollections();
	}
	
/*------------------------------------------------------------------------------*/
	
	@GetMapping("/allJava")
	public List<Java> getAllJava(){
		return service.getAllJava();
	}
	
	@PostMapping("/addJava")
	public List<Java> addJava(@RequestBody List<Java> java) throws SequenceException{
		for(Java j: java) {
			long sequenceid = sequenceDao.getNextSequenceId("java");
			System.out.println("*********" + sequenceid + "********");
			j.setId(sequenceid);
		}
		return service.addJava(java);
	}
	
	@GetMapping("/java/{id}")
	public Java getById(@PathVariable long id){
		return service.getById(id);
	}
	
	@PutMapping("/update")
	public Java updateQuestion(@RequestBody Java java) {
		return service.updateQuestion(java);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteJavaQuestion(@PathVariable long id) {
		return service.deleteJavaQuestion(id);
	}
	
/*------------------------------------------------------------------------------*/
	
	@GetMapping("/allMongo")
	public List<MongoDb> getAllMongo(){
		return service.getAllMongo();
	}
	
	@PostMapping("/addMongo")
	public List<MongoDb> addMongoDb(@RequestBody List<MongoDb> mongo) throws SequenceException{
		for(MongoDb m: mongo) {
			long sequenceid = sequenceDao.getNextSequenceId("mongo");
			System.out.println("*********" + sequenceid + "********");
			m.setId(sequenceid);
	}
		return service.addMongoDb(mongo);
	}
	
	@DeleteMapping("/deleteMongo/{id}")
	public String deleteMongo(@PathVariable long id){
		return service.deleteMongo(id);
	}
	
/*------------------------------------------------------------------------------*/
	@GetMapping("/allHtml")
	public List<Html> getAllHtml(){
		return service.getAllHtml();
	}
	
	@PostMapping("/addHtml")
	public List<Html> addHtml(@RequestBody List<Html> html) throws SequenceException{
		for(Html h: html) {
			long sequenceid = sequenceDao.getNextSequenceId("questions");
			System.out.println("*********" + sequenceid + "********");
			h.setId(sequenceid);
		}
		return service.addHtml(html);
	}
	
	@DeleteMapping("/deleteHtml/{id}")
	public String deleteHtml(@PathVariable long id) {
		return service.deleteHtml(id);
	}

/*------------------------------------------------------------------------------*/
	
	@GetMapping("/allJavaBasic")
	public List<JavaBasic> getAllJavaBasic(){
		return service.getAllJavaBasic();
	}
	
	@PostMapping("/addJavaBasic")
	public List<JavaBasic> addJavaBasic(@RequestBody List<JavaBasic> java) throws SequenceException{
		for(JavaBasic j: java) {
			long sequenceid = sequenceDao.getNextSequenceId("JavaBasic");
			System.out.println("*********" + sequenceid + "********");
			j.setId(sequenceid);
		}
		return service.addJavaBasic(java);
	}
	
	@GetMapping("/javaBasic/{id}")
	public JavaBasic getByIdBasic(@PathVariable long id){
		return service.getByIdBasic(id);
	}
	
	@PutMapping("/updateBasic")
	public JavaBasic updateQuestionBasic(@RequestBody JavaBasic java) {
		return service.updateQuestionBasic(java);
	}
	
	@DeleteMapping("/deleteBasic/{id}")
	public String deleteJavaBasicQuestion(@PathVariable long id) {
		return service.deleteJavaBasicQuestion(id);
	}
	
/*------------------------------------------------------------------------------*/
	
	@GetMapping("/allJavaIntermediate")
	public List<JavaIntermediate> getAllJavaIntermediate(){
		return service.getAllJavaIntermediate();
	}
	
	@PostMapping("/addJavaIntermediate")
	public List<JavaIntermediate> addJavaIntermediate(@RequestBody List<JavaIntermediate> java) throws SequenceException{
		for(JavaIntermediate ji: java) {
			long sequenceid = sequenceDao.getNextSequenceId("JavaIntermediate");
			System.out.println("*********" + sequenceid + "********");
			ji.setId(sequenceid);
		}
		return service.addJavaIntermediate(java);
	}
	
	@GetMapping("/javaIntermediate/{id}")
	public JavaIntermediate getByIdIntermediate(@PathVariable long id){
		return service.getByIdIntermediate(id);
	}
	
	@PutMapping("/updateIntermediate")
	public JavaIntermediate updateQuestionIntermediate(@RequestBody JavaIntermediate java) {
		return service.updateQuestionIntermediate(java);
	}
	
	@DeleteMapping("/deleteIntermediate/{id}")
	public String deleteJavaIntermediateQuestion(@PathVariable long id) {
		return service.deleteJavaIntermediateQuestion(id);
	}

/*------------------------------------------------------------------------------*/
	
	@GetMapping("/allJavaAdvance")
	public List<JavaAdvance> getAllJavaAdvance(){
		return service.getAllJavaAdvance();
	}
	
	@PostMapping("/addJavaAdvance")
	public List<JavaAdvance> addJavaAdvance(@RequestBody List<JavaAdvance> java) throws SequenceException{
		for(JavaAdvance ja: java) {
			long sequenceid = sequenceDao.getNextSequenceId("JavaAdvance");
			System.out.println("*********" + sequenceid + "********");
			ja.setId(sequenceid);
		}
		return service.addJavaAdvance(java);
	}
	
	@GetMapping("/javaAdvance/{id}")
	public JavaAdvance getByIdAdvance(@PathVariable long id){
		return service.getByIdAdvance(id);
	}
	
	@PutMapping("/updateAdvance")
	public JavaAdvance updateQuestionAdvance(@RequestBody JavaAdvance java) {
		return service.updateQuestionAdvance(java);
	}
	
	@DeleteMapping("/deleteAdvance/{id}")
	public String deleteJavaAdvanceQuestion(@PathVariable long id) {
		return service.deleteJavaAdvanceQuestion(id);
	}

}
