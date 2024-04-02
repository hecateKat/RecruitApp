package com.kat.recruitapp.validators.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OwaspEmailValidator.class)
@Documented
public @interface OwaspEmail {

    String message() default "Incorrect email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}