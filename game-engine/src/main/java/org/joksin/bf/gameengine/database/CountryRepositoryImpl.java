package org.joksin.bf.gameengine.database;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.CountryEntity;

import java.util.List;

@Singleton
@AllArgsConstructor
class CountryRepositoryImpl implements CountryRepository {

  private final CountryJpaRepository countryJpaRepository;

  private final EntityManager entityManager;

  @Override
  public List<CountryEntity> findAll() {
    return countryJpaRepository.findAll();
  }

  @Override
  public CountryEntity findReferenceById(long id) {
    return entityManager.getReference(CountryEntity.class, id);
  }

  @Override
  public boolean existsById(long id) {
    return countryJpaRepository.existsById(id);
  }
}
