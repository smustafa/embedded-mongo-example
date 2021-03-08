package com.example.demo.repository;

import org.springframework.data.annotation.Id;

public class Entity {

    @Id
    public String id;

    public String name;
    
    public Entity() {}

    public Entity(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
       return "Entity with name " + name;
    }
}
