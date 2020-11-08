package com.emobileconnect.emobileconnect.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.emobileconnect.dao.RequestRepository;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;
import com.emobileconnect.emobileconnect.dto.Status;
import com.emobileconnect.emobileconnect.model.Request;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestRepository requestRepository;


	@Override
	public ResponseDTO createRequest(Request request) {
		Request requestSaved = requestRepository.save(request);
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setRequestId(requestSaved.getRequestId());
		responseDto.setStatus(requestSaved.getStatus());

		return responseDto;
	}

	@Override
	public ResponseDTO getRequestTracking(Request requesttrack) {
		Request request = new Request();
		BeanUtils.copyProperties(requesttrack, request);
		
		if(request.getDocument() != null && request.getMobile() != null && request.getPlanId() != null) {
			request.setStatus(Status.APPROVED.toString());
		}else if(request.getDocument() == null) {
			request.setStatus(Status.REJECTED.toString());		
		}
		Request requestSaved = requestRepository.save(request);
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setRequestId(requestSaved.getRequestId());
		responseDto.setStatus(responseDto.getStatus());
		if(request.getStatus().contains(Status.APPROVED.toString())) {
			request.setStatus(Status.CONNECTION_ENABLED.toString());
		}
		responseDto.setRequestId(requestSaved.getRequestId());
		responseDto.setStatus(responseDto.getStatus());
		return responseDto;
	}	
	
}
