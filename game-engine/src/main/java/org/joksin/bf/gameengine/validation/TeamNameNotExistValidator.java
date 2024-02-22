package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;
import org.joksin.bf.gameengine.validation.util.StringParamValidator;

@Singleton
@AllArgsConstructor
public class TeamNameNotExistValidator extends StringParamValidator<TeamNameNotExist> {

  private final TeamRepository teamRepository;

  @Override
  public boolean isValidInternal(String name, ConstraintValidatorContext context) {
    if (teamRepository.existsByName(name)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Team with name %s already exists", name));

      return false;
    }

    return true;
  }
}
