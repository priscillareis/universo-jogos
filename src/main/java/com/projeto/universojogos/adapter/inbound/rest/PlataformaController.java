package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.config.validation.ValidacaoAtualizacao;
import com.projeto.universojogos.adapter.config.validation.ValidacaoCadastro;
import com.projeto.universojogos.adapter.config.validation.ValidacaoConsulta;
import com.projeto.universojogos.adapter.dto.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.PlataformaResponse;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Plataforma;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/plataforma")
public class PlataformaController {

    private final Logger LOGGER = Logger.getLogger(PlataformaController.class.getSimpleName());

    protected ModelMapper modelMapper = new ModelMapper();
    private final PlataformaInbound plataformaInbound;

    public PlataformaController(PlataformaInbound plataformaInbound) {
        this.plataformaInbound = plataformaInbound;
    }

    @PostMapping(value = "/cadastrar")
    PlataformaResponse cadastrar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoCadastro.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        // TODO - Logs com o header
        LOGGER.log(Level.INFO,"Cadastro de plataforma. Plataforma: "+plataformaRequest.getNome(),headers);

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        var result = plataformaInbound.cadastrar(domain);

        LOGGER.log(Level.INFO,"Cadastro realizado. ID: "+result.getId()+", Nome: "+result.getNome(),headers);

        return modelMapper.map(result, PlataformaResponse.class);
    }

    @GetMapping(value = "/consultar")
    PlataformaResponse consultar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoConsulta.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.log(Level.INFO,"Consulta de plataforma. ID recebido: "+plataformaRequest.getId(),headers);

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        var result = plataformaInbound.consultar(domain);

        LOGGER.log(Level.INFO,"Consulta realizada. ID: "+result.getId()+", Nome: "+result.getNome(),headers);

        return modelMapper.map(result, PlataformaResponse.class);
    }

    @PutMapping(value = "/atualizar")
    PlataformaResponse atualizar(@RequestHeader HttpHeaders headers,
                                 @Validated(ValidacaoAtualizacao.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {
        LOGGER.log(Level.INFO,"Atualização de plataforma. Plataforma: "+plataformaRequest.getId(),headers);

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        var result = plataformaInbound.atualizar(domain);

        LOGGER.log(Level.INFO,"Atualização realizada. ID: "+result.getId()+", Nome: "+result.getNome(),headers);

        return modelMapper.map(result, PlataformaResponse.class);
    }

    @DeleteMapping(value = "/deletar")
    void deletar(@RequestHeader HttpHeaders headers,
                               @Validated(ValidacaoConsulta.class)
                               @RequestBody PlataformaRequest plataformaRequest) throws Exception {

        LOGGER.log(Level.INFO,"Deletar plataforma. ID recebido: "+plataformaRequest.getId(),headers);

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        plataformaInbound.deletar(domain);

        LOGGER.log(Level.INFO,"Deleção realizada. ID: "+domain.getId(),headers);

    }
}
