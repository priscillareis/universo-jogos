package com.projeto.universojogos.adapter.rest;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class GenericCrudController<T, ID extends Serializable,MT1, MT2> {

    public abstract GenericCrudInbound<T> getService();

    public abstract GenericMapper<MT1, MT2, T> getMapper();
    private LoggingBase LOGGER = new LoggingBase("Controller");

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<MT2> save(@RequestHeader HttpHeaders headers,
                                  @Validated(ValidacaoCadastro.class)
                                  @RequestBody MT1 request) throws Exception {

        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Cadastro.");

        var dominio = getMapper().toDomain(request);
        var resultado = getService().save(dominio);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Cadastro Realizado.");

        return ResponseEntity.ok(response);
    }
}
