package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.repository.Entity;
import com.example.demo.repository.FirstMongoRepository;


@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class FirstControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FirstMongoRepository repository;


    @Test
    void test() throws Exception {
        
        Entity firstEntity = new Entity("Susan");
        
        System.out.println(repository.save(firstEntity));
        System.out.println(repository.count());

    }

}
