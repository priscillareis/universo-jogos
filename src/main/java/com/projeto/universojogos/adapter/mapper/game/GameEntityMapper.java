package com.projeto.universojogos.adapter.mapper.game;

import com.projeto.universojogos.adapter.mapper.GenericEntityMapper;
import com.projeto.universojogos.adapter.persistence.entity.GameEntity;
import com.projeto.universojogos.core.domain.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameEntityMapper extends GenericEntityMapper<Game, GameEntity> {

    GameEntityMapper INSTANCE = Mappers.getMapper(GameEntityMapper.class);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    Game toDomain(GameEntity gameEntity);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    GameEntity toEntity(Game game);
}
