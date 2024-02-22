package org.joksin.bf.gameengine.database;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.CountryEntity;

import java.util.List;

@Singleton
@AllArgsConstructor
class CountryRepositoryImpl implements CountryRepository {

  private final CountryJpaRepository countryJpaRepository;

  @Override
  public List<CountryEntity> findAll() {
    return countryJpaRepository.findAll();
  }

  @Override
  public boolean existsById(long id) {
    return countryJpaRepository.existsById(id);
  }
}
