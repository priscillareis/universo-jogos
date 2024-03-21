package com.projeto.universojogos.application.service;

import com.projeto.universojogos.application.port.inbound.DesenvolvedoraInbound;
import com.projeto.universojogos.application.port.outbound.DesenvolvedoraOutbound;
import com.projeto.universojogos.core.domain.Desenvolvedora;
import com.projeto.universojogos.core.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesenvolvedoraService implements DesenvolvedoraInbound {

    @Autowired
    private final DesenvolvedoraOutbound desenvolvedoraOutbound;
    @Override
    public Desenvolvedora cadastrar(Desenvolvedora desenvolvedora) throws Exception {
        if(desenvolvedora == null)
            throw new ParametroInvalidoException(MensagensPadraoException.DESENVOLVEDORA_INVALIDA);

        return desenvolvedoraOutbound.salvar(desenvolvedora);
    }

    @Override
    public Desenvolvedora consultar(Desenvolvedora desenvolvedora) throws Exception {
        if(desenvolvedora == null)
            throw new ParametroInvalidoException(MensagensPadraoException.DESENVOLVEDORA_INVALIDA);

        return desenvolvedoraOutbound.consultarPorId(desenvolvedora);
    }

    @Override
    public Desenvolvedora atualizar(Desenvolvedora desenvolvedora) throws Exception {
        return null;
    }
}
