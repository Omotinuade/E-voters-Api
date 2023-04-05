package com.evoters.data.repositories;

import com.evoters.data.model.VoteForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteFormRepository extends MongoRepository<VoteForm, String> {
    VoteForm findByUserId(String userId);
}
