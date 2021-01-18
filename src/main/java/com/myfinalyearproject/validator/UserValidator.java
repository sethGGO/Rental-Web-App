package com.myfinalyearproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myfinalyearproject.domain.User;


public class UserValidator implements Validator {
	public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

	@Override
	public void validate(Object target, Errors errors) {

		System.out.println("validate");
		User dto = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Field cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "", "Field cannot be empty.");
		
		if ((dto.getpassword() != null) && (dto.getpassword2() != null) && (!dto.getpassword().equals(dto.getpassword2()))) {
			errors.rejectValue("password2", "", "Paswords do not match.");
		}
	}
}
