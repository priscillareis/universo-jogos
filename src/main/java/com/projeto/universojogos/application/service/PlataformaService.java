package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlataformaService extends GenericCrudService<Plataforma, Long> implements PlataformaInbound {

    @Autowired
    private final PlataformaOutbound plataformaOutbound;


    @Override
    protected GenericCrudOutbound<Plataforma, Long> getOutbound() {
        return plataformaOutbound;
    }
}
