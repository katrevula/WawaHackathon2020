package com.emobileconnect.emobileconnect.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.emobileconnect.emobileconnect.dao.RequestRepository;
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
		Request requestSaved = new Request();
		requestSaved.setName("Yogesh");
		requestSaved.setEmail("yogesh.tech12@gmail.com");
		requestSaved.setMobile("2016169346");
		requestSaved.setPlanId(1);
		requestSaved.setRequestId(1);
		requestSaved.setStatus("IN_PROGRESS");
		when(requestRepository.save(Mockito.any(Request.class))).thenReturn(requestSaved);
		ResponseDTO response = requestService.createRequest(requestSaved);
		assertEquals(1, response.getRequestId());
		assertEquals("IN_PROGRESS", response.getStatus());

	}

}
