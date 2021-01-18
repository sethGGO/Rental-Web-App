package com.myfinalyearproject.controller;

import java.util.List;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;
import com.myfinalyearproject.repository.BookingRepository;
import com.myfinalyearproject.repository.ProductRepository;
import com.myfinalyearproject.repository.UserRepository;
import com.myfinalyearproject.validator.BookingValidator;
import com.myfinalyearproject.validator.ProductValidator;
import com.myfinalyearproject.validator.UserValidator;

@Controller
public class BookingsController {
	@Autowired ProductRepository productRepo;
	@Autowired UserRepository userRepo;
	@Autowired BookingRepository bookingRepo;
	
	@InitBinder("product")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidator());
//        binder.addValidators(new UserValidator());
    }
	@InitBinder("user")
    protected void initUserBinder(WebDataBinder binder) {
//        binder.addValidators(new ProductValidator());
        binder.addValidators(new UserValidator());
    }
	@InitBinder("booking")
    protected void initBookingBinder(WebDataBinder binder) {
//        binder.addValidators(new ProductValidator());
        binder.addValidators(new BookingValidator());
    }
	int f=0;
	Booking h = new Booking();
	@RequestMapping("/bookings")
	public String bookings(Model model) {
		System.out.println("bookings");
		User a = userRepo.findByemail(testController.user1.getEmail());
		List<Product> b =(List<Product>) productRepo.findAll();
		List<Booking> c =(List<Booking>) bookingRepo.findAllByrenterid(a.getid());
		model.addAttribute("products", productRepo);
		model.addAttribute("user", a);
		model.addAttribute("bookings", c);
		h = bookingRepo.findByid(f);
		System.out.println(h);
		return "bookings";
	}
	@RequestMapping("/bookingInfo/{id}")
	public String bookingInfo(@PathVariable int id,Model model) {
		User a = userRepo.findByemail(testController.user1.getEmail());
		Booking c = bookingRepo.findByid(id);
		f=id;
//		Product b = productRepo.findByid(c.getProductid());
		Date date = new Date();
		long diff = c.getStartdate().getTime()-date.getTime();
		int days = (int) (diff / (1000*60*60*24)+1);
//		Booking c = bookingRepo.findByrenterid(id);
		long diff2 = c.getEnddate().getTime()- date.getTime();
		int days2 = (int) (diff2 / (1000*60*60*24)+1);
		model.addAttribute("products", productRepo);
		model.addAttribute("user", a);
		model.addAttribute("date", date);
		model.addAttribute("book", c);
		model.addAttribute("days", days);
		model.addAttribute("days2", days2);
		model.addAttribute("booking", new Booking());
//		System.out.println(c.toString());
		return "bookingInfo";
	}
	@RequestMapping("/deleteBooking")
	public String deleteBooking(Model model) {
		Booking c = bookingRepo.findByid(f);
		bookingRepo.delete(c);
		return "redirect:/bookings";
	}
	@RequestMapping(value="/editBooking" ,params="Save" , method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("booking")Booking booking, BindingResult result, Model model) {
		model.addAttribute("name", "World");
		User a = userRepo.findByemail(testController.user1.getEmail());
		Booking c = bookingRepo.findByid(f);
//		Lister lister= new Lister(userdet); 
		System.out.println("pre error");
		long diff = booking.getEnddate().getTime()- booking.getStartdate().getTime();
		System.out.println(diff);
		int days = (int) (diff / (1000*60*60*24));
		System.out.println(days);
		int totalCost = days*productRepo.findByid(booking.getProductid()).getPrice();
		booking.setCost(totalCost);
		
		
		if (result.hasErrors()) {
			System.out.println("no entered: ");
			return "booking";
		} else 
		{
			
			Booking y = bookingRepo.findByid(f);
//			bookingRepo.deleteById(f);
			y.setStartdate(booking.getStartdate());
			y.setEnddate(booking.getEnddate());
			y.setCost(booking.getCost());
			f=bookingRepo.save(y).getId();
			model.addAttribute("products", productRepo);
			model.addAttribute("user", a);
			model.addAttribute("book", bookingRepo.findByid(f));
			System.out.println("changed: " + bookingRepo.findByid(f));
			System.out.println(bookingRepo.findByid(f));
			// prepare view
			return "redirect:/bookingInfo/"+f;
		}
	}
}
