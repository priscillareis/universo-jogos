package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.GameInbound;
import com.projeto.universojogos.application.port.outbound.GameOutbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService extends GenericCrudService<Game, Long> implements GameInbound {

    @Autowired
    private GameOutbound gameOutbound;
    @Override
    protected GenericCrudOutbound<Game, Long> getOutbound() {
        return gameOutbound;
    }
}
