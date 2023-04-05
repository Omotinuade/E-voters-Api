package com.evoters.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class VoteForm {
    @Id
    private String id;
    private String partyName;
    //private String candidateName;
    private String userId;

//    public HashMap<String, String> GetCandidates(){
//        var candidates = new HashMap<String , String>();
//        candidates.put("1", "Balablu");
//        candidates.put("2", "Peter Obi");
//
//        return candidates;
//    }
//
//    public void DisplayCandidates(){
//        System.out.printf("Candidates");
//        var candidates = GetCandidates();
//        for (var candidate: candidates.entrySet()) {
//            System.out.printf(candidate.getKey()+  "-"+candidate.getValue());
//
//
//        }
   // }

}
