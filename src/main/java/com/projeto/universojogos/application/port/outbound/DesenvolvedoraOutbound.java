package com.projeto.universojogos.application.port.outbound;

import com.projeto.universojogos.core.domain.Desenvolvedora;

public interface DesenvolvedoraOutbound {

    Desenvolvedora salvar(Desenvolvedora desenvolvedora) throws Exception;

    Desenvolvedora consultarPorId(Desenvolvedora desenvolvedora) throws Exception;

    Desenvolvedora atualizar(Desenvolvedora desenvolvedora) throws Exception;

    void deletar(Desenvolvedora desenvolvedora);
}
