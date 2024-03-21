package com.projeto.universojogos.application.port.inbound;

import com.projeto.universojogos.core.domain.Desenvolvedora;

public interface DesenvolvedoraInbound {

    Desenvolvedora cadastrar(Desenvolvedora desenvolvedora) throws Exception;

    Desenvolvedora consultar(Desenvolvedora desenvolvedora) throws Exception;

    Desenvolvedora atualizar(Desenvolvedora desenvolvedora) throws Exception;
}
