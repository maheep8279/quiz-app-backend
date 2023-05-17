package com.quizinfo.service;

import com.quizinfo.model.QuizInfo;

public interface QuizInfoService {
   public QuizInfo addQuiz(QuizInfo quizInfo);
   public QuizInfo getQuizInfo(String quiz);
   public QuizInfo updateQuizInfo(QuizInfo quizInfo);
}
