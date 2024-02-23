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
import org.joksin.bf.gameengine.model.Team;
import org.joksin.bf.gameengine.model.request.CreateTeamRequest;
import org.joksin.bf.gameengine.model.request.DeleteTeamRequest;
import org.joksin.bf.gameengine.usecase.CreateTeamUseCase;
import org.joksin.bf.gameengine.usecase.DeleteTeamUseCase;
import org.joksin.bf.gameengine.usecase.FindTeamUseCase;
import org.joksin.bf.gameengine.usecase.FindTeamsUseCase;

import java.util.List;

@Controller
@AllArgsConstructor
@ExecuteOn(TaskExecutors.BLOCKING)
public class TeamController {

  private final FindTeamsUseCase findTeamsUseCase;
  private final FindTeamUseCase findTeamUseCase;
  private final CreateTeamUseCase createTeamUseCase;
  private final DeleteTeamUseCase deleteTeamUseCase;

  @Get("/api/teams")
  @PermitAll
  public List<Team> findAll() {
    return findTeamsUseCase.findAll();
  }

  @Get("/api/teams/{id}")
  @PermitAll
  public Team findById(@PathVariable Long id) {
    return findTeamUseCase
        .findById(id)
        .orElseThrow(
            () ->
                new HttpStatusException(
                    HttpStatus.NOT_FOUND, String.format("Team with ID %s does not exist", id)));
  }

  @Post("/api/teams")
  @Status(HttpStatus.CREATED)
  @Secured(SecurityRule.IS_AUTHENTICATED)
  public Team create(@Body CreateTeamRequest createTeamRequest) {
    return createTeamUseCase.create(createTeamRequest);
  }

  @Delete("/api/teams/{id}")
  @Secured(SecurityRule.IS_AUTHENTICATED)
  public void delete(@PathVariable Long id) {
    deleteTeamUseCase.delete(new DeleteTeamRequest(id));
  }
}
