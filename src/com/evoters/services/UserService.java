package com.evoters.services;

import com.evoters.data.model.User;
import com.evoters.data.model.VoteForm;
import com.evoters.dtos.request.LogInRequest;
import com.evoters.dtos.request.PasswordResetRequest;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.dtos.response.LoginResponse;

import java.util.HashMap;
import java.util.List;

public interface UserService {
//    HashMap<String, Integer> checkResult(LogInRequest logInRequest);
    User signUp(SignUpRequest signUpRequest);

    LoginResponse logIn (LogInRequest logInRequest);

    LoginResponse forgotPassword(PasswordResetRequest passwordResetRequest);

    LoginResponse findById(String id);
    Long count();
    LoginResponse findByEmailAddress(String emailAddress);
}
