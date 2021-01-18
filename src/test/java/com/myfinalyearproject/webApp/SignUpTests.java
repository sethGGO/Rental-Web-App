package com.myfinalyearproject.webApp;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.myfinalyearproject.controller.BookingController;
import com.myfinalyearproject.controller.SignupController;
import com.myfinalyearproject.controller.testController;
import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;
import com.myfinalyearproject.repository.BookingRepository;
import com.myfinalyearproject.repository.ProductRepository;
import com.myfinalyearproject.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class SignUpTests {
	private MockMvc mockMvc;
	
	@Mock ProductRepository productRepo;
	@Mock UserRepository userRepo;
	@Mock BookingRepository bookingRepo;
	
	@InjectMocks
	private SignupController signupcontroller;
	
//	User a = userRepo.findByemail("sethodia1@gmail.com");
//	List<Booking> c =(List<Booking>) bookingRepo.findAllByrenterid(a.getid());
	
	@Before
	public void setup() throws Exception {
		mockMvc =MockMvcBuilders.standaloneSetup(signupcontroller).build();
		
	}
	
	@Test
	public void signup() throws Exception {
		mockMvc.perform(post("/signup/"))
		.andExpect(status().isOk())
		.andExpect(view().name("signup"));
	}
	@Test
	public void add() throws Exception {
		mockMvc.perform(post("/signup/add?cancel="))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/"));
	}

}
