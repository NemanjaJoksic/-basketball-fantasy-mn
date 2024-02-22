package org.joksin.bf.gameengine.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;

@Builder
@Serdeable
public record Team(Long id, String name, Country country) {}
