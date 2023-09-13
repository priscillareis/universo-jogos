package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.ConsoleInbound;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Console;
import com.projeto.universojogos.core.exception.ParametroInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsoleService implements ConsoleInbound {

    @Autowired
    private final PlataformaInbound plataformaInbound;

    @Override
    public Console cadastrar(Console console) throws Exception {
        if(console.getPlataforma().getId() != null){
            console.setPlataforma(plataformaInbound.consultarPorId(console.getPlataforma()));
        } else if (console.getPlataforma().getNome() != null) {
            console.setPlataforma(plataformaInbound.consultarPorNome(console.getPlataforma()));
        } else {
            throw new ParametroInvalidoException("Plataforma inválida");
        }

        return null;
    }

    @Override
    public Console consultar(Console console) {
        return null;
    }

    @Override
    public Console atualizar(Console console) {
        return null;
    }

    @Override
    public void deletar(Console console) {

    }
}
