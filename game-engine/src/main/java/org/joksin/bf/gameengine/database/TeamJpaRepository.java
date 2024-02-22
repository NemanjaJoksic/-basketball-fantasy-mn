package org.joksin.bf.gameengine.database;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.joksin.bf.gameengine.database.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

@Repository
interface TeamJpaRepository extends JpaRepository<TeamEntity, Long> {

  @Query(
      value =
          "from org.joksin.bf.gameengine.database.entity.TeamEntity te left join fetch te.country")
  List<TeamEntity> findAll();

  @Query(
      value =
          "from org.joksin.bf.gameengine.database.entity.TeamEntity te left join fetch te.country where te.id = :id")
  Optional<TeamEntity> findById(long id);

  boolean existsByName(String name);
}
