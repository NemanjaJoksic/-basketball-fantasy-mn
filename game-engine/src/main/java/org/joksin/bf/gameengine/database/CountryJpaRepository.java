package org.joksin.bf.gameengine.database;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.joksin.bf.gameengine.database.entity.CountryEntity;

@Repository
interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {}
