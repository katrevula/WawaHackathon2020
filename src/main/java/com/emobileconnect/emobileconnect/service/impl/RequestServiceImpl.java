package com.emobileconnect.emobileconnect.service.impl;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.emobileconnect.dao.RequestRepository;
import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;
import com.emobileconnect.emobileconnect.dto.Status;
import com.emobileconnect.emobileconnect.model.Request;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public ResponseDTO createRequest(RequestDTO requestDto) throws IOException {
		Request request = new Request();
		BeanUtils.copyProperties(requestDto, request);
		request.setDocument(requestDto.getFile().getBytes());
		request.setStatus(Status.IN_PROGRESS.toString());
		Request requestSaved = requestRepository.save(request);
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setRequestId(requestSaved.getRequestId());
		responseDto.setStatus(responseDto.getStatus());
		
		return responseDto;
	}

}
