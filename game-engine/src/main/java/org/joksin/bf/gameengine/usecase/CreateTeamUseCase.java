package org.joksin.bf.gameengine.usecase;

import jakarta.validation.Valid;
import org.joksin.bf.gameengine.model.Team;
import org.joksin.bf.gameengine.model.request.CreateTeamRequest;

public interface CreateTeamUseCase {

    Team create(@Valid CreateTeamRequest createTeamRequest);
}
