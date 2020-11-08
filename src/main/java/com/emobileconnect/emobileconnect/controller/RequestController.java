package com.emobileconnect.emobileconnect.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
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
import com.emobileconnect.emobileconnect.dto.Status;
import com.emobileconnect.emobileconnect.model.Request;
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

			Request request = new Request();
			request.setName(name);
			request.setEmail(email);
			request.setMobile(mobile);
			request.setPlanId(planId);
			request.setDocument(file.getBytes());
			request.setStatus(Status.IN_PROGRESS.toString());
			return ResponseEntity.ok().body(requestService.createRequest(request));

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
