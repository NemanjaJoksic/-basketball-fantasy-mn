package org.joksin.bf.gameengine.database;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
class TeamRepositoryImpl implements TeamRepository {

  private final TeamJpaRepository teamJpaRepository;

  @Override
  public List<TeamEntity> findAll() {
    return teamJpaRepository.findAll();
  }

  @Override
  public Optional<TeamEntity> findById(long id) {
    return teamJpaRepository.findById(id);
  }

  @Override
  public boolean existsByName(String name) {
    return teamJpaRepository.existsByName(name);
  }
}
