package com.evoters.data.model;


import com.evoters.data.enums.Role;
import com.evoters.data.enums.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastName;
    private int age;
    private String address;
    private String emailAddress;
    private String password;
    private LocalDateTime dateRegistered= LocalDateTime.now();


}
