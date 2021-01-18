package com.myfinalyearproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletResponse;
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

import com.myfinalyearproject.Email;
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

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.ExternalAccount;
import com.stripe.model.PaymentSource;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;

@Controller
public class BookingController {
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
	int productPrice = 0;
	int totalCost = 0;
	int idd=0;
	User userdet;
	
	
//	@RequestMapping("/booking")
//    public String booking( Model model){
////		model.addAttribute("product",productRepo.findByid(id));
//		model.addAttribute("user",userRepo.findByemail(testController.user1.getEmail()));
//        return "booking";
//    }
	
	@RequestMapping("/booking/{id}")
    public String booking(@PathVariable int id, Model model){
		model.addAttribute("booking", new Booking());
		model.addAttribute("bookings", bookingRepo.findAllByproductid(id));
		model.addAttribute("product",productRepo.findByid(id));
		model.addAttribute("userRepo", userRepo);
		productPrice =productRepo.findByid(id).getPrice();
		idd=id;
		model.addAttribute("user",userRepo.findByemail(testController.user1.getEmail()));
        return "booking";

    }
	@RequestMapping("/ajax/{startdatea}/{startdateb}/{startdatec}/{enddatea}/{enddateb}/{enddatec}")
    public void ajax(@PathVariable("startdatea") String startdatea,@PathVariable("startdateb") String startdateb,@PathVariable("startdatec") String startdatec,
    		@PathVariable("enddatea") String enddatea,@PathVariable("enddateb") String enddateb,@PathVariable("enddatec") String enddatec,
    		HttpServletResponse res)throws IOException, ParseException{
		Date startdate = new SimpleDateFormat("MM/dd/yyyy").parse(startdatea+"/"+startdateb+"/"+startdatec);
		Date enddate = new SimpleDateFormat("MM/dd/yyyy").parse(enddatea+"/"+enddateb+"/"+enddatec);
		String response = "itExists";
    	PrintWriter out = res.getWriter();
    	res.setContentType("text/html");
    	long sd = startdate.getTime();
    	long ed = enddate.getTime();
	System.out.println("startdate "+sd);
	System.out.println("enddate "+ed);
    List <Booking> bookings=(List<Booking>)bookingRepo.findAllByproductid(idd);
    for (Booking booking : bookings) {
     Date bstartdate = booking.getStartdate();
     long bsd = bstartdate.getTime();
     Date benddate = booking.getEnddate();
     long bed = benddate.getTime();
     
     System.out.println("bstartdate "+bsd);
		System.out.println("benddate "+bed);
    	if((bed>=sd && sd>=bsd)||(ed>=bsd && bed>=ed)) {
    		response="No";
    		System.out.println("works ");
    		break;
    	}
    }
    	out.println(response);
    	out.close();
	}
	Booking bb;
	
	@RequestMapping(value="/addBooking" ,params="Book" , method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("booking")Booking booking, BindingResult result, Model model) {
		model.addAttribute("name", "World");
//		List<Product> b =(List<Product>) productRepo.findAll();
//		int w=booking.getProductid();
//		productRepo.findByid(w).getName();
		
		
//		testController test = new testController();
		UserInfoLogin userq = testController.user1;
		userdet = userRepo.findByemail(userq.getEmail());
//		Lister lister= new Lister(userdet); 
		long diff = booking.getEnddate().getTime()- booking.getStartdate().getTime();
		System.out.println(diff);
		int days = (int) (diff / (1000*60*60*24));
		System.out.println(days);
		totalCost = days*productPrice;
		booking.setCost(totalCost);
		
		
		if (result.hasErrors()) {
			System.out.println("no entered: ");
			return "booking";
		} else 
		{
			model.addAttribute("product",productRepo.findByid(idd));
			model.addAttribute("user",userRepo.findByemail(testController.user1.getEmail()));
			model.addAttribute("booking", booking);
//			System.out.println("number: "+product);
//			System.out.println("name: "+user.getfirstname());
			// encrypt password
//			BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
//			user.setpassword(pe.encode(user.getpassword()));
//			user.setpassword(user.getpassword());
			
			// save in repo
			bb= booking;
//			bookingRepo.save(booking);
//			System.out.println("entered: " + booking.toString());
			// prepare view
			return "payment";
		}
	}
	@RequestMapping("/pay")
	public String pay(@RequestParam("stripeToken")String token,Model model) throws StripeException, NoSuchFieldException, SecurityException, AddressException, MessagingException, IOException {
		Stripe.apiKey = "sk_test_jBbyuMvm2Ws6ArjzJw96hdp9006KAu8y0T";
		
		Customer customer = Customer.retrieve(userdet.getPaymentId());
        Token tokens =Token.retrieve(token);
		Map<String, Object> chargeMap = new HashMap<String, Object>();

		if(customer.getDefaultSource() != null) {
		String card = customer.getDefaultSource();
		Card source = (Card) customer.getSources().retrieve(card);
		
        if(!source.getFingerprint().equals(tokens.getCard().getFingerprint())) {
		System.out.println("not exist");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", token);
		customer.getSources().create(params);
		chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", totalCost*100);
        chargeMap.put("currency", "gbp");
        chargeMap.put("source", tokens.getCard().getId());
        chargeMap.put("customer", userdet.getPaymentId());
        }
        if(source.getFingerprint().equals(tokens.getCard().getFingerprint())) {
        	System.out.println("exists");
        	chargeMap = new HashMap<String, Object>();
            chargeMap.put("amount", totalCost*100);
            chargeMap.put("currency", "gbp");
            chargeMap.put("customer", userdet.getPaymentId());
        }
		}
		else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("source", token);
			customer.getSources().create(params);
			chargeMap = new HashMap<String, Object>();
	        chargeMap.put("amount", totalCost*100);
	        chargeMap.put("currency", "gbp");
	        chargeMap.put("source", tokens.getCard().getId());
	        chargeMap.put("customer", userdet.getPaymentId());
		}
//		Map<String, Object> chargeMap = new HashMap<String, Object>();
//        chargeMap.put("amount", totalCost*100);
//        chargeMap.put("currency", "gbp");
//        chargeMap.put("source", tokens.getCard().getId());
//        chargeMap.put("customer", userdet.getPaymentId());// obtained via Stripe.js
        
        try {
        	bookingRepo.save(bb);
        	
        	Date date= new Date();
        	Email.sendmail(productRepo.findByid(bb.getProductid()).getLister(), 
        			"New Booking for your "+productRepo.findByid(bb.getProductid()).getName(),
        			userRepo.findByid(bb.getRenterid()).getfirstname()+" has  made a booking for your "
        			+productRepo.findByid(bb.getProductid()).getName()+" from "+bb.getStartdate().toString().replace(" 00:00:00 BST", "")
        			+" to "+ bb.getEnddate().toString().replace(" 00:00:00 BST", "")+". Log into your account to accept or decline this booking.");
        	
        	Date b4startdate = bb.getStartdate();
        	Calendar c = Calendar.getInstance(); 
        	c.setTime(b4startdate);
        	c.add(Calendar.DATE, -1);
        	b4startdate	= c.getTime();
        	System.out.println(b4startdate);
        	Timer timer = new Timer();
        	timer.schedule(new TimerTask() {
                @Override
                public void run() {try {
					Email.sendmail(userRepo.findByid(bb.getRenterid()).getemail(), 
						"Booking for "+productRepo.findByid(bb.getProductid()).getName(),
						"Your Booking for "+productRepo.findByid(bb.getProductid()).getName()+" starts in one day.");
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                }
            }
        	, b4startdate);
        	Date b4enddate = bb.getEnddate();
        	Calendar d = Calendar.getInstance(); 
        	d.setTime(b4enddate);
        	d.add(Calendar.DATE, -1);
        	b4enddate= d.getTime();
        	System.out.println(b4enddate);
        	Timer timer2 = new Timer();
        	timer2.schedule(new TimerTask() {
                @Override
                public void run() {try {
        	Email.sendmail(userRepo.findByid(bb.getRenterid()).getemail(), 
        			"Booking for "+productRepo.findByid(bb.getProductid()).getName(),
        			"Your Booking for "+productRepo.findByid(bb.getProductid()).getName()+" ends in one day.");
                } catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                }
            }
        	, b4enddate);
			System.out.println("entered: " + bb.toString());
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        List<Product> a =(List<Product>) productRepo.findAll();
		model.addAttribute("products", a);
		model.addAttribute("user",userdet);

		return "redirect:/home";
	
	}
}
