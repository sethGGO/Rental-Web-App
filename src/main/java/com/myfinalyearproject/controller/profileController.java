package com.myfinalyearproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.repository.UserRepository;
import com.myfinalyearproject.validator.UserValidator;

@Controller
public class profileController {
	@Autowired UserRepository userRepo;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserValidator());
    }
	

	@RequestMapping("/profile")
	public String profile(Model model) {
		System.out.println("profile");
		User a = userRepo.findByemail(testController.user1.getEmail());
		model.addAttribute("user", a);
		System.out.println("bbbab");
		return "profile";
	}
	
	@RequestMapping(value="/editUser" ,params="Save" , method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user")User user, BindingResult result, Model model) {
		model.addAttribute("name", "World");
		User a = userRepo.findByemail(testController.user1.getEmail());
		if (result.hasErrors()) {
			System.out.println("no entered: ");
			return "profile";
		} else 
		{
			a.setfirstname(user.getfirstname());
			a.setlastname(user.getlastname());
			a.setbirthdate(user.getbirthdate());
			a.setphonenumber(user.getphonenumber());
			a.setemail(user.getemail());
			a.setpassword(user.getpassword());
			a.setpassword2(user.getpassword2());
			
			
			userRepo.save(a);
			testController.user1.setEmail(a.getemail());
			testController.user1.setPassword(a.getpassword());
			a = userRepo.findByemail(testController.user1.getEmail());
			model.addAttribute("user", a);
			System.out.println("changed: " + userRepo.findByid(a.getid()));
			// prepare view
			return "redirect:/profile";
		}
	}
}
