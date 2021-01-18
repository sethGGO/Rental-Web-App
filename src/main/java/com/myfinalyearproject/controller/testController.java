package com.myfinalyearproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;
import com.myfinalyearproject.repository.ProductRepository;
import com.myfinalyearproject.repository.UserRepository;
import com.myfinalyearproject.validator.LoginValidator;
import com.myfinalyearproject.validator.UserValidator;




@Controller
//@SessionAttributes("User")
public class testController {

	
	@Autowired UserRepository userRepo;
	@Autowired ProductRepository productRepo;
	
	
//	
//	
	@Autowired
	private LoginValidator userLogin;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
//		binder.addValidators(new ProductValidator());
        binder.addValidators(new UserValidator());
    }
	@RequestMapping("/")
	public String hello1(Model model) {
		model.addAttribute("name", "World");
		System.out.println("bbbb");
		return "test";
	}
	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> a =(List<Product>) productRepo.findAll();
		Product b =productRepo.findByid(5);
		User x= userRepo.findByemail(user1.getEmail());
		model.addAttribute("products", a);
		model.addAttribute("user", x);
//		System.out.println(a.toString());

		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "World");
		System.out.println("bbbb");
		return "test";
	}
	
	@RequestMapping("/ajaxlogin/{email}")
	public void ajaxlogin(@PathVariable String email,HttpServletResponse res) throws IOException{
		String response = "itExists";
    	PrintWriter out = res.getWriter();
    	res.setContentType("text/html");
    	if(userRepo.findByemail(email)!=null) {
    		response="No";
    	}
    	out.println(response);
    	out.close();
	}
	
	public static UserInfoLogin user1;
	@RequestMapping("/authenticate")
	public String authenticate(@RequestParam("username") String username ,@RequestParam("password") String password ,Model model) {
		System.out.println("bbbb");
		UserInfoLogin user = new UserInfoLogin(username,password);
		user1=user;
		if(userLogin.verifyUser(user)) {
			List<Product> a =(List<Product>) productRepo.findAll();
			Product b =productRepo.findByid(5);
			User x= userRepo.findByemail(username);
			model.addAttribute("products", a);
			model.addAttribute("user", x);
			return "redirect:/home";
		}
		else return "redirect:/error";
	}
	

}
