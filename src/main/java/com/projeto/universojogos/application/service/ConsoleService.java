package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.ConsoleInbound;
import com.projeto.universojogos.application.port.outbound.ConsoleOutbound;
import com.projeto.universojogos.core.domain.Console;
import com.projeto.universojogos.core.exception.MensagensPadraoException;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsoleService implements ConsoleInbound {

    @Autowired
    private final ConsoleOutbound consoleOutbound;

    @Override
    public Console cadastrar(Console console) throws Exception {
        if(console == null) throw new ParametroInvalidoException(MensagensPadraoException.CONSOLE_INVALIDO);

        return consoleOutbound.salvar(console);
    }

    @Override
    public Console consultar(Console console) throws Exception {
        if(console == null) throw new ParametroInvalidoException(MensagensPadraoException.CONSOLE_INVALIDO);

        return consoleOutbound.consultarPorId(console);
    }

    @Override
    public Console atualizar(Console console) throws Exception {
        if(console == null) throw new ParametroInvalidoException(MensagensPadraoException.CONSOLE_INVALIDO);

        return consoleOutbound.atualizar(console);
    }

    @Override
    public void deletar(Console console) throws Exception {
        consoleOutbound.deletar(console);
    }
}
