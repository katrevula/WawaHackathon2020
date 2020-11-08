package com.emobileconnect.emobileconnect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@RequestMapping("/request")
public interface Assigncontroller {

    @GetMapping("/getAssignNumber")
    public ResponseEntity<String> getAllAssignMobile();

}
