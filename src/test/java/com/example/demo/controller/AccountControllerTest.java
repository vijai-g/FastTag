package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.AccountUser;
import com.example.demo.repository.AccountUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	AccountUserRepository aur;
	
	@MockBean
	AccountController accCont;

//	@SuppressWarnings("null")
//	@Test
	void testGetAllUsers() throws Exception {

		List<AccountUser> auList =new ArrayList<>();
		AccountUser au1 = new AccountUser();
		AccountUser au11 = new AccountUser();
		auList.add(au1);
		auList.add(au11);
		
		when(aur.findAll()).thenReturn(auList);
		mockMvc.perform(MockMvcRequestBuilders.get("/accounts/getAllAccountUser"))
		.andExpect(status().is2xxSuccessful())
		.andDo(print());

	}
	
//	@Test
	void testaddUserAccount() {
		
	}

//	@Test
	void testGetUserByLoc() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("accounts/findByLoc/").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		//.andExpect(jsonPath("$.message").value("ToDo has been deleted"))
		.andDo(print());
	}
	

	@Test
	public void testAddUserAccount() throws Exception {
	

		mockMvc.perform(MockMvcRequestBuilders.post("/accounts/addUser")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"accHolderName\" : \"vijai\", \"cif\" : 1l}")
       
		.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		//.andExpect(jsonPath("$.completed").exists())
		.andExpect(jsonPath("$.accHolderName").value("vijai"));
	//	.andExpect(jsonPath("$.cif").value(1));
		//.andExpect(jsonPath("$.data.accHolderName",is("vijai")))
	    //	.andExpect(jsonPath("$.completed").value(false))
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
