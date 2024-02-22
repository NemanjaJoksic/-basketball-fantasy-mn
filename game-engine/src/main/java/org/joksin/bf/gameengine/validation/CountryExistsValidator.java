package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.CountryRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;

@Singleton
@AllArgsConstructor
public class CountryExistsValidator implements ConstraintValidator<CountryExists, Long> {

  private final CountryRepository countryRepository;

  @Override
  public boolean isValid(Long id, ConstraintValidatorContext context) {
    context.disableDefaultConstraintViolation();

    if (!countryRepository.existsById(id)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Country with ID %s does not exist", id));

      return false;
    }

    return true;
  }
}
