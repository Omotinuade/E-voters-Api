package com.evoters.dtos.request;

import lombok.Data;

@Data
public class AddCandidateRequest {
    private String name;
    private String partyName;
    private String userId;
}