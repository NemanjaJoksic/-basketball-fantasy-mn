package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.joksin.bf.gameengine.model.enums.PlayerPosition;
import org.joksin.bf.gameengine.validation.CountryExists;
import org.joksin.bf.gameengine.validation.TeamExists;

import java.time.LocalDate;

@Serdeable
@Introspected
public record CreatePlayerRequest(
    @NotBlank String name,
    @NotNull Integer number,
    @NotNull Double height,
    @NotNull PlayerPosition position,
    @NotNull LocalDate born,
    @CountryExists Long countryId,
    @TeamExists Long teamId) {}
