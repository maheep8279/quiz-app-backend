package com.result.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.model.Result;
import com.result.repository.IResultRepository;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired 
	private IResultRepository resultRepo;

	@Override
	public List<Result> getAllResults() {
		return resultRepo.findAll();
	}

	@Override
	public Result addResult(Result result) {
		return resultRepo.insert(result);
	}

	@Override
	public Result getResult(String name, String quizName,LocalDate date) {
		return resultRepo.findByNameAndQuizNameAndDate(name,quizName,date).get();
	}

	@Override
	public List<Result> getResultByName(String name, String quizName) {
		return resultRepo.findAllByNameAndQuizName(name, quizName);
	}

	@Override
	public Result updateResult(Result result) {
		return resultRepo.save(result);
	}

}
