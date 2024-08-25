package com.projeto.universojogos.adapter.mapper.game;

import com.projeto.universojogos.adapter.dto.game.GameRequest;
import com.projeto.universojogos.adapter.dto.game.GameResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.core.domain.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GameMapper extends GenericMapper<GameRequest, GameResponse, Game> {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    Game toDomain(GameRequest gameRequest);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    GameResponse toResponse(Game game);

    @Mapping(target = "dataAquisicao", source = "dataAquisicao", dateFormat = "dd/MM/yyyy")
    List<GameResponse> toResponse(List<Game> game);
}
