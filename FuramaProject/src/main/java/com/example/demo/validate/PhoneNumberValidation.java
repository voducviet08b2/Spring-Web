package com.example.demo.validate;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber,String> {


    @Override
    public void initialize(PhoneNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length()>11){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Length form less 11 and must be number").addConstraintViolation();
            return false;
        }
        if(Pattern.matches("[a-z]*",value)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Must be number").addConstraintViolation();
            return false;
        }
        return true;
    }
}
