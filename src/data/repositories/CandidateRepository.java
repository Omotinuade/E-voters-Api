package data.repositories;

import data.model.Candidate;

import java.util.List;

public interface CandidateRepository {
    Candidate save(Candidate candidate);
    Candidate findById(int id);
    long count();
    List<Candidate> findAll();
    void delete(Candidate candidate);
    void delete(int id);
    void deleteAll();
    Candidate findByUsername(String userName);
}
