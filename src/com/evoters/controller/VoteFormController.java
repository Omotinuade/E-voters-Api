package com.evoters.controller;

import com.evoters.data.model.VoteForm;
import com.evoters.data.repositories.VoteFormRepository;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.dtos.request.VoteFormRequest;
import com.evoters.services.UserService;
import com.evoters.services.VoteFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteFormController {
    @Autowired
    private VoteFormService voteFormService;

    @PostMapping("/vote")
    public ResponseEntity<?> vote(@RequestBody VoteFormRequest request){

        try {

            return new ResponseEntity<>(voteFormService.toVote(request), HttpStatus.CREATED);
        }catch (IllegalArgumentException | NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/checkResult/{id}")
    public ResponseEntity<?> checkResult(@PathVariable String id){

        try {

            return new ResponseEntity<>(voteFormService.checkResult(id), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
//    @GetMapping("/checkResult2/{id}")
//    public ResponseEntity<?> checkResult2(@PathVariable String id){
//
//        try {
//
//            return new ResponseEntity<>(voteFormService.checkResult2(id), HttpStatus.CREATED);
//        }catch (IllegalArgumentException ex){
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
}
