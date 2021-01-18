package com.myfinalyearproject.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myfinalyearproject.Email;
import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.Lister;
import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;
import com.myfinalyearproject.domain.UserInfoLogin;
import com.myfinalyearproject.repository.BookingRepository;
import com.myfinalyearproject.repository.ProductRepository;
import com.myfinalyearproject.repository.UserRepository;
import com.myfinalyearproject.validator.ProductValidator;
import com.myfinalyearproject.validator.UserValidator;

@Controller
public class listController{
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		User x= userRepo.findByemail(testController.user1.getEmail());
		model.addAttribute("product", new Product());
		model.addAttribute("user", x);
		System.out.println("bbbb");
		return "list";
	}
	@RequestMapping(value = "/listings", method = RequestMethod.GET)
	public String listings(Model model) {
		User x= userRepo.findByemail(testController.user1.getEmail());
		List<Booking> c =(List<Booking>) bookingRepo.findAll();
		List<Product> z =(List<Product>) productRepo.findAllBylister(x.getemail());
		model.addAttribute("product", new Product());
		model.addAttribute("user", x);
		model.addAttribute("bookings", z);
		System.out.println("bbbb");
		return "listings";
	}
	
	@RequestMapping(value="/addList" ,params="Submit" , method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model) throws IOException {
		model.addAttribute("name", "World");
//		testController test = new testController();
		UserInfoLogin userq = testController.user1;
		User userdet = userRepo.findByemail(userq.getEmail());
//		Lister lister= new Lister(userdet); 
		product.setLister(userdet.getemail());
		product.setPhoto(product.getFile());
		System.out.println("qwe "+product.getFile());
//		System.out.println(product.getBase64());

		
		if (result.hasErrors()) {
			System.out.println("no entered: ");
			return "list";
		} else 
		{
			model.addAttribute("product", new Product());
			productRepo.save(product);
			return "list";
		}
	}
	int idd;
	@RequestMapping("/listBook/{id}")
	public String bookingInfo(@PathVariable int id,Model model) {
		idd=id;
		User a = userRepo.findByemail(testController.user1.getEmail());
		Product c = productRepo.findByid(id);
		List<Booking> b =(List<Booking>) bookingRepo.findAllByproductid(c.getId());
		model.addAttribute("user", a);
		model.addAttribute("product", c);
		model.addAttribute("bookings", b);
		model.addAttribute("userRepo", userRepo);
		return "listBook";
	}
	@RequestMapping("/deleteListing/{id}")
	public String deleteListing(@PathVariable int id,Model model) {
		User a = userRepo.findByemail(testController.user1.getEmail());
		Product c = productRepo.findByid(id);
		productRepo.delete(c);
		List<Booking> b =(List<Booking>) bookingRepo.findAllByproductid(c.getId());
		model.addAttribute("user", a);
		model.addAttribute("product", c);
		model.addAttribute("bookings", b);
		model.addAttribute("userRepo", userRepo);
		return "redirect:/listings";
	}
	Date date= new Date();
	@RequestMapping("/accept/{id}")
	public String accept(@PathVariable int id,Model model) throws AddressException, MessagingException, IOException {
		User a = userRepo.findByemail(testController.user1.getEmail());
		Product c = productRepo.findByid(idd);
		Booking f = bookingRepo.findByid(id);
		f.setAccepted(1);
		bookingRepo.save(f);
		Email.sendmail(userRepo.findByid(f.getRenterid()).getemail(), "Accepted Booking", "Your booking for"
				+ " "+productRepo.findByid(f.getProductid()).getName()+" has been accepted by the lister.");
//		List<Booking> b =(List<Booking>) bookingRepo.findAllByproductid(c.getId());
//		model.addAttribute("user", a);
//		model.addAttribute("product", c);
//		model.addAttribute("bookings", b);
//		model.addAttribute("userRepo", userRepo);
		return "redirect:/listBook/"+idd;
	}
	@RequestMapping("/decline/{id}")
	public String decline(@PathVariable int id,Model model) throws AddressException, MessagingException, IOException {
		User a = userRepo.findByemail(testController.user1.getEmail());
		Product c = productRepo.findByid(idd);
		Booking f = bookingRepo.findByid(id);
		f.setAccepted(0);
		bookingRepo.save(f);
		Email.sendmail(userRepo.findByid(f.getRenterid()).getemail(), "Declined Booking", "Your booking for"
				+ " "+productRepo.findByid(f.getProductid()).getName()+" has been declined by the lister.");
		return "redirect:/listBook/"+idd;
	}

}
