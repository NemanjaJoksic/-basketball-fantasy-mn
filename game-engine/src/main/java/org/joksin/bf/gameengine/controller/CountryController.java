package org.joksin.bf.gameengine.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joksin.bf.gameengine.model.Country;
import org.joksin.bf.gameengine.usecase.FindCountriesUseCase;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@ExecuteOn(TaskExecutors.BLOCKING)
public class CountryController {

  private final FindCountriesUseCase findCountriesUseCase;

  @Get("/api/countries")
  @PermitAll
  public List<Country> findAll() {
    log.info("Getting all countries");
    return findCountriesUseCase.findAll();
  }
}
