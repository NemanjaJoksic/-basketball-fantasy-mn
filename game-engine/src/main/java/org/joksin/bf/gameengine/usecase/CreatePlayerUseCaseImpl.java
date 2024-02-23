package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.CountryRepository;
import org.joksin.bf.gameengine.database.PlayerRepository;
import org.joksin.bf.gameengine.database.TeamRepository;
import org.joksin.bf.gameengine.database.entity.PlayerEntity;
import org.joksin.bf.gameengine.mapper.PlayerMapper;
import org.joksin.bf.gameengine.model.Player;
import org.joksin.bf.gameengine.model.request.CreatePlayerRequest;

@Singleton
@AllArgsConstructor
class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {

  private final CountryRepository countryRepository;
  private final TeamRepository teamRepository;
  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  @Override
  @Transactional
  public Player create(CreatePlayerRequest createPlayerRequest) {
    var playerEntity =
        PlayerEntity.builder()
            .name(createPlayerRequest.name())
            .number(createPlayerRequest.number())
            .position(createPlayerRequest.position())
            .height(createPlayerRequest.height())
            .born(createPlayerRequest.born())
            .country(countryRepository.findReferenceById(createPlayerRequest.countryId()))
            .team(teamRepository.findReferenceById(createPlayerRequest.teamId()))
            .build();

    var createdPlayerEntity = playerRepository.save(playerEntity);
    return playerMapper.fromEntity(createdPlayerEntity);
  }
}
