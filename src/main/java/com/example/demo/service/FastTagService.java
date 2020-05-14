package com.example.demo.service;

import com.example.demo.model.FastTagPayment;
import com.example.demo.model.FastTagStatus;


public interface FastTagService {
	
	FastTagStatus FtStatus();

	void createNewFT(FastTagPayment ftp);
	
	
	
	

}
