package com.projeto.universojogos.application.port.inbound;

import com.projeto.universojogos.core.domain.Plataforma;

public interface PlataformaInbound {

    Plataforma cadastrar(Plataforma plataforma);
    Plataforma consultar(Plataforma plataforma) throws Exception;
}
