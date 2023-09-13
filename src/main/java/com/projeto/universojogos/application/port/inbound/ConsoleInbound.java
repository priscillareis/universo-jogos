package com.projeto.universojogos.application.port.inbound;

import com.projeto.universojogos.core.domain.Console;

public interface ConsoleInbound {

    Console cadastrar(Console console) throws Exception;
    Console consultar(Console console) throws Exception;
    Console atualizar(Console console) throws Exception;
    void deletar(Console console) throws Exception;
}
