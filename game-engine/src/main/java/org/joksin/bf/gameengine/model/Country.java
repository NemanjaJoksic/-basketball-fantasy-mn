package org.joksin.bf.gameengine.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;

@Builder
@Serdeable
public record Country(Long id, String name, String code) {}
