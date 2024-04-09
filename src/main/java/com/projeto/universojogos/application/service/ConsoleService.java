package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.ConsoleInbound;
import com.projeto.universojogos.application.port.outbound.ConsoleOutbound;
import com.projeto.universojogos.application.port.outbound.GenericCrudOutbound;
import com.projeto.universojogos.core.domain.Console;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsoleService extends GenericCrudService<Console, Long> implements ConsoleInbound {

    @Autowired
    private final ConsoleOutbound consoleOutbound;


    @Override
    protected GenericCrudOutbound<Console, Long> getOutbound() { return consoleOutbound; }
}
