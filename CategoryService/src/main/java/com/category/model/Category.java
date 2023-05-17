package com.category.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category {
	@Id
	private long id;
	private String qName;
	private String level;
	private String noOfQuestions;
	private String questionsToBeSelected;
}
