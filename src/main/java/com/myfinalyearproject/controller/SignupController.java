package com.myfinalyearproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.repository.UserRepository;
import com.myfinalyearproject.validator.ProductValidator;
import com.myfinalyearproject.validator.UserValidator;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;


@Controller
@RequestMapping(value = {"/signup"})
public class SignupController {
	@Autowired 
	UserRepository userRepo;
	
	
	@InitBinder("user")
    protected void initUserBinder(WebDataBinder binder) {
//        binder.addValidators(new ProductValidator());
        binder.addValidators(new UserValidator());
    }
	
	@RequestMapping("/")
    public String signup(Model model) {
    		model.addAttribute("user", new User());
    		return "signup";
    }
	
	@RequestMapping(value="/add" ,params="cancel")
	public String cancel(Model model) {
		model.addAttribute("name", "World");
		return "redirect:/";
		
	}
	@RequestMapping(value ="/ajax/{email}")
	public void ajax(@PathVariable String email,HttpServletResponse res) throws IOException{
    	String response = "itExists";
    	PrintWriter out = res.getWriter();
    	res.setContentType("text/html");
    	if(userRepo.findByemail(email)!=null) {
    		response="No";
    	}
    	out.println(response);
    	out.close();
	}
	@RequestMapping(value ="/ajaxphone/{phonenumber}")
	public void ajaxphone(@PathVariable String phonenumber,HttpServletResponse res) throws IOException{
    	String response = "itExists";
    	PrintWriter out = res.getWriter();
    	res.setContentType("text/html");
    	if(userRepo.findByphonenumber(phonenumber)!=null) {
    		response="No";
    	}
    	out.println(response);
    	out.close();
	}
	@RequestMapping(value="/add" ,params="add" , method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user")User user, BindingResult result, Model model) throws IOException {
		model.addAttribute("name", "World");
		user.setPhoto(user.getFile());
		System.out.println(user.getFile());
		
		if (result.hasErrors()) {
			System.out.println("no entered: ");
			return "test";
		} else 
		{
			model.addAttribute("user", new User());
			System.out.println("number: "+user.getFile());
			System.out.println("name: "+user.getfirstname());
			// encrypt password
//			BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
//			user.setpassword(pe.encode(user.getpassword()));
//			user.setpassword(user.getpassword());
			
			Stripe.apiKey = "sk_test_jBbyuMvm2Ws6ArjzJw96hdp9006KAu8y0T";
			Map<String, Object> customerParameter = new HashMap<String, Object>();
			customerParameter.put("email", user.getemail());
			Customer newCustomer;
			try {
				 newCustomer = Customer.create(customerParameter);
					user.setPaymentId(newCustomer.getId());
			} catch (StripeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// save in repo
			userRepo.save(user);
			System.out.println("entered: " + user.toString());
			// prepare view
			return "redirect:/";
		}
	}
}
