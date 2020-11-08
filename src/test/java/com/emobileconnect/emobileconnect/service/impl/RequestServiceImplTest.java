package com.emobileconnect.emobileconnect.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.emobileconnect.emobileconnect.dao.RequestRepository;
import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;
import com.emobileconnect.emobileconnect.model.Request;

@ExtendWith(MockitoExtension.class)
class RequestServiceImplTest {

	@Mock
	private RequestRepository requestRepository;

	@InjectMocks
	private RequestServiceImpl requestService;

	@BeforeEach
	public void beforeFunction() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateRequest() {
		RequestDTO requestDto = new RequestDTO();
		requestDto.setName("Yogesh");
		requestDto.setEmail("yogesh.tech12@gmail.com");
		requestDto.setMobile("2016169346");
		requestDto.setPlanId(1);
		String fileName = "test.txt";
		MultipartFile mockMultipartFile = new MockMultipartFile("user-file",fileName,
	              "text/plain", "test data".getBytes());
		Request requestSaved = new Request();
		requestSaved.setRequestId(1);
		requestSaved.setStatus("IN_PROGRESS");
		when(requestRepository.save(Mockito.any(Request.class))).thenReturn(requestSaved);
		try {
			ResponseDTO response = requestService.createRequest(requestDto, mockMultipartFile);
			assertEquals(1, response.getRequestId());
			assertEquals("IN_PROGRESS", response.getStatus());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
