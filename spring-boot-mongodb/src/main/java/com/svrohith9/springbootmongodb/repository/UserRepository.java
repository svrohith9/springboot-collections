package com.svrohith9.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.svrohith9.springbootmongodb.models.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, Integer> {

	@Query("{ 'State': ?0 }")
	public List<Users> findByState(String state);
}
