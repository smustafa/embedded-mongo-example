package com.example.mongodb.embedded.demo.controller;

import com.example.mongodb.embedded.demo.entity.User;
import com.example.mongodb.embedded.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/" , params = "id")
    public ResponseEntity<User> getUserById(Long id){
        return ResponseEntity.of(userService.getUserById(id));
    }


    @GetMapping(value = "/" , params = "firstName")
    public ResponseEntity<List<User>> getUsersByFirstName(String firstName){
        return ResponseEntity.ok(userService.getUserByFirstName(firstName));
    }
}
