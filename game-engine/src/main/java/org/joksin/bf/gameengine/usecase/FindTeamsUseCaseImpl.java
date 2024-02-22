package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.mapper.TeamMapper;
import org.joksin.bf.gameengine.model.Team;

import java.util.List;

@Singleton
@AllArgsConstructor
public class FindTeamsUseCaseImpl implements FindTeamsUseCase {

  private final TeamRepository teamRepository;

  private final TeamMapper teamMapper;

  @Override
  @Transactional(readOnly = true)
  public List<Team> findAll() {
    var teamEntities = teamRepository.findAll();
    return teamMapper.fromEntities(teamEntities);
  }
}
