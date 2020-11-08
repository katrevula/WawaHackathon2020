package com.emobileconnect.emobileconnect.service.impl;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emobileconnect.emobileconnect.dao.RequestRepository;
import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;
import com.emobileconnect.emobileconnect.dto.Status;
import com.emobileconnect.emobileconnect.model.Request;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestRepository requestRepository;

	@Override
	public ResponseDTO createRequest(@Valid RequestDTO requestDto, @Valid @NotNull @NotBlank MultipartFile file)
			throws IOException {
		Request request = new Request();
		BeanUtils.copyProperties(requestDto, request);
		request.setDocument(file.getBytes());
		request.setStatus(Status.IN_PROGRESS.toString());
		Request requestSaved = requestRepository.save(request);
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setRequestId(requestSaved.getRequestId());
		responseDto.setStatus(requestSaved.getStatus());

		return responseDto;
	}

}
