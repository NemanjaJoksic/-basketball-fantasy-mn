package org.joksin.bf.gameengine.database;

import org.joksin.bf.gameengine.database.entity.CountryEntity;

import java.util.List;

public interface CountryRepository {

  List<CountryEntity> findAll();

  CountryEntity findReferenceById(long id);

  boolean existsById(long id);
}
