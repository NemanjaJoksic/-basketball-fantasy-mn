package org.joksin.bf.gameengine.database;

import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.joksin.bf.gameengine.database.entity.PlayerEntity;

import java.util.List;
import java.util.Optional;

@Singleton
@AllArgsConstructor
class PlayerRepositoryImpl implements PlayerRepository {

    private final PlayerJpaRepository playerJpaRepository;

    @Override
    public List<PlayerEntity> findAll() {
        return playerJpaRepository.findAll();
    }

    @Override
    public Optional<PlayerEntity> findById(long id) {
        return playerJpaRepository.findById(id);
    }
}
