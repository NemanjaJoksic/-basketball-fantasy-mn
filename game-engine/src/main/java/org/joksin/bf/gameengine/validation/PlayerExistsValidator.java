package org.joksin.bf.gameengine.validation;

import jakarta.inject.Singleton;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.validation.util.ConstraintValidatorUtil;
import org.joksin.bf.gameengine.validation.util.ObjectParamValidator;

@Singleton
@AllArgsConstructor
public class PlayerExistsValidator extends ObjectParamValidator<PlayerExists, Long> {

  private final PlayerRepository playerRepository;

  @Override
  protected boolean isValidInternal(Long id, ConstraintValidatorContext context) {
    if (!playerRepository.existsById(id)) {
      ConstraintValidatorUtil.addConstraintViolation(
          context, String.format("Player with ID %s does not exist", id));

      return false;
    }

    return true;
  }
}
