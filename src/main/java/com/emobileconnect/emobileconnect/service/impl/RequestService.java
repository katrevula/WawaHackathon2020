package com.emobileconnect.emobileconnect.service.impl;

import java.io.IOException;

import com.emobileconnect.emobileconnect.dto.RequestDTO;
import com.emobileconnect.emobileconnect.dto.ResponseDTO;

public interface RequestService {
	
public ResponseDTO createRequest(RequestDTO requestDto) throws IOException;
}
