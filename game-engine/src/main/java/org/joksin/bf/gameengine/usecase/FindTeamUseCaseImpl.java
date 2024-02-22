package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.mapper.TeamMapper;
import org.joksin.bf.gameengine.model.Team;

import java.util.Optional;

@Singleton
@AllArgsConstructor
class FindTeamUseCaseImpl implements FindTeamUseCase {

  private final TeamRepository teamRepository;

  private final TeamMapper teamMapper;

  @Override
  @Transactional(readOnly = true)
  public Optional<Team> findById(long id) {
    return teamRepository.findById(id).map(teamMapper::fromEntity);
  }
}
