package com.projeto.universojogos.adapter.rest;

import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.dto.ConsoleRequest;
import com.projeto.universojogos.adapter.dto.ConsoleResponse;
import com.projeto.universojogos.adapter.mapper.ConsoleMapper;
import com.projeto.universojogos.application.port.inbound.ConsoleInbound;
import com.projeto.universojogos.core.domain.Console;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {

    private final LoggingBase LOGGER = new LoggingBase(ConsoleController.class);

    private final ConsoleInbound consoleInbound;

    public ConsoleController(ConsoleInbound consoleInbound) {
        this.consoleInbound = consoleInbound;
    }


    @PostMapping(value = "/cadastrar")
    ConsoleResponse cadastrar(@RequestHeader HttpHeaders headers,
                              @Validated(ValidacaoCadastro.class)
                              @RequestBody ConsoleRequest consoleRequest) throws Exception {
        LOGGER.createInfoLog(headers, consoleRequest, TipoLog.REQUEST,"Cadastro de console.");

        var mapaDominio = ConsoleMapper.INSTANCE.toDomain(consoleRequest);
        var resultadoConsole = consoleInbound.cadastrar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoConsole,TipoLog.RESPONSE,"Consulta realizada.");

        return ConsoleMapper.INSTANCE.toResponse(resultadoConsole);

    }
}
