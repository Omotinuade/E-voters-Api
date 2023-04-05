package com.evoters.controller;

import com.evoters.dtos.request.LogInRequest;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/signUp")
    public ResponseEntity<?> register(@RequestBody SignUpRequest request){

        try {

            return new ResponseEntity<>(userService.signUp(request), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @PostMapping("/user/login")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest request){

        try {

            return new ResponseEntity<>(userService.logIn(request), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){

        try {

            return new ResponseEntity<>(userService.findById(id), HttpStatus.CREATED);
        }catch (NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/user/{emailAddress}")
    public ResponseEntity<?> findByEmailAddress(@PathVariable String emailAddress){

        try {

            return new ResponseEntity<>(userService.findByEmailAddress(emailAddress), HttpStatus.CREATED);
        }catch (NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/user/count")
    public ResponseEntity<?> totalCount(){
        try {
            return new ResponseEntity<>(userService.count(), HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
