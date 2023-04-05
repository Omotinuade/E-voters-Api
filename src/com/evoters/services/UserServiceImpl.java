package com.evoters.services;

import com.evoters.data.model.User;
import com.evoters.data.model.VoteForm;
import com.evoters.data.repositories.UserRepository;
import com.evoters.dtos.request.LogInRequest;
import com.evoters.dtos.request.PasswordResetRequest;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.dtos.response.LoginResponse;
import com.evoters.utils.AgeCalculatorClass;
import com.evoters.utils.MapperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



//    @Override
//    public HashMap<String, Integer> checkResult(LogInRequest request) {
//        userExist(request.getEmailAddress());
//        HashMap<String, Integer> result = new HashMap<String, Integer>();
//        var formList = voteFormService.findAll();
//        for(var form: formList){
//            if (result.containsKey(form.getCandidateName())) {
//                result.put(form.getCandidateName(), result.get(form.getCandidateName())+1);
//            } else {
//                result.put(form.getCandidateName(),1);
//            }
//        }

//        return result;
//    }

    @Override
    public User signUp(SignUpRequest signUpRequest) {
        boolean validateAge = (signUpRequest.getAge() < 18);
        if(validateAge) throw new IllegalArgumentException("This service is only available for citizens aged 18 and above!");
        if(userExist(signUpRequest.getEmailAddress())) throw new IllegalArgumentException("User Already Exist");

        return userRepository.save(MapperClass.map(signUpRequest));
    }
    @Override
    public LoginResponse logIn(LogInRequest logInRequest) {
        var foundUser = userRepository.findByEmailAddress(logInRequest.getEmailAddress());
        if(foundUser == null) throw new IllegalArgumentException("User not found, please sign up for this service");
        if(!(foundUser.getPassword().equals(logInRequest.getPassword()))) throw new IllegalArgumentException("Incorrect password!");

        return getLoginResponse(foundUser);
    }

    @Override
    public LoginResponse forgotPassword(PasswordResetRequest passwordResetRequest ) {
        if(userRepository.findByEmailAddress(passwordResetRequest.getEmailAddress()) == null) throw new IllegalArgumentException("No User found, kindly sign up");
        if(!(passwordResetRequest.getNewPassword().equals(passwordResetRequest.getConfirmNewPassword())))throw new IllegalArgumentException(String.format("%s and %s don't match", passwordResetRequest.getNewPassword() , passwordResetRequest.getConfirmNewPassword() ));
        LoginResponse response = new LoginResponse();
        var foundUser = userRepository.findByEmailAddress(passwordResetRequest.getEmailAddress());
        foundUser.setPassword(passwordResetRequest.getConfirmNewPassword());
        MapperClass.map(foundUser, response);

        return response;
    }

    @Override
    public LoginResponse findById(String id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty() ) throw new NullPointerException("User does not exist, Kindly register");
        LoginResponse response = new LoginResponse();
        MapperClass.map(foundUser.get(), response);
        return response;
    }

    @Override
    public Long count() {
       var count= userRepository.count();
       if(count == 0) throw new NullPointerException("No User found");
       return count;
    }

    @Override
    public LoginResponse findByEmailAddress(String emailAddress) {
        var foundUser = userRepository.findByEmailAddress(emailAddress);
        if (foundUser == null ) throw new NullPointerException("User does not exist, Kindly register");
        LoginResponse response = new LoginResponse();
        MapperClass.map(foundUser, response);
        return response;
    }

    private LoginResponse getLoginResponse(User user) {
        LoginResponse loginResponse = new LoginResponse();
        MapperClass.map(user, loginResponse);
        return loginResponse;
    }

    private boolean userExist(String emailAddress){
       User foundUser = userRepository.findByEmailAddress(emailAddress);
        return foundUser != null;
    }


}
