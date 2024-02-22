package org.joksin.bf.gameengine.usecase;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.mapper.PlayerMapper;
import org.joksin.bf.gameengine.model.Player;

import java.util.List;

@Singleton
@AllArgsConstructor
class FindPlayersUseCaseImpl implements FindPlayersUseCase {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  @Override
  public List<Player> findAll() {
    var playerEntities = playerRepository.findAll();
    return playerMapper.fromEntities(playerEntities);
  }
}
