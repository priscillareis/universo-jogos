package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.mapper.GenericMapper;
import com.projeto.universojogos.application.port.inbound.GenericCrudInbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class GenericCrudController<T, ID extends Serializable, MT1, MT2> {

    public abstract GenericCrudInbound<T, ID> getService();

    public abstract GenericMapper<MT1, MT2, T> getMapper();
    private final LoggingBase LOGGER = new LoggingBase("Controller");

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<MT2> save(@RequestHeader HttpHeaders headers,
                                  @Validated(ValidacaoCadastro.class)
                                  @RequestBody MT1 request) throws Exception {

        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Cadastro.");

        var dominio = getMapper().toDomain(request);
        var resultado = getService().cadastrar(dominio);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Cadastro Realizado.");

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/consultar")
    public ResponseEntity<MT2> consultar(@RequestHeader HttpHeaders headers,
                                         @Validated(ValidacaoConsulta.class)
                                         @RequestBody ID request) throws Exception{
        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Consulta.");

        var resultado = getService().consultar(request);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Consulta Realizada.");

        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<MT2> atualizar(@RequestHeader HttpHeaders headers,
                                         @Validated(ValidacaoAtualizacao.class)
                                         @RequestBody MT1 request,
                                         @PathVariable ID id) throws Exception{
        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Atualização.");

        var dominio = getMapper().toDomain(request);
        var resultado = getService().atualizar(id, dominio);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Atualização Realizada.");

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/deletar")
    public ResponseEntity<HttpStatus> deletar(@RequestHeader HttpHeaders headers,
                                              @Validated(ValidacaoConsulta.class)
                                         @RequestBody ID request) throws Exception{
        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Delete.");

        getService().deletar(request);

        LOGGER.createInfoLog(headers, "sem retorno.", TipoLog.RESPONSE,"Deleção Realizada.");

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
