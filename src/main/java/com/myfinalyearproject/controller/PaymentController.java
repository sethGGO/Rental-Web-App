//package com.myfinalyearproject.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.myfinalyearproject.repository.BookingRepository;
//import com.myfinalyearproject.repository.ProductRepository;
//import com.myfinalyearproject.repository.UserRepository;
//import com.myfinalyearproject.validator.BookingValidator;
//import com.myfinalyearproject.validator.ProductValidator;
//import com.myfinalyearproject.validator.UserValidator;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import com.stripe.net.RequestOptions;
//
//@Controller
//public class PaymentController {
//
//	@Autowired ProductRepository productRepo;
//	@Autowired UserRepository userRepo;
//	@Autowired BookingRepository bookingRepo;
//	
//	@InitBinder("product")
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(new ProductValidator());
////        binder.addValidators(new UserValidator());
//    }
//	@InitBinder("user")
//    protected void initUserBinder(WebDataBinder binder) {
////        binder.addValidators(new ProductValidator());
//        binder.addValidators(new UserValidator());
//    }
//	@InitBinder("booking")
//    protected void initBookingBinder(WebDataBinder binder) {
////        binder.addValidators(new ProductValidator());
//        binder.addValidators(new BookingValidator());
//    }
//	
//	@RequestMapping("/pay")
//	public String pay(Model model) {
//		Stripe.apiKey = "sk_test_jBbyuMvm2Ws6ArjzJw96hdp9006KAu8y0T";
//		Map<String, Object> chargeMap = new HashMap<String, Object>();
//        chargeMap.put("amount", 100);
//        chargeMap.put("currency", "usd");
//        chargeMap.put("source", "tok_1234"); // obtained via Stripe.js
//
//        try {
//            Charge charge = Charge.create(chargeMap);
//            System.out.println(charge);
//        } catch (StripeException e) {
//            e.printStackTrace();
//        }
//		return "";
//	
//	}
//
//	
//}

