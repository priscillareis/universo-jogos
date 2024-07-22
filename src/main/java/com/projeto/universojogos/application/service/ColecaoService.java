package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.ColecaoInbound;
import com.projeto.universojogos.application.port.outbound.ColecaoOutbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.Colecao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColecaoService extends GenericCrudService<Colecao, Long> implements ColecaoInbound {

    @Autowired
    private final ColecaoOutbound colecaoOutbound;

    @Override
    protected GenericCrudOutbound<Colecao, Long> getOutbound() { return colecaoOutbound; }
}
