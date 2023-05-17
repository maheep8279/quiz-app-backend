package com.quizinfo.service;

import com.quizinfo.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}