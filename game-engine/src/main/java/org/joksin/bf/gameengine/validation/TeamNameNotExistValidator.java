package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;

@Singleton
@AllArgsConstructor
public class TeamNameNotExistValidator
    implements ConstraintValidator<TeamNameNotExist, String> {

  private final TeamRepository teamRepository;

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    context.disableDefaultConstraintViolation();

    if (teamRepository.existsByName(name)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Team with name %s already exists", name));

      return false;
    }

    return true;
  }
}
