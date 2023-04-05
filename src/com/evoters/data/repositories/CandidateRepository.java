package com.evoters.data.repositories;

import com.evoters.data.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
    Candidate findByName(String name);

    Candidate findByPartyName(String partyName);
}
