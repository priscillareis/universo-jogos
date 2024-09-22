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
import java.util.List;

public abstract class GenericCrudController<Dominio, ID extends Serializable, Request, Response> {

    public abstract GenericCrudInbound<Dominio, ID> getService();

    public abstract GenericMapper<Request, Response, Dominio> getMapper();
    private final LoggingBase LOGGER = new LoggingBase("Controller");

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<Response>> consultartodos(@RequestHeader HttpHeaders headers) throws Exception{
        LOGGER.createInfoLog(headers, "sem body", TipoLog.REQUEST,"Consulta todos.");

        var resultado = getService().consultarTodos();
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Consulta Realizada.");

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Response> save(@RequestHeader HttpHeaders headers,
                                         @Validated(ValidacaoCadastro.class)
                                         @RequestBody Request request) throws Exception {

        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Cadastro.");

        var dominio = getMapper().toDomain(request);
        var resultado = getService().cadastrar(dominio);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Cadastro Realizado.");

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Response> consultar(@RequestHeader HttpHeaders headers,
                                              @Validated(ValidacaoConsulta.class)
                                              @PathVariable ID id) throws Exception{
        LOGGER.createInfoLog(headers, id, TipoLog.REQUEST,"Consulta.");

        var resultado = getService().consultar(id);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Consulta Realizada.");

        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Response> atualizar(@RequestHeader HttpHeaders headers,
                                              @Validated(ValidacaoAtualizacao.class)
                                              @RequestBody Request request,
                                              @PathVariable ID id) throws Exception{
        LOGGER.createInfoLog(headers, request, TipoLog.REQUEST,"Atualização.");

        var dominio = getMapper().toDomain(request);
        var resultado = getService().atualizar(id, dominio);
        var response = getMapper().toResponse(resultado);

        LOGGER.createInfoLog(headers, response, TipoLog.RESPONSE,"Atualização Realizada.");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletar(@RequestHeader HttpHeaders headers,
                                              @Validated(ValidacaoConsulta.class)
                                              @PathVariable ID id) throws Exception{
        LOGGER.createInfoLog(headers, id, TipoLog.REQUEST,"Delete.");

        getService().deletar(id);

        LOGGER.createInfoLog(headers, "sem retorno.", TipoLog.RESPONSE,"Deleção Realizada.");

    }
}
