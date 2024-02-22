package org.joksin.bf.gameengine.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.usecase.FindPlayersUseCase;

import java.util.List;

@Controller
@AllArgsConstructor
@ExecuteOn(TaskExecutors.BLOCKING)
public class PlayerController {

  private final FindPlayersUseCase findPlayersUseCase;

  @Get("/api/players")
  public List<Player> findAll() {
    return findPlayersUseCase.findAll();
  }
}
