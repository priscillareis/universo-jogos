package com.projeto.universojogos.application.port.inbound;

import com.projeto.universojogos.core.domain.Plataforma;

public interface PlataformaInbound {

    Plataforma cadastrar(Plataforma plataforma) throws Exception;
    Plataforma consultar(Plataforma plataforma) throws Exception;
    Plataforma atualizar(Plataforma plataforma) throws Exception;
}
