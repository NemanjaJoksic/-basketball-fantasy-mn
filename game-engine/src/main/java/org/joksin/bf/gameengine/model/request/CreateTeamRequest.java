package org.joksin.bf.gameengine.model.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import org.joksin.bf.gameengine.validation.CountryExists;
import org.joksin.bf.gameengine.validation.TeamNameNotExist;

@Introspected
@Serdeable
public record CreateTeamRequest(@TeamNameNotExist String name, @CountryExists Long countryId) {}
