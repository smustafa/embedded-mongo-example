package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirstMongoRepository extends MongoRepository<Entity, String> {
        
    
}
