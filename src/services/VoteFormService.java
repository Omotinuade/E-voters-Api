package services;

import data.model.Candidate;
import data.model.VoteForm;

public interface VoteFormService {
    VoteForm toVote(VoteForm voteForm);
}
