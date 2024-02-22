package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.model.Team;
import org.joksin.bf.gameengine.model.request.CreateTeamRequest;

@Singleton
@AllArgsConstructor
class CreateTeamUseCaseImpl implements CreateTeamUseCase {

  @Override
  @Transactional
  public Team create(CreateTeamRequest createTeamRequest) {
    return Team.builder().build();
  }
}
