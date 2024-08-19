package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.RegistroGameInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.RegistroGameOutbound;
import com.projeto.universojogos.core.domain.RegistroGame;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistroGameService extends GenericCrudService<RegistroGame, Long> implements RegistroGameInbound {
    @Autowired
    private final RegistroGameOutbound registroGameOutbound;

    @Override
    protected GenericCrudOutbound<RegistroGame, Long> getOutbound() {
        return registroGameOutbound;
    }
}
