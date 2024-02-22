package org.joksin.bf.gameengine.usecase;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.model.request.DeleteTeamRequest;

@Singleton
@AllArgsConstructor
class DeleteTeamUseCaseImpl implements DeleteTeamUseCase {

  private final TeamRepository teamRepository;

  @Override
  public void delete(DeleteTeamRequest deleteTeamRequest) {
    teamRepository.deleteById(deleteTeamRequest.id());
  }
}
