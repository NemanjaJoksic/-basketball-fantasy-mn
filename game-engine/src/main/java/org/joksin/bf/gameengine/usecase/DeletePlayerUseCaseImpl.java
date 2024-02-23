package org.joksin.bf.gameengine.usecase;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.model.request.DeletePlayerRequest;

@Singleton
@AllArgsConstructor
public class DeletePlayerUseCaseImpl implements DeletePlayerUseCase {

  private final PlayerRepository playerRepository;

  @Override
  public void delete(DeletePlayerRequest deletePlayerRequest) {}
}
