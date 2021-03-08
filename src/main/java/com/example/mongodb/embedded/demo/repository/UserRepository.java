package com.example.mongodb.embedded.demo.repository;

import com.example.mongodb.embedded.demo.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

    //Spring converts this to Regex	findByFirstnameRegex(String firstname)	{"firstname" : {"$regex" : firstname }}
    // automatically
    public List<User> findByFirstName(String firstName);

}