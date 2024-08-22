package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.ManutencaoInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.ManutencaoOutbound;
import com.projeto.universojogos.core.domain.Manutencao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManutencaoService extends GenericCrudService<Manutencao, Long> implements ManutencaoInbound {

    @Autowired
    private final ManutencaoOutbound manutencaoOutbound;
    @Override
    protected GenericCrudOutbound<Manutencao, Long> getOutbound() { return manutencaoOutbound; }
}
