package com.evoters.services;

import com.evoters.data.model.Candidate;
import com.evoters.data.repositories.CandidateRepository;
import com.evoters.dtos.request.AddCandidateRequest;
import com.evoters.dtos.response.CandidateResponse;
import com.evoters.utils.MapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private UserService userService;

    @Override
    public CandidateResponse addCandidate(AddCandidateRequest candidateRequest) {
        userService.findById(candidateRequest.getUserId());
        Candidate candidate= new Candidate();
        CandidateResponse response= new CandidateResponse();
        MapperClass.map(candidateRequest, candidate);
        candidateRepository.save(candidate);
        MapperClass.map(candidate, response);
        return  response;
    }

    @Override
    public CandidateResponse findCandidateByPartyName(String partyName) {
        var foundCandidate= candidateRepository.findByPartyName(partyName);
        if(foundCandidate ==null) throw new IllegalArgumentException("Candidate Option doesn't exist");
        CandidateResponse response = new CandidateResponse();
        MapperClass.map(foundCandidate, response);
        return response;
    }
    public List<CandidateResponse> findAll(){
        var list = candidateRepository.findAll();
        if(list.isEmpty()) throw new NullPointerException("Candidate list is empty");
        CandidateResponse response = new CandidateResponse();
        List<CandidateResponse> responseList = new ArrayList<>();
        for(var c : list){
            MapperClass.map(c, response);
            responseList.add(response);
        }
        return responseList;
    }
}
