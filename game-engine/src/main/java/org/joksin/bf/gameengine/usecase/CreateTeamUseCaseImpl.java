package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.CountryRepository;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.database.entity.TeamEntity;
import org.joksin.bf.gameengine.mapper.TeamMapper;
import org.joksin.bf.gameengine.model.Team;
import org.joksin.bf.gameengine.model.request.CreateTeamRequest;

@Singleton
@AllArgsConstructor
class CreateTeamUseCaseImpl implements CreateTeamUseCase {

  private final TeamRepository teamRepository;
  private final CountryRepository countryRepository;

  private final TeamMapper teamMapper;

  @Override
  @Transactional
  public Team create(CreateTeamRequest createTeamRequest) {
    var teamEntity =
        TeamEntity.builder()
            .name(createTeamRequest.name())
            .country(countryRepository.findReferenceById(createTeamRequest.countryId()))
            .build();

    var createdTeamEntity = teamRepository.save(teamEntity);
    return teamMapper.fromEntity(createdTeamEntity);
  }
}
