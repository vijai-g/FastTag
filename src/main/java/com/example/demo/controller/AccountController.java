package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;
import com.example.demo.model.AccountUser;
import com.example.demo.repository.AccountUserRepository;

/**
 * AccountController
 * 
 * @author Vijai
 *
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	/**
	 * AccountUserRepository (JPA repository)
	 * 
	 */
	@Autowired
	AccountUserRepository auRepo;
	
	

	/**
	 * POST(/accounts/addUser) adds a new account user
	 * 
	 * @param au
	 * @return
	 */
	@PostMapping("/addUser")
	public AccountUser addUserAccount(@RequestBody AccountUser au) {

		return auRepo.save(au);
	}
	
	

	/**
	 * Get(/accounts/getAccountUser/{username}/{location}) gets a account user by
	 * name and location
	 * 
	 * @param username
	 * @param location
	 * @return
	 */
	@GetMapping("/getAccountUser/{username}/{location}")
	public AccountUser getUserByNameAndLoc(@PathVariable String username, @PathVariable String location) {
		return auRepo.findUserByNameAndLocation(username, location);
	}
	
	
	

	/**
	 * GET(accounts/getAllAccountUser)gets all users
	 * 
	 * @return
	 */
	@GetMapping("/getAllAccountUser")
	public List<AccountUser> getAllUsers() {
		return auRepo.findAll();
	}
	
	
	

	/**
	 * GET(accounts/findByLoc{location})gets all users by location
	 * 
	 * @param location
	 * @return
	 */
	@GetMapping("/findByLoc{location}")
	public List<AccountUser> getUserbyloc(@PathVariable String location) {
		return auRepo.findByLocation(location);
	}
	
	
	

	/**
	 * DELETE(accounts/remove/{cif}) Removes a user by cif number
	 * 
	 * @param cif
	 * @return
	 */
	@DeleteMapping("/remove/{cif}")
	public ResponseEntity<Void> removeUserAccount(@PathVariable int cif) {

		log.info("Deleting User with cif : {}", cif);

		try {
			auRepo.deleteByCif(cif);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
