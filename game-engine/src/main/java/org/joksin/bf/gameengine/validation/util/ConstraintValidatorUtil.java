package org.joksin.bf.gameengine.validation.util;

import jakarta.validation.ConstraintValidatorContext;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstraintValidatorUtil {

  public void addConstraintViolation(ConstraintValidatorContext context, String message) {
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
  }
}
