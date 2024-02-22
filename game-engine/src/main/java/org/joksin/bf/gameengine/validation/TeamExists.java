package org.joksin.bf.gameengine.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TeamExistsValidator.class)
@Documented
public @interface TeamExists {

  String message() default "";

  Class[] groups() default {};

  Class[] payload() default {};
}
