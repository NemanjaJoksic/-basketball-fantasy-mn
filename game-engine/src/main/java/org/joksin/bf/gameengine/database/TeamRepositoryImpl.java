package org.joksin.bf.gameengine.database;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
class TeamRepositoryImpl implements TeamRepository {

  private final TeamJpaRepository teamJpaRepository;

  private final EntityManager entityManager;

  @Override
  public List<TeamEntity> findAll() {
    return teamJpaRepository.findAll();
  }

  @Override
  public Optional<TeamEntity> findById(long id) {
    return teamJpaRepository.findById(id);
  }

  @Override
  public TeamEntity findReferenceById(long id) {
    return entityManager.getReference(TeamEntity.class, id);
  }

  @Override
  public boolean existsById(long id) {
    return teamJpaRepository.existsById(id);
  }

  @Override
  public boolean existsByName(String name) {
    return teamJpaRepository.existsByName(name);
  }

  @Override
  public TeamEntity save(TeamEntity teamEntity) {
    return teamJpaRepository.save(teamEntity);
  }

  @Override
  public void deleteById(long id) {
    teamJpaRepository.deleteById(id);
  }
}
