package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountUser;
import com.example.demo.model.FastTagPayment;
import com.example.demo.repository.FtRepo;
import com.example.demo.service.FastTagService;

@RestController
@RequestMapping("/fastTag")
public class FastTagController {
	@Autowired
	FastTagService ftService;
	@Autowired
	FtRepo ftRepo;

	@PostMapping("/addFt")
	ResponseEntity<FastTagPayment> addFastTag(@RequestBody FastTagPayment ftp ){
		ftService.createNewFT(ftp);
		
		//ftRepo.save(ftp);
		return new ResponseEntity<FastTagPayment>(ftp, HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/getAllFt")
	public List<FastTagPayment> getAllFt() {
		return ftRepo.findAll();
	}
	
	@GetMapping("/getExpDateJoin")
	public  List<Object[]>  getExpDateJoin() {
		return ftRepo.getJoinInfo();
	}

	@GetMapping("/getRgJoin")
	public  List<Object[]>  getExpDateRgJoin() {
		return ftRepo.getRightJoinInfo();
	}


}
