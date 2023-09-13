package com.projeto.universojogos.application.port.inbound;

import com.projeto.universojogos.core.domain.Plataforma;

public interface PlataformaInbound {

    Plataforma cadastrar(Plataforma plataforma) throws Exception;
    Plataforma consultarPorId(Plataforma plataforma) throws Exception;
    Plataforma consultarPorNome(Plataforma plataforma) throws Exception;
    Plataforma atualizar(Plataforma plataforma) throws Exception;
    void deletar(Plataforma plataforma) throws Exception;
}
