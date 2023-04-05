package com.evoters.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoginResponse {
    private String id;
    private  String fullName;
    private String dateRegistered;

}
