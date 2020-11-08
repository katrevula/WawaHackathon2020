package com.emobileconnect.emobileconnect.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.service.impl.RequestService;

@RestController
@RequestMapping("/api/request")
public class RequestController {

	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<?> multiUploadFileModel(@ModelAttribute RequestDTO requestDto) {
	    try {
	    	
	    	 return ResponseEntity.ok().body(requestService.createRequest(requestDto));
	        
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    
	}

}
