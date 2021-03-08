package com.example.mongodb.embedded.demo.service;

import com.example.mongodb.embedded.demo.entity.User;
import com.example.mongodb.embedded.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getUserByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

}
