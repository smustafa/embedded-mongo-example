package com.example.mongodb.embedded.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

}
