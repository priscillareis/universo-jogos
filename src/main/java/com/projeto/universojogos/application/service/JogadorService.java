package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.JogadorInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.JogadorOutbound;
import com.projeto.universojogos.core.domain.Jogador;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JogadorService extends GenericCrudService<Jogador, Long> implements JogadorInbound {

    @Autowired
    private final JogadorOutbound jogadorOutbound;

    @Override
    protected GenericCrudOutbound<Jogador, Long> getOutbound() { return jogadorOutbound; }
}
