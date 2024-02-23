package org.joksin.bf.gameengine.database;

import org.joksin.bf.gameengine.database.entity.PlayerEntity;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

  List<PlayerEntity> findAll();

  Optional<PlayerEntity> findById(long id);

  PlayerEntity save(PlayerEntity playerEntity);
}
