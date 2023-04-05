package com.evoters.dtos.request;

import lombok.Data;

@Data
public class LogInRequest {
    String emailAddress;
    String password;

}
