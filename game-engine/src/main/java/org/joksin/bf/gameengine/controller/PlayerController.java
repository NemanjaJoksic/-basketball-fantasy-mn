package org.joksin.bf.gameengine.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.model.request.CreatePlayerRequest;
import org.joksin.bf.gameengine.usecase.CreatePlayerUseCase;
import org.joksin.bf.gameengine.usecase.FindPlayerUseCase;
import org.joksin.bf.gameengine.usecase.FindPlayersUseCase;

import java.util.List;

@Controller
@AllArgsConstructor
@ExecuteOn(TaskExecutors.BLOCKING)
public class PlayerController {

  private final FindPlayersUseCase findPlayersUseCase;
  private final FindPlayerUseCase findPlayerUseCase;
  private final CreatePlayerUseCase createPlayerUseCase;

  @Get("/api/players")
  public List<Player> findAll() {
    return findPlayersUseCase.findAll();
  }

  @Get("/api/players/{id}")
  public Player findById(@PathVariable Long id) {
    return findPlayerUseCase
        .findById(id)
        .orElseThrow(
            () ->
                new HttpStatusException(
                    HttpStatus.NOT_FOUND, String.format("Player with ID %s does not exist", id)));
  }

  @Post("/api/players")
  @Status(HttpStatus.CREATED)
  public Player create(@Body CreatePlayerRequest createPlayerRequest) {
    return createPlayerUseCase.create(createPlayerRequest);
  }
}
