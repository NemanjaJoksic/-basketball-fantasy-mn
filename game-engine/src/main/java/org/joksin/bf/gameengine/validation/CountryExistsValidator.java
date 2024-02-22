package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.CountryRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;
import org.joksin.bf.gameengine.validation.util.ObjectParamValidator;

@Singleton
@AllArgsConstructor
public class CountryExistsValidator extends ObjectParamValidator<CountryExists, Long> {

  private final CountryRepository countryRepository;

  @Override
  protected boolean isValidInternal(Long id, ConstraintValidatorContext context) {
    if (!countryRepository.existsById(id)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Country with ID %s does not exist", id));

      return false;
    }

    return true;
  }
}
