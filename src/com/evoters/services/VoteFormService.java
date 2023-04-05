package com.evoters.services;

import com.evoters.data.model.VoteForm;
import com.evoters.dtos.request.LogInRequest;
import com.evoters.dtos.request.VoteFormRequest;
import com.evoters.dtos.response.CandidateResponse;

import java.util.HashMap;
import java.util.List;

public interface VoteFormService {
    VoteForm toVote(VoteFormRequest voteForm);
    List<VoteForm> findAll();
    HashMap<String, Integer> checkResult(String Id);
//    public List<CandidateResponse> checkResult2(String id);
}
