package org.joksin.bf.gameengine.database;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.joksin.bf.gameengine.database.entity.PlayerEntity;

import java.util.List;
import java.util.Optional;

@Repository
interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {

  @Query(
      value =
          """
          from org.joksin.bf.gameengine.database.entity.PlayerEntity pe
          left join fetch pe.team
          left join fetch pe.country
          """)
  List<PlayerEntity> findAll();

  @Query(
      value =
          """
          from org.joksin.bf.gameengine.database.entity.PlayerEntity pe
          left join fetch pe.team
          left join fetch pe.country
          where pe.id = :id
          """)
  Optional<PlayerEntity> findById(long id);

  void deleteByTeamId(long teamId);
}
