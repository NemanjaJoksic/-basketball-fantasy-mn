package org.joksin.bf.gameengine.mapper;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.TeamEntity;
import org.joksin.bf.gameengine.model.Team;

import java.util.List;

@Singleton
@AllArgsConstructor
public class TeamMapper {

  private final CountryMapper countryMapper;

  public List<Team> fromEntities(List<TeamEntity> teamEntities) {
    return teamEntities.stream().map(this::fromEntity).toList();
  }

  public Team fromEntity(TeamEntity teamEntity) {
    return Team.builder()
        .id(teamEntity.getId())
        .name(teamEntity.getName())
        .country(countryMapper.fromEntity(teamEntity.getCountry()))
        .build();
  }
}
