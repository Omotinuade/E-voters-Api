package com.evoters.services;

import com.evoters.data.model.Candidate;
import com.evoters.dtos.request.AddCandidateRequest;
import com.evoters.dtos.response.CandidateResponse;

import java.util.List;

public interface CandidateService {
    CandidateResponse addCandidate(AddCandidateRequest candidateRequest);
    CandidateResponse findCandidateByPartyName(String partyName);
    List<CandidateResponse> findAll();
}
