package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.application.port.outbound.PlataformaOutbound;
import com.projeto.universojogos.core.domain.Plataforma;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlataformaService implements PlataformaInbound {

    @Autowired
    private final PlataformaOutbound plataformaOutbound;

    @Override
    public Plataforma cadastrar(Plataforma plataforma) throws Exception {
        if(plataforma == null) throw new ParametroInvalidoException("Plataforma inválida");

        return plataformaOutbound.salvar(plataforma);
    }

    @Override
    public Plataforma consultar(Plataforma plataforma) throws Exception {
        if(plataforma == null) throw new ParametroInvalidoException("Plataforma inválida");

        return plataformaOutbound.consultar(plataforma);
    }

    @Override
    public Plataforma atualizar(Plataforma plataforma) throws Exception {
        if(plataforma == null) throw new ParametroInvalidoException("Plataforma inválida");

        return plataformaOutbound.atualizar(plataforma);
    }

    @Override
    public void deletar(Plataforma plataforma) throws Exception {
        plataformaOutbound.deletar(plataforma);
    }
}
