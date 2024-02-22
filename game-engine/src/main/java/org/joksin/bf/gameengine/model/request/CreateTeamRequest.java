package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.joksin.bf.gameengine.validation.CountryExists;
import org.joksin.bf.gameengine.validation.TeamNameNotExist;

@Introspected
@Serdeable
public record CreateTeamRequest(@NotBlank @TeamNameNotExist String name, @NotNull @CountryExists Long countryId) {}
