package com.myfinalyearproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myfinalyearproject.domain.Booking;

public class BookingValidator implements Validator {
	public boolean supports(Class<?> clazz) {
        return Booking.class.equals(clazz);
    }
	@Override
	public void validate(Object target, Errors errors) {

		System.out.println("validate");
		Booking dto = (Booking) target;
	}
}
