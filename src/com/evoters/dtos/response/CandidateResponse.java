package com.evoters.dtos.response;

import lombok.Data;

@Data
public class CandidateResponse {
    private String id;
    private String name;
    private String partyName;
    private long voteCount;
}
