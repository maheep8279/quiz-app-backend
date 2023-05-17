package com.result.service;

import java.time.LocalDate;
import java.util.List;

import com.result.model.Result;

public interface ResultService {
  public List<Result> getAllResults();
  public Result addResult(Result result);
  public Result getResult(String name, String quizName,LocalDate date);
  public List<Result> getResultByName(String name, String quizName);
  public Result updateResult(Result result);
}
