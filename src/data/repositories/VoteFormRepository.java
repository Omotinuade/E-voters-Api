package data.repositories;

import data.model.Candidate;
import data.model.VoteForm;

import java.util.List;

public interface VoteFormRepository {
    VoteForm save(VoteForm form);
    VoteForm findById(int id);
    long count();
    List<VoteForm> findAll();
    void delete(VoteForm voteForm);
    void deleteAll();
    VoteForm findByCandidate(Candidate candidate);
}
