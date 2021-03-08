package com.example.mongodb.embedded.demo.controller;

import com.example.mongodb.embedded.demo.entity.User;
import com.example.mongodb.embedded.demo.repository.UserRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void setup(){

        userRepository.save(User.builder().id(1L).firstName("James").lastName("Bond").build());
        userRepository.save(User.builder().id(2L).firstName("James").lastName("Farley").build());
        userRepository.save(User.builder().id(3L).firstName("Marley").lastName("Hemp").build());
        userRepository.save(User.builder().id(4L).firstName("James").lastName("Bond").build());

    }

    @Test
    public void test_getById_successfull() throws Exception {
        mvc.perform(get("/").param("id", "1")).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"firstName\":\"James\",\"lastName\":\"Bond\"}"));        ;
        mvc.perform(get("/").param("id", "2")).andExpect(status().isOk()).andExpect(content().string("{\"id\":2,\"firstName\":\"James\",\"lastName\":\"Farley\"}"));        ;
        mvc.perform(get("/").param("id", "3")).andExpect(status().isOk()).andExpect(content().string("{\"id\":3,\"firstName\":\"Marley\",\"lastName\":\"Hemp\"}"));
        mvc.perform(get("/").param("id", "4")).andExpect(status().isOk()).andExpect(content().string("{\"id\":4,\"firstName\":\"James\",\"lastName\":\"Bond\"}"));        ;
    }

    @Test
    public void test_getByFirstName_successfull() throws Exception {

        mvc.perform(get("/").param("firstName", "James")).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"firstName\":\"James\",\"lastName\":\"Bond\"},{\"id\":2,\"firstName\":\"James\",\"lastName\":\"Farley\"},{\"id\":4,\"firstName\":\"James\",\"lastName\":\"Bond\"}]"));

        mvc.perform(get("/").param("firstName", "Marley")).andExpect(status().isOk()).andExpect(content().string("[{\"id\":3,\"firstName\":\"Marley\",\"lastName\":\"Hemp\"}]"));        ;
    }
}
