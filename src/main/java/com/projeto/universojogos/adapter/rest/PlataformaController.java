package com.projeto.universojogos.adapter.rest;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.dto.plataforma.*;
import com.projeto.universojogos.adapter.mapper.PlataformaMapper;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/plataforma")
public class PlataformaController {

    private final LoggingBase LOGGER = new LoggingBase(PlataformaController.class);
    private final PlataformaInbound plataformaInbound;

    public PlataformaController(PlataformaInbound plataformaInbound) {
        this.plataformaInbound = plataformaInbound;
    }

    @PostMapping(value = "/cadastrar")
    PlataformaResponse cadastrar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoCadastro.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Cadastro de plataforma.");

        var mapaDominio = PlataformaMapper.INSTANCE.toDomain(plataformaRequest);
        var resultadoPlataforma = plataformaInbound.cadastrar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Cadastro realizado.");

        return PlataformaMapper.INSTANCE.toResponse(resultadoPlataforma);
    }

    @GetMapping(value = "/consultar")
    PlataformaResponse consultar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoConsulta.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Consulta de plataforma.");

        var mapaDominio = PlataformaMapper.INSTANCE.toDomain(plataformaRequest);
        var resultadoPlataforma = plataformaInbound.consultarPorId(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Consulta realizada.");

        return PlataformaMapper.INSTANCE.toResponse(resultadoPlataforma);
    }

    @PutMapping(value = "/atualizar")
    PlataformaResponse atualizar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoAtualizacao.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Atualização de plataforma.");

        var mapaDominio = PlataformaMapper.INSTANCE.toDomain(plataformaRequest);
        var resultadoPlataforma = plataformaInbound.atualizar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Atualização realizada.");

        return PlataformaMapper.INSTANCE.toResponse(resultadoPlataforma);
    }

    @DeleteMapping(value = "/deletar")
    void deletar(@RequestHeader HttpHeaders headers,
                               @Validated(ValidacaoConsulta.class)
                               @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Deletar plataforma.");

        var mapaDominio = PlataformaMapper.INSTANCE.toDomain(plataformaRequest);
        plataformaInbound.deletar(mapaDominio);

        LOGGER.createInfoLog(headers, plataformaRequest,TipoLog.RESPONSE,"Deleção realizada.");

    }
}
