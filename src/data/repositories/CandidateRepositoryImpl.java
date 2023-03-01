package data.repositories;

import data.model.Candidate;
import java.util.ArrayList;
import java.util.List;

public class CandidateRepositoryImpl implements CandidateRepository{
    private int count;
    private List<Candidate> candidates = new ArrayList<>();

    @Override
    public Candidate save(Candidate candidate) {
        boolean candidateHasNotBeenSaved = candidate.getId()== 0;
        if(candidateHasNotBeenSaved) saveNew(candidate);
        return candidate;
    }

    private void saveNew(Candidate candidate) {
        candidate.setId(count+1);
        candidates.add(candidate);
        count++;
    }

    @Override
    public Candidate findById(int id) {
        for(var candidate: candidates) if(candidate.getId() == id) return candidate;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Candidate> findAll() {
        return candidates;
    }

    @Override
    public void delete(Candidate candidate) {
        candidates.removeIf(eachCandidate -> eachCandidate == candidate);
        count--;
    }

    @Override
    public void delete(int id) {
        candidates.removeIf(eachCandidate -> eachCandidate.getId() == id);
        count--;
    }

    @Override
    public void deleteAll() {
        candidates.clear();
        count=0;
    }

    @Override
    public Candidate findByUsername(String partyName) {
        for(var eachCandidate:candidates) if(eachCandidate.getPartyName().equals(partyName)) return eachCandidate;

        return null;
    }
}
