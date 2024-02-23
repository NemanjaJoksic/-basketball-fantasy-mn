package org.joksin.bf.gameengine.usecase;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.mapper.PlayerMapper;
import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.model.request.CreatePlayerRequest;
import org.joksin.bf.gameengine.model.request.CreateTeamRequest;

@Singleton
@AllArgsConstructor
class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  @Override
  public Player create(CreatePlayerRequest createPlayerRequest) {
    return Player.builder().build();
  }
}
