package com.example.demo.validate;

import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidation.class)
public @interface PhoneNumber {
    String message() default"Phone Number is wrong format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
