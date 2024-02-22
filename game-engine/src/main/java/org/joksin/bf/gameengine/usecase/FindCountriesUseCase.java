package org.joksin.bf.gameengine.usecase;

import org.joksin.bf.gameengine.model.Country;

import java.util.List;

public interface FindCountriesUseCase {

  List<Country> findAll();
}
