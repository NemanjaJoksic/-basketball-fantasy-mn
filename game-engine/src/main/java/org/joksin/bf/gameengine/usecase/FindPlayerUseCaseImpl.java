package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.mapper.PlayerMapper;
import org.joksin.bf.gameengine.model.Player;

import java.util.Optional;

@Singleton
@AllArgsConstructor
class FindPlayerUseCaseImpl implements FindPlayerUseCase {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  @Override
  @Transactional(readOnly = true)
  public Optional<Player> findById(long id) {
    return playerRepository.findById(id).map(playerMapper::fromEntity);
  }
}
