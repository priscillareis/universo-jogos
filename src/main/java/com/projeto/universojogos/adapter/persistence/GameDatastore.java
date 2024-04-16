package com.projeto.universojogos.adapter.persistence;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.mapper.game.GameEntityMapper;
import com.projeto.universojogos.adapter.outbound.GameRepository;
import com.projeto.universojogos.adapter.persistence.entity.GameEntity;
import com.projeto.universojogos.application.port.outbound.GameOutbound;
import com.projeto.universojogos.core.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class GameDatastore extends GenericCrudDatastore<Game, Long, GameEntity> implements GameOutbound {

    @Autowired
    private GameRepository gameRepository;
    @Override
    protected JpaRepository<GameEntity, Long> getRepository() {
        return gameRepository;
    }

    @Override
    public GenericEntityMapper<Game, GameEntity> getMapper() {
        return GameEntityMapper.INSTANCE;
    }
}
