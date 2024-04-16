package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.game.GameRequest;
import com.projeto.universojogos.adapter.dto.game.GameResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.game.GameMapper;
import com.projeto.universojogos.application.port.inbound.GameInbound;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.core.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/game")
public class GameController extends GenericCrudController<Game, Long, GameRequest,
        GameResponse> {

    @Autowired
    private GameInbound gameInbound;
    @Override
    public GenericCrudInbound<Game, Long> getService() {
        return gameInbound;
    }

    @Override
    public GenericMapper<GameRequest, GameResponse, Game> getMapper() {
        return GameMapper.INSTANCE;
    }
}
