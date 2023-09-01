package com.projeto.universojogos.application.service;

import com.projeto.universojogos.adapter.persistence.PlataformaDatastore;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Plataforma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlataformaService implements PlataformaInbound {

    @Autowired
    private final PlataformaDatastore plataformaDatastore;

    @Override
    public Plataforma cadastrar(Plataforma plataforma) throws Exception {
        return plataformaDatastore.salvar(plataforma);
    }

    @Override
    public Plataforma consultar(Plataforma plataforma) throws Exception {
        return plataformaDatastore.consultar(plataforma);
    }

    @Override
    public Plataforma atualizar(Plataforma plataforma) throws Exception {
        return plataformaDatastore.atualizar(plataforma);
    }
}
