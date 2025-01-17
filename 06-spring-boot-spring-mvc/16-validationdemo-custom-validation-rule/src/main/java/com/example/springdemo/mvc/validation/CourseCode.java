package com.example.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // define dafault groups
    public Class<?> [] groups() default {};

    // define default payloads
    public Class<?> [] payload() default {};
}
