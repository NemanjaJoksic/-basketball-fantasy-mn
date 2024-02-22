package org.joksin.bf.gameengine.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryExistsValidator.class)
@Documented
public @interface CountryExists {

  String message() default "";

  Class[] groups() default {};

  Class[] payload() default {};
}
