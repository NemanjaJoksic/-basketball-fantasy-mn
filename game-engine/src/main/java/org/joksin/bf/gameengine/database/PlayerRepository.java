package org.joksin.bf.gameengine.database;

import org.joksin.bf.gameengine.database.entity.PlayerEntity;

import java.util.List;

public interface PlayerRepository {

  List<PlayerEntity> findAll();
}
