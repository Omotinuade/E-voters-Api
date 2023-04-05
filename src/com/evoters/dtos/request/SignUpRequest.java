package com.evoters.dtos.request;

import com.evoters.data.enums.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SignUpRequest {
    private String password;
    private  String firstname;
    private String lastName;
    private int age;
    private String address;
    private String emailAddress;

}
