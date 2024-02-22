package org.joksin.bf.gameengine.usecase;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.CountryRepository;
import org.joksin.bf.gameengine.mapper.CountryMapper;
import org.joksin.bf.gameengine.model.Country;

import java.util.List;

@Singleton
@AllArgsConstructor
class FindCountriesUseCaseImpl implements FindCountriesUseCase {

  private final CountryRepository countryRepository;

  private final CountryMapper countryMapper;

  @Override
  @Transactional(readOnly = true)
  public List<Country> findAll() {
    var countryEntities = countryRepository.findAll();
    return countryMapper.fromEntities(countryEntities);
  }
}
