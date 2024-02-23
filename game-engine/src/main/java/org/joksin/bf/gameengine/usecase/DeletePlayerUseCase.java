package org.joksin.bf.gameengine.usecase;

import jakarta.validation.Valid;
import org.joksin.bf.gameengine.model.request.DeletePlayerRequest;

public interface DeletePlayerUseCase {

  void delete(@Valid DeletePlayerRequest deletePlayerRequest);
}
