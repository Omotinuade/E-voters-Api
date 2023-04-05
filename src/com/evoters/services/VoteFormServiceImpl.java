package com.evoters.services;

import com.evoters.data.model.Candidate;
import com.evoters.data.model.User;
import com.evoters.data.model.VoteForm;
import com.evoters.data.repositories.CandidateRepository;
import com.evoters.data.repositories.VoteFormRepository;
import com.evoters.dtos.request.LogInRequest;
import com.evoters.dtos.request.VoteFormRequest;
import com.evoters.dtos.response.CandidateResponse;
import com.evoters.utils.MapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VoteFormServiceImpl implements VoteFormService {
    @Autowired
    private VoteFormRepository voteFormRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CandidateService candidateService;

    @Override
    public VoteForm toVote(VoteFormRequest voteFormRequest) {
        validateUser(voteFormRequest.getUserId());
        validateUserHasVoted(voteFormRequest.getUserId());
        validateCandidate(voteFormRequest.getPartyName());
        VoteForm form = new VoteForm();
        MapperClass.map(voteFormRequest, form);
        return voteFormRepository.save(form);
    }

    private void validateCandidate(String partyName) {
        candidateService.findCandidateByPartyName(partyName);

    }

    private void validateUserHasVoted(String id) {
        var foundForm = voteFormRepository.findByUserId(id);
        if (foundForm != null) throw new IllegalArgumentException("You have already voted");
    }

    private void validateUser(String id) {

        userService.findById(id);
    }

    public List<VoteForm> findAll() {
        var list = voteFormRepository.findAll();
        if (list.isEmpty()) throw new NullPointerException("Vote Form List is currently empty");

        return list;
    }

    @Override
    public HashMap<String, Integer> checkResult(String id) {
        validateUser(id);
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        var formList = voteFormRepository.findAll();
        for (var form : formList) {
            if (result.containsKey(form.getPartyName())) {
                result.put(form.getPartyName(), result.get(form.getPartyName()) + 1);
            } else {
                result.put(form.getPartyName(), 1);
            }
        }

        return result;
    }
//    public List<CandidateResponse> checkResult2(String id){
//        validateUser(id);
//        var list = voteFormRepository.findAll();
//        for(var i: list){
//           var found = candidateService.findCandidateByPartyName(i.getPartyName());
//           found.setVoteCount(found.getVoteCount()+1);
//        }
//        return candidateService.findAll();
//    }
}
