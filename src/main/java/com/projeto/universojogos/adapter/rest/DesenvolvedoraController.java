package com.projeto.universojogos.adapter.rest;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.desenvolvedora.*;
import com.projeto.universojogos.adapter.mapper.DesenvolvedoraMapper;
import com.projeto.universojogos.application.port.inbound.DesenvolvedoraInbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/desenvolvedora")
public class DesenvolvedoraController {

    private final LoggingBase LOGGER = new LoggingBase(DesenvolvedoraController.class);

    private final DesenvolvedoraInbound desenvolvedoraInbound;

    public DesenvolvedoraController(DesenvolvedoraInbound desenvolvedoraInbound) {
        this.desenvolvedoraInbound = desenvolvedoraInbound;
    }

    @PostMapping(value = "/cadastrar")
    DesenvolvedoraResponse cadastrar(@RequestHeader HttpHeaders headers,
                                     @Validated(ValidacaoCadastro.class)
                                     @RequestBody DesenvolvedoraRequest desenvolvedoraRequest) throws Exception {
        LOGGER.createInfoLog(headers, desenvolvedoraRequest, TipoLog.REQUEST,"Cadastro de desenvolvedora.");

        var mapaDominio = DesenvolvedoraMapper.INSTANCE.toDomain(desenvolvedoraRequest);
        var resultadoDesenvolvedora = desenvolvedoraInbound.cadastrar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoDesenvolvedora,TipoLog.RESPONSE,"Cadastro realizado.");

        return DesenvolvedoraMapper.INSTANCE.toResponse(resultadoDesenvolvedora);
    }

}
