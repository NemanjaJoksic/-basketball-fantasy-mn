package org.joksin.bf.gameengine.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import org.joksin.bf.gameengine.model.enums.PlayerPosition;

import java.util.Date;

@Builder
@Serdeable
public record Player(
    Long id,
    String name,
    Integer number,
    Double height,
    PlayerPosition position,
    Date born,
    Country country,
    Team team) {}
