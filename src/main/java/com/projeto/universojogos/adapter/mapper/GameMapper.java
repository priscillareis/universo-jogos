package com.projeto.universojogos.adapter.mapper;

import com.projeto.universojogos.adapter.dto.game.GameRequest;
import com.projeto.universojogos.adapter.dto.game.GameResponse;
import com.projeto.universojogos.core.domain.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper extends GenericMapper<GameRequest, GameResponse, Game> {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    Game toDomain(GameRequest gameRequest);

    GameResponse toResponse(Game game);
}
