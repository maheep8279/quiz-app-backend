package com.quizinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizinfo.exception.SequenceException;
import com.quizinfo.model.QuizInfo;
import com.quizinfo.service.QuizInfoService;
import com.quizinfo.service.SequenceDao;

@CrossOrigin("*")
@RequestMapping("/quizinfo")
@RestController()
public class QuizInfoController {
  
	@Autowired
	private QuizInfoService service;
	
	@Autowired
	private SequenceDao sequenceDao;
	
	@PostMapping("/addQuizInfo")
	public QuizInfo addQuizInfo(@RequestBody QuizInfo quizInfo) throws SequenceException {
		long sequenceid = sequenceDao.getNextSequenceId("quizinfo");
		System.out.println("*********" + sequenceid + "********");
		quizInfo.setId(sequenceid);
		return service.addQuiz(quizInfo);
	}
	
	@GetMapping("/{quiz}")
	public QuizInfo getQuizInfo(@PathVariable("quiz") String quiz) {
		return service.getQuizInfo(quiz);
	}
	
	@PutMapping("/updateQuizInfo")
	public QuizInfo updateQuizInfo(@RequestBody QuizInfo quizInfo) {
		return service.updateQuizInfo(quizInfo);
	}
}
