package org.joksin.bf.gameengine.database;

import org.joksin.bf.gameengine.database.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {

  List<TeamEntity> findAll();

  Optional<TeamEntity> findById(long id);

  boolean existsByName(String name);
}
