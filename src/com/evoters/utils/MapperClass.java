package com.evoters.utils;

import com.evoters.data.model.Candidate;
import com.evoters.data.model.User;
import com.evoters.data.model.VoteForm;
import com.evoters.dtos.request.AddCandidateRequest;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.dtos.request.VoteFormRequest;
import com.evoters.dtos.response.CandidateResponse;
import com.evoters.dtos.response.LoginResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapperClass {

    public static User map(SignUpRequest signUpRequest){
        User user = new User();
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastName(signUpRequest.getLastName());
        user.setAddress(signUpRequest.getAddress());
        user.setEmailAddress(signUpRequest.getEmailAddress());
        user.setAge(signUpRequest.getAge());
        user.setPassword(signUpRequest.getPassword());
        return user;
    }
    public static void map(User user , LoginResponse response){
        response.setId(user.getId());
        response.setFullName(user.getFirstname() +" "+ user.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, HH:mm:ss");
        response.setDateRegistered(formatter.format(user.getDateRegistered()));
    }
    public static void map(VoteFormRequest formRequest, VoteForm form){
        form.setPartyName(formRequest.getPartyName());
        form.setUserId(formRequest.getUserId());

    }
    public static void map(AddCandidateRequest candidateRequest, Candidate candidate){
        candidate.setName(candidateRequest.getName());
        candidate.setPartyName(candidateRequest.getPartyName());
    }
    public static void map(Candidate candidate, CandidateResponse response){
        response.setId(candidate.getId());
        response.setName(candidate.getName());
        response.setPartyName(candidate.getPartyName());
    }
}

