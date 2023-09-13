package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.config.validation.*;
import com.projeto.universojogos.adapter.dto.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.PlataformaResponse;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Plataforma;
import com.projeto.universojogos.core.domain.TipoLog;
import com.projeto.universojogos.core.util.LoggingBase;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/plataforma")
public class PlataformaController {

    private final LoggingBase LOGGER = new LoggingBase(PlataformaController.class);

    protected ModelMapper modelMapper = new ModelMapper();
    private final PlataformaInbound plataformaInbound;

    public PlataformaController(PlataformaInbound plataformaInbound) {
        this.plataformaInbound = plataformaInbound;
    }

    @PostMapping(value = "/cadastrar")
    PlataformaResponse cadastrar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoCadastro.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Cadastro de plataforma.");

        var mapaDominio = modelMapper.map(plataformaRequest, Plataforma.class);
        var resultadoPlataforma = plataformaInbound.cadastrar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Cadastro realizado.");

        return modelMapper.map(resultadoPlataforma, PlataformaResponse.class);
    }

    @GetMapping(value = "/consultar")
    PlataformaResponse consultar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoConsulta.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Consulta de plataforma.");

        var mapaDominio = modelMapper.map(plataformaRequest, Plataforma.class);
        var resultadoPlataforma = plataformaInbound.consultarPorId(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Consulta realizada.");

        return modelMapper.map(resultadoPlataforma, PlataformaResponse.class);
    }

    @PutMapping(value = "/atualizar")
    PlataformaResponse atualizar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoAtualizacao.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Atualização de plataforma.");

        var mapaDominio = modelMapper.map(plataformaRequest, Plataforma.class);
        var resultadoPlataforma = plataformaInbound.atualizar(mapaDominio);

        LOGGER.createInfoLog(headers, resultadoPlataforma,TipoLog.RESPONSE,"Atualização realizada.");

        return modelMapper.map(resultadoPlataforma, PlataformaResponse.class);
    }

    @DeleteMapping(value = "/deletar")
    void deletar(@RequestHeader HttpHeaders headers,
                               @Validated(ValidacaoConsulta.class)
                               @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.createInfoLog(headers, plataformaRequest, TipoLog.REQUEST,"Deletar plataforma.");

        var mapaDominio = modelMapper.map(plataformaRequest, Plataforma.class);
        plataformaInbound.deletar(mapaDominio);

        LOGGER.createInfoLog(headers, plataformaRequest,TipoLog.RESPONSE,"Deleção realizada.");

    }
}
