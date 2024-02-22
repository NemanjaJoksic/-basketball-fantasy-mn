package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import org.joksin.bf.gameengine.validation.TeamExists;

@Introspected
public record DeleteTeamRequest(@TeamExists Long id) {}
