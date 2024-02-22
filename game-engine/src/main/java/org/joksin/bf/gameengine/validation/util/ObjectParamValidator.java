package org.joksin.bf.gameengine.validation.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Objects;

public abstract class ObjectParamValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (Objects.isNull(value)) {
            ConstraintValidatorUtil.addConstraintViolation(context, "must not be empty");
            return false;
        }
        
        return isValidInternal(value, context);
    }

  protected abstract boolean isValidInternal(T value, ConstraintValidatorContext context);
}
