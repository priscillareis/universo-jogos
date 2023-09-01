package com.projeto.universojogos.adapter.inbound.rest;

import com.projeto.universojogos.adapter.config.validation.PlataformaCadastrar;
import com.projeto.universojogos.adapter.config.validation.PlataformaConsultar;
import com.projeto.universojogos.adapter.dto.PlataformaRequest;
import com.projeto.universojogos.adapter.dto.PlataformaResponse;
import com.projeto.universojogos.application.port.inbound.PlataformaInbound;
import com.projeto.universojogos.core.domain.Plataforma;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/plataforma")
public class PlataformaController {

    private final Logger LOGGER = Logger.getLogger(PlataformaController.class.getName());

    protected ModelMapper modelMapper = new ModelMapper();
    private final PlataformaInbound plataformaInbound;

    public PlataformaController(PlataformaInbound plataformaInbound) {
        this.plataformaInbound = plataformaInbound;
    }

    @PostMapping(value = "/cadastrar")
    PlataformaResponse cadastrar(@Validated(PlataformaCadastrar.class)
                                 @RequestBody PlataformaRequest plataformaRequest){
        LOGGER.info("Cadastro de plataforma recebido. Plataforma: "+plataformaRequest.getNome());

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        var result = plataformaInbound.cadastrar(domain);

        LOGGER.info("Cadastro realizado. ID: "+result.getId()+", Nome: "+result.getNome());

        return modelMapper.map(result, PlataformaResponse.class);
    }

    @GetMapping(value = "/consultar")
    PlataformaResponse consultar(@Validated(PlataformaConsultar.class)
                                 @RequestBody PlataformaRequest plataformaRequest) throws Exception {
        LOGGER.info("Consulta de plataforma recebido. ID recebido: "+plataformaRequest.getId());

        var domain = modelMapper.map(plataformaRequest, Plataforma.class);
        var result = plataformaInbound.consultar(domain);

        LOGGER.info("Consulta realizado. ID: "+result.getId()+", Nome: "+result.getNome());

        return modelMapper.map(result, PlataformaResponse.class);
    }
}
