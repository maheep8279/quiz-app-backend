package com.quizinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizInfo {
	private long id;
	private String quizName;
	private String noOfAttempts;
	private String duration;
}
