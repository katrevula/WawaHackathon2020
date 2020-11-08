package com.emobileconnect.emobileconnect.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.service.impl.RequestService;

@RestController
@RequestMapping("/api/request")
public class RequestController {

	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<?> createRequest(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("planId") Integer planId,
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
		try {

			RequestDTO requestDto = new RequestDTO();
			requestDto.setName(name);
			requestDto.setEmail(email);
			requestDto.setMobile(mobile);
			requestDto.setPlanId(planId);
			return ResponseEntity.ok().body(requestService.createRequest(requestDto, file));

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
