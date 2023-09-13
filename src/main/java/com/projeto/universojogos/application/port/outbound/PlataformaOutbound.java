package com.projeto.universojogos.application.port.outbound;

import com.projeto.universojogos.core.domain.Plataforma;

public interface PlataformaOutbound {

    Plataforma salvar(Plataforma plataforma) throws Exception;
    Plataforma consultarPorId(Plataforma plataforma) throws Exception;
    Plataforma consultarPorNome(Plataforma plataforma) throws Exception;
    Plataforma atualizar(Plataforma plataforma) throws Exception;
    void deletar(Plataforma plataforma) throws Exception;
}
