package com.evoters.controller;

import com.evoters.dtos.request.AddCandidateRequest;
import com.evoters.dtos.request.SignUpRequest;
import com.evoters.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @PostMapping("/addCandidate")
    public ResponseEntity<?> register(@RequestBody AddCandidateRequest request){
        try {
            return new ResponseEntity<>(candidateService.addCandidate(request), HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping("/findAllCandidates")
    public ResponseEntity<?> findById(){
        try {
            return new ResponseEntity<>(candidateService.findAll(), HttpStatus.CREATED);
        }catch (NullPointerException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
