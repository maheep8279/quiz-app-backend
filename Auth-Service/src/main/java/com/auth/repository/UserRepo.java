package com.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.stereotype.Repository;

import com.auth.entity.User;
@Repository
public interface UserRepo  extends MongoRepository<User, Long>
{
	Optional<User> findByEmail(String email);
     
}
