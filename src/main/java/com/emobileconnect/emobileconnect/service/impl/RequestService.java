package com.emobileconnect.emobileconnect.service.impl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;

public interface RequestService {
	
public ResponseDTO createRequest(RequestDTO requestDto,MultipartFile file) throws IOException;
}
