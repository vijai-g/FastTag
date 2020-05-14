package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FtContact;
import com.example.demo.repository.FtcRepository;
import com.example.demo.service.FtcService;

@RestController
@RequestMapping("/ftCon")
public class FastTagContactController {
	@Autowired
	FtcService ftcService;
	
	@Autowired
	FtcRepository ftcRepo;
	
	@GetMapping("/getAllStatus")
	List<FtContact> getAllStatus(){
		return ftcService.findAllStatus();
	}
	
	@GetMapping("/{id}")
	Optional<FtContact> getbyFT(@PathVariable int id) {
		return ftcRepo.findById(id);
	}
	
}
