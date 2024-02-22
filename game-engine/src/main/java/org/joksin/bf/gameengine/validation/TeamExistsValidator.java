package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;
import org.joksin.bf.gameengine.validation.util.ObjectParamValidator;

@Singleton
@AllArgsConstructor
public class TeamExistsValidator extends ObjectParamValidator<TeamExists, Long> {

  private final TeamRepository teamRepository;

  @Override
  protected boolean isValidInternal(Long id, ConstraintValidatorContext context) {
    if (!teamRepository.existsById(id)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Team with ID %s does not exist", id));

      return false;
    }

    return true;
  }
}
