package com.result.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.result.exception.SequenceException;
import com.result.model.Result;
import com.result.service.ResultService;
import com.result.service.SequenceDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/results")
public class ResultController {

	@Autowired
	private ResultService service;
	
	@Autowired
	private SequenceDao sequenceDao;
	
	@GetMapping("/")
	public List<Result> showAllResults(){
		return service.getAllResults();
	}
	
	@PostMapping("/addResult")
	public Result addQuestion(@RequestBody Result result) throws SequenceException{
		long sequenceid = sequenceDao.getNextSequenceId("results");
		System.out.println("*********" + sequenceid + "********");
		result.setId(sequenceid);
		System.out.println("***************"+result+"***************");
		return service.addResult(result);
	}
	
	@GetMapping("/getResult/{name}/{qName}/{date}")
	public Result getResult(@PathVariable("name") String name, @PathVariable("qName") String qName, @PathVariable("date") String date) {
		return service.getResult(name, qName,LocalDate.parse(date));
	}
	
	@GetMapping("/getResult/{uname}/{quiz}")
	public ResponseEntity<List<Result>> getResultByName(@PathVariable("uname") String uname, @PathVariable("quiz") String quiz){
		List<Result> results = service.getResultByName(uname, quiz);
		if(results.isEmpty())
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
	@PutMapping("/updateResult")
	public Result updateResult(@RequestBody Result result) {
		return service.updateResult(result);
	}
}
