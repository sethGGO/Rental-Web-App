package com.myfinalyearproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;

public class ProductValidator implements Validator {
	public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }
	@Override
	public void validate(Object target, Errors errors) {

		System.out.println("validate");
		Product dto = (Product) target;
	}
}
