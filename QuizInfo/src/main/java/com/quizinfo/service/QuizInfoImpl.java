package com.quizinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizinfo.model.QuizInfo;
import com.quizinfo.repository.IQuizInfoRepository;

@Service
public class QuizInfoImpl implements QuizInfoService{
	
	@Autowired
	private IQuizInfoRepository quizInfoRepo;

	@Override
	public QuizInfo addQuiz(QuizInfo quizInfo) {
		return quizInfoRepo.insert(quizInfo);
	}

	@Override
	public QuizInfo getQuizInfo(String quiz) {
		return quizInfoRepo.findByQuizName(quiz).get();
	}

	@Override
	public QuizInfo updateQuizInfo(QuizInfo quizInfo) {
		return quizInfoRepo.save(quizInfo);
	}

}
