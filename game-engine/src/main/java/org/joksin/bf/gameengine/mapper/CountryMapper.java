package org.joksin.bf.gameengine.mapper;

import jakarta.inject.Singleton;
import org.joksin.bf.gameengine.database.entity.CountryEntity;
import org.joksin.bf.gameengine.model.Country;

import java.util.List;

@Singleton
public class CountryMapper {

  public List<Country> fromEntities(List<CountryEntity> countryEntities) {
    return countryEntities.stream().map(this::fromEntity).toList();
  }

  public Country fromEntity(CountryEntity countryEntity) {
    return Country.builder()
        .id(countryEntity.getId())
        .name(countryEntity.getName())
        .code(countryEntity.getCode())
        .build();
  }
}
