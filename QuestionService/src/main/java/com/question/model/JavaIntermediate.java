package com.question.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "JavaIntermediate")
public class JavaIntermediate {

	@Id
	private long id;
	private String qType;
	private String level;
	private String category;
	private String skill;
	private String subSkill;
	private String qText;
	private String correctAnswer;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

	public JavaIntermediate() {
		super();
	}

	public JavaIntermediate(long id, String qType, String level, String category, String skill, String subSkill,
			String qText, String correctAnswer, String option1, String option2, String option3, String option4) {
		super();
		this.id = id;
		this.qType = qType;
		this.level = level;
		this.category = category;
		this.skill = skill;
		this.subSkill = subSkill;
		this.qText = qText;
		this.correctAnswer = correctAnswer;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSubSkill() {
		return subSkill;
	}

	public void setSubSkill(String subSkill) {
		this.subSkill = subSkill;
	}

	public String getqText() {
		return qText;
	}

	public void setqText(String qText) {
		this.qText = qText;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	@Override
	public String toString() {
		return "JavaIntermediate [id=" + id + ", qType=" + qType + ", level=" + level + ", category=" + category
				+ ", skill=" + skill + ", subSkill=" + subSkill + ", qText=" + qText + ", correctAnswer="
				+ correctAnswer + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + "]";
	}

}
