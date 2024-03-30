package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.DesenvolvedoraInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.DesenvolvedoraOutbound;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesenvolvedoraService extends GenericCrudService<Desenvolvedora> implements DesenvolvedoraInbound {

    @Autowired
    private final DesenvolvedoraOutbound desenvolvedoraOutbound;

    @Override
    protected GenericCrudOutbound<Desenvolvedora> getOutbound() {
        return desenvolvedoraOutbound;
    }

}
