package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.convert.format.Format;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.joksin.bf.gameengine.model.enums.PlayerPosition;
import org.joksin.bf.gameengine.validation.CountryExists;
import org.joksin.bf.gameengine.validation.TeamExists;

import java.util.Date;

@Serdeable
@Introspected
public record CreatePlayerRequest(
    @NotBlank String name,
    @NotNull Integer number,
    @NotNull Double height,
    @NotNull PlayerPosition position,
    @NotNull @Format("yyyy-MM-dd") Date born,
    @CountryExists Long countryId,
    @TeamExists Long teamId) {}
