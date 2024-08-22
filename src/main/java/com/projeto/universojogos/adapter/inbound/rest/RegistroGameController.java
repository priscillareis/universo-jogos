package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.dto.registroGame.RegistroGameRequest;
import com.projeto.universojogos.adapter.dto.registroGame.RegistroGameResponse;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.adapter.mapper.registroGame.RegistroGameMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.application.port.inbound.RegistroGameInbound;
import com.projeto.universojogos.core.domain.RegistroGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registro_game")
public class RegistroGameController extends GenericCrudController<RegistroGame, Long, RegistroGameRequest,
        RegistroGameResponse> {

    @Autowired
    private RegistroGameInbound registroGameInbound;

    @Override
    public GenericCrudInbound<RegistroGame, Long> getService() {
        return registroGameInbound;
    }

    @Override
    public GenericMapper<RegistroGameRequest, RegistroGameResponse, RegistroGame> getMapper() {
        return RegistroGameMapper.INSTANCE;
    }
}
