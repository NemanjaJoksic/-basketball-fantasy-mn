package org.joksin.bf.gameengine.mapper;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.PlayerEntity;
import org.joksin.bf.gameengine.model.Player;

import java.util.List;

@Singleton
@AllArgsConstructor
public class PlayerMapper {

  private final CountryMapper countryMapper;
  private final TeamMapper teamMapper;

  public List<Player> fromEntities(List<PlayerEntity> playerEntities) {
    return playerEntities.stream().map(this::fromEntity).toList();
  }

  public Player fromEntity(PlayerEntity playerEntity) {
    return Player.builder()
        .id(playerEntity.getId())
        .name(playerEntity.getName())
        .number(playerEntity.getNumber())
        .height(playerEntity.getHeight())
        .born(playerEntity.getBorn())
        .position(playerEntity.getPosition())
        .country(countryMapper.fromEntity(playerEntity.getCountry()))
        .team(teamMapper.fromEntity(playerEntity.getTeam()))
        .build();
  }
}
