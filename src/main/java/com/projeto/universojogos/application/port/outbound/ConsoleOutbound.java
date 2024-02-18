package com.projeto.universojogos.application.port.outbound;

import com.projeto.universojogos.core.domain.Console;

public interface ConsoleOutbound {

    Console salvar(Console console) throws Exception;

    Console consultarPorId(int id) throws Exception;
}
