package org.joksin.bf.gameengine.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.model.request.CreatePlayerRequest;
import org.joksin.bf.gameengine.model.request.DeletePlayerRequest;
import org.joksin.bf.gameengine.usecase.CreatePlayerUseCase;
import org.joksin.bf.gameengine.usecase.DeletePlayerUseCase;
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
  private final DeletePlayerUseCase deletePlayerUseCase;

  @Get("/api/players")
  @PermitAll
  public List<Player> findAll() {
    return findPlayersUseCase.findAll();
  }

  @Get("/api/players/{id}")
  @PermitAll
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
  @Secured(SecurityRule.IS_AUTHENTICATED)
  public Player create(@Body CreatePlayerRequest createPlayerRequest) {
    return createPlayerUseCase.create(createPlayerRequest);
  }

  @Delete("/api/players/{id}")
  @Secured(SecurityRule.IS_AUTHENTICATED)
  public void delete(@PathVariable Long id) {
    deletePlayerUseCase.delete(new DeletePlayerRequest(id));
  }
}
