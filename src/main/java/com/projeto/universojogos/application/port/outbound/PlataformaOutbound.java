package com.projeto.universojogos.application.port.outbound;

import com.projeto.universojogos.core.domain.Plataforma;

public interface PlataformaOutbound {

    Plataforma salvar(Plataforma plataforma) throws Exception;
    Plataforma consultar(Plataforma plataforma) throws Exception;
    Plataforma atualizar(Plataforma plataforma) throws Exception;
}
