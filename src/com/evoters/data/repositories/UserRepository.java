package com.evoters.data.repositories;

import com.evoters.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmailAddress(String emailAddress);
}
