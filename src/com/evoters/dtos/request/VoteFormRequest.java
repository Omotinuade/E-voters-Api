package com.evoters.dtos.request;

import com.evoters.data.model.Candidate;
import lombok.Data;

@Data
public class VoteFormRequest {
    private String partyName;
    private String userId;
}
