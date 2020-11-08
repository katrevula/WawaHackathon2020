package com.emobileconnect.emobileconnect.service.impl;

import java.io.IOException;

import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;
import com.emobileconnect.emobileconnect.model.Request;

public interface RequestService {
	
public ResponseDTO createRequest(RequestDTO requestDto) throws IOException;
public Request getRequestTracking(Request request) throws IOException;
}


