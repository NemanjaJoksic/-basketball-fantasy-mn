package org.joksin.bf.gameengine.validation.util;

import io.micronaut.core.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public abstract class StringParamValidator<A extends Annotation> implements ConstraintValidator<A, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (!StringUtils.hasText(value)) {
            ConstraintValidatorUtil.addConstraintViolation(context, "must not be blank");
            return false;
        }
        
        return isValidInternal(value, context);
    }

  protected abstract boolean isValidInternal(String value, ConstraintValidatorContext context);
}
