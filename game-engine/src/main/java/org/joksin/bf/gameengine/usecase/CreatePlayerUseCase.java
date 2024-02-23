package org.joksin.bf.gameengine.usecase;

import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.model.request.CreatePlayerRequest;

public interface CreatePlayerUseCase {

  Player create(CreatePlayerRequest createPlayerRequest);
}
