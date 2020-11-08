package com.emobileconnect.emobileconnect.controller;

import com.emobileconnect.emobileconnect.service.impl.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AssignControllerImp implements Assigncontroller {

    @Autowired
    AssignService assignService;

    @Override
    public ResponseEntity<String> getAllAssignMobile() {
        return null;
    }
}