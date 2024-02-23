package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import org.joksin.bf.gameengine.validation.PlayerExists;

@Introspected
public record DeletePlayerRequest(@PlayerExists Long id) {}
