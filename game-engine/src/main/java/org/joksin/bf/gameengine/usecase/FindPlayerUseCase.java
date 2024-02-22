package org.joksin.bf.gameengine.usecase;

import org.joksin.bf.gameengine.model.Player;

import java.util.Optional;

public interface FindPlayerUseCase {

  Optional<Player> findById(long id);
}
