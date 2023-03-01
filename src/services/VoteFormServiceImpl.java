package services;

import data.model.Candidate;
import data.model.VoteForm;
import data.repositories.VoteFormRepository;
import data.repositories.VoteFormRepositoryImpl;

public class VoteFormServiceImpl implements VoteFormService{
    private VoteFormRepository voteFormRepository = new VoteFormRepositoryImpl();

    @Override
    public VoteForm toVote( VoteForm form) {

        return voteFormRepository.save(form);
    }
}
