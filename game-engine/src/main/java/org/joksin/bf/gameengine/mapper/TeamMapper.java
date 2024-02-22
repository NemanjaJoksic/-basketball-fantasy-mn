package org.joksin.bf.gameengine.mapper;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.TeamEntity;
import org.joksin.bf.gameengine.model.Player;
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

  public Team fromEntityWithDetails(TeamEntity teamEntity) {
    return Team.builder()
        .id(teamEntity.getId())
        .name(teamEntity.getName())
        .country(countryMapper.fromEntity(teamEntity.getCountry()))
        .players(
            teamEntity.getPlayers().stream()
                .map(
                    playerEntity ->
                        Player.builder()
                            .id(playerEntity.getId())
                            .name(playerEntity.getName())
                            .number(playerEntity.getNumber())
                            .position(playerEntity.getPosition())
                            .born(playerEntity.getBorn())
                            .height(playerEntity.getHeight())
                            .country(countryMapper.fromEntity(playerEntity.getCountry()))
                            .build())
                .toList())
        .build();
  }
}
