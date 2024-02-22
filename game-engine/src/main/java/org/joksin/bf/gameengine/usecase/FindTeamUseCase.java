package org.joksin.bf.gameengine.usecase;

import org.joksin.bf.gameengine.model.Team;

import java.util.Optional;

public interface FindTeamUseCase {

  Optional<Team> findById(long id);
}
