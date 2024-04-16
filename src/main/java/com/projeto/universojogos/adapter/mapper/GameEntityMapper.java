package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.persistence.entity.GameEntity;
import com.projeto.universojogos.core.domain.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameEntityMapper extends GenericEntityMapper<Game, GameEntity> {

    GameEntityMapper INSTANCE = Mappers.getMapper(GameEntityMapper.class);

    Game toDomain(GameEntity gameEntity);

    GameEntity toEntity(Game game);
}
